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
