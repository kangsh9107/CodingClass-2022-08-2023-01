import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/chatting")
public class WebSocketServer {                      // public은 불특정 다수 사용가능. private은 
	
	private static Set<Session> clients =
			Collections.synchronizedSet(new HashSet<Session>());
	
	@OnOpen
	public void onOpen(Session s) {                 // Session이 open될 때 메소드.
		System.out.println("session open.....");
		clients.add(s);
	}
	
	@OnClose
	public void onClose(Session s) {                // Session은 이름 못 바꾼다. 브라우저 정보 등등이 다 Session 타고 들어옴. s는 이름 바꿀 수 있음.
		System.out.println("session close.....");
		clients.remove(s);
	}
	
	@OnMessage
	public void onMessage(String msg, Session s) throws IOException {  // Session에서 온 msg를 넣어서 메소드 실행.
		System.out.println("messagge : " + msg);
		for(Session ss : clients) {
			ss.getBasicRemote().sendText(msg);
		}
	}

}
