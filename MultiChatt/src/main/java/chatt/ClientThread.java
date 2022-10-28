package chatt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.HashSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ClientThread extends Thread {
	ClientMain main;
	BufferedWriter bw;
	BufferedReader br;
	Socket socket;
	boolean flag;
	
	public ClientThread(Socket s, ClientMain m) {
		this.main = m;
		this.socket = s;
		
		try {
			OutputStreamWriter osw = new OutputStreamWriter(s.getOutputStream());
			bw = new BufferedWriter(osw);
			
			InputStreamReader isr = new InputStreamReader(s.getInputStream());
			br = new BufferedReader(isr);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void run() {
		JSONParser jParser = new JSONParser();
		//System.out.println("main.getTfUser : " + main.getTfUser().getText()); // 출력OK
		
		// 1) 서버에게 자신의 LOGIN 사실을 전달
		JSONObject loginObj = new JSONObject();
		loginObj.put("user", main.getTfUser().getText());
		loginObj.put("command", ServerMain.LOGIN);
		loginObj.put("message", "나다");
		//System.out.println("loginObj.toJSONString : " + loginObj.toJSONString()); // 출력OK
		
		try {
			bw.write(loginObj.toJSONString() + "\n"); // \n를 넣지 않으면 오류. br이 엔터를 안만나면 계속 blocking모드라서
			bw.flush();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		flag = true;
		while(flag) {
			try {
				String msg = br.readLine();
				//System.out.println("ClientThread : " + msg);
				
				JSONObject obj = (JSONObject)jParser.parse(msg);

				if(!obj.get("message").equals("")) {
					main.getTextArea().append(obj.get("message") + "\n");
				}
				main.getTextArea()
					.setCaretPosition(main.getTextArea().getText().length());
				
				Long o = (Long)obj.get("command");
				switch(o.intValue()) {
				case ServerMain.SERVER_STOP:
					flag = false;
					break;
				case ServerMain.USERS:
					JSONArray array = (JSONArray)obj.get("data");
					main.users.clear();
					for(Object ob : array) {
						main.users.add((String)ob);
					}
					main.getList().setListData(main.users);
					break;
				case ServerMain.LOGIN:
					String u = (String)obj.get("user");
					main.users.add(u);
					main.getList().setListData(main.users);
					break;
				}
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		
		try {
			br.close();
			bw.close();
			socket.close();
			
			main.getBtnConnect().setEnabled(true);
			main.getBtnDisconnect().setEnabled(false);
			main.getBtnSend().setEnabled(false);
			main.getBtnWhisper().setEnabled(false);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void sendMsg(String msg) {
		try {
			JSONObject obj = new JSONObject();
			obj.put("user", main.getTfUser().getText());
			obj.put("command", ServerMain.MESSAGE);
			obj.put("message", msg);
			bw.write(obj.toJSONString() + "\n");
			bw.flush();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
