package net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class UrlEx {
	
	public static void main(String[] args) {
		String domain = "http://192.168.219.140:8888/web-2022-08/index.jsp";
		
		try {
			URL url = new URL(domain);
			InputStream is = url.openStream();
			InputStreamReader isr = new InputStreamReader(is); // byte 스트림에서 character 스트림으로 바뀜
			// cpu에 비해 주변 장치는 굉장히 느리다.
			// 그래서 버퍼에 담고 cpu가 다른일도 할 수 있게 해준다.
			BufferedReader br = new BufferedReader(isr);
			String data = "";
			
			/*
			이렇게는 잘 안쓴다
			while(true) {
				data = br.readLine();
				if(data == null) break;
			}
			 */
			while((data=br.readLine()) != null) {
				System.out.println(data);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
