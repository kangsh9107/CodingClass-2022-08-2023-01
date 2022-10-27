package net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
	
	public TcpServer() throws Exception { // 호출한 놈에게 던진다
		// 1) ServerSocket 생성
		ServerSocket server = new ServerSocket(4444); // 포트 번호는 충돌만 없으면 아무거나 가능
		
		// 2) client의 접속을 기다림
		System.out.println("접속대기");
		Socket socket = server.accept(); // blocking mode
		//System.out.println("이 메시지가 나오지 않으면 대기상태");
		
		// 3) client가 접속하면 IOStream 생성
		OutputStream os = socket.getOutputStream(); // InputStream을 먼저 만들면 가끔 오류날 수 있음
		InputStream is = socket.getInputStream(); // byte 스트림
		
		// 아웃풋스트림과 인풋스트림만으로도 byte단위 통신이 가능하지만
		// 한글이 깨지거나 귀찮은 경우들이 생기니 character단위로 바꿔서 통신하는게 좋다
		// 단, 이미지, 음성, 영상, 워드, 엑셀 등은 byte로 전송해야 한다.
		OutputStreamWriter osw = new OutputStreamWriter(os); // character 스트림
		BufferedWriter bw = new BufferedWriter(osw);
		
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		while(true) {
			// 4) 수신된 메시지를 표시
			// br과 bw를 만들었기 때문에 입출력이 편하다
			String msg = br.readLine();
			System.out.println("수신 메시지 : " + msg);
			
			if(msg.equals("exit")) break;
			
			// 5) client한테 메시지 전송 (에코서버)
			msg = "서버가 재전송함 : " + msg;
			bw.write(msg);
			bw.write("\n");
			bw.flush();
		}
			
			br.close();
			isr.close();
			is.close();
			
			bw.close();
			osw.close();
			os.close();
			
			socket.close();
			server.close();
	}

	public static void main(String[] args) throws Exception { // 던짐 받은걸 또 던짐. 여기선 가상머신에 던진다
		new TcpServer();
	}

}
