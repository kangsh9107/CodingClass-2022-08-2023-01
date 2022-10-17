package collection;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Properties;

public class PropertyEx {
	
	public void store() throws IOException {
		File f = new File("my.ini"); // 파일 이름은 마음대로
		if(!f.exists()) {
			f.createNewFile();
		}
		
		Properties prop = new Properties();
		prop.setProperty("id"   , "a001");
		prop.setProperty("irum" , "홍길동");
		prop.setProperty("phone", "02-1111-1111");
		
		// 그냥 f.getPath(); 해도 작동하지만 중간에 한글 폴더가 껴있으면 인코딩이 깨지는 경우가 있다.
		String path = URLDecoder.decode(f.getPath(), "utf-8");
		System.out.println("path : " + path);
		
		FileWriter fw = new FileWriter(path);
		prop.store(fw, "");
		fw.close();
	}
	
	/*
	 *  throws Exception은 에러.
	 *  Exception이 부모라서 그렇다.
	 *  ex) class P{}
	 *      class C extends P{}
	 *      
	 *      P c1 = new C(); // 가능
	 *      C c2 = new P(); // 불가능
	 *      
	 *      강아지는 동물이다 -> 가능 , 동물은 강아지다 -> 에러
	 */
	public void load() throws IOException {
		String path = "my.ini";
		path = URLDecoder.decode(path, "utf-8");
		FileReader fr = new FileReader(path);
		Properties prop = new Properties();
		prop.load(fr);
		
		System.out.println("id : "    + prop.getProperty("id"));
		System.out.println("irum : "  + prop.getProperty("irum"));
		System.out.println("phone : " + prop.getProperty("phone"));
		fr.close();
	}
	
	public static void main(String[] args) {
		try {
			new PropertyEx().load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}









