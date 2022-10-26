package net;

import java.net.InetAddress;

public class Net1 {
	
	public static void main(String[] args) {
		try {
			System.out.println("Local Host...");
			InetAddress n1 = InetAddress.getLocalHost();
			System.out.println("host name : " + n1.getHostName());
			System.out.println("address : " + n1.getHostAddress());
			
			System.out.println();
			System.out.println("Network Host...");
			InetAddress n2 = InetAddress.getByName("www.naver.com");
			System.out.println("host name : " + n2.getHostName());
			System.out.println("address : " + n2.getHostAddress());
			
			System.out.println();
			n2 = InetAddress.getByName("www.google.com");
			System.out.println("host name : " + n2.getHostName());
			System.out.println("address : " + n2.getHostAddress());
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
