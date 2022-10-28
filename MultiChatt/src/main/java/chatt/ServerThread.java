package chatt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

// msg 송수신 부분 UI랑 분리 && 단독으로 Thread를 가지고 있어야 편하다
// 서버에 클라이언트가 접속했을 때 클라이언트마다 단독 스레드 생성해서 거기서 만든 소켓으로
// 클라이언트가 만든 소켓과 1:1로 통신한다
public class ServerThread extends Thread {
	ServerMain main; // textArea 불러오기 편하게 main을 선언한다
	BufferedWriter bw;
	BufferedReader br;
	Socket socket;
	boolean flag;
	
	public ServerThread(Socket s, ServerMain m) {
		this.main = m;
		this.socket = s;
		
		try {
			OutputStream os = s.getOutputStream(); // 인풋스트림 먼저 만들면 가끔 오류 난다
			OutputStreamWriter osw = new OutputStreamWriter(os);
			bw = new BufferedWriter(osw);
			
			InputStream is = s.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	// thread가 없으면 대기상태에서 프로그램이 먹통 된다
	// msg 송수신
	public void run() {
		JSONParser jParser = new JSONParser();
		flag = true;
		
		while(flag) {
			try {
				String msg = br.readLine(); // blocking mode(엔터를 입력받으면 풀림)
											// c1이 st1에 데이터를 주고, 그걸 읽는다
											// c2가 st1에 데이터를 줄 수 없다
											// toJSONString으로 받아서 JSON구조다
				//System.out.println("ServerThread : " + msg);
				
				JSONObject obj = (JSONObject)jParser.parse(msg);
				main.getTextArea().append(obj.get("message") + "\n");
				//main.getTextArea().append(msg + "\n");
				
				// 스크롤바를 맨 하단으로
				main.getTextArea()
					.setCaretPosition(main.getTextArea().getText().length());
				
				// 모든 클라이언트에게 메시지 전달
				//sendMsgAll(msg);
				
				Long o = (Long)obj.get("command");
				switch(o.intValue()) {
				case ServerMain.LOGOUT:
					main.clients.remove(this); // 자기 자신 제거
					flag = false;
					break;
				case ServerMain.LOGIN:
					String u = (String)obj.get("user");
					
					// 자기 자신에게 users에 저장된 모든 목록을 전송
					JSONObject usersObj = new JSONObject();
					usersObj.put("command", ServerMain.USERS);
					usersObj.put("user", "server");
					usersObj.put("message", "");
					usersObj.put("data", main.users);
					
					bw.write(usersObj.toJSONString() + "\n");
					bw.flush();
					
					//JSONArray array = new JSONArray();
					//array.addAll(main.users);
					/*
					for(String s : main.users) {
						array.add(s);
					}
					usersObj.put("data", array);
					 */
					
					// 접속된 모든 유저에게 신규유저의 아이디를 전송
					JSONObject newObj = new JSONObject();
					newObj.put("command", ServerMain.LOGIN);
					newObj.put("user", u);
					newObj.put("message", u + " 님이 접속함");
					
					sendMsgAll(newObj.toJSONString());
					
					main.users.add(u);
					main.getList().setListData(main.users);
					main.getList().updateUI();
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
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/*
	public void sendMsg(String msg) {
		try {
			bw.write(msg + "\n");
			bw.flush();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	*/

	public void sendMsgAll(String msg) {
		for(ServerThread st : main.clients) {
			try {
				st.bw.write(msg + "\n");
				st.bw.flush();
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}

}
