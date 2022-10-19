package iostream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectStreamEx2 {
	
	List<Score> list = new ArrayList<>();
	String fileName = "object2.obj";
	
	public void write() throws Exception {
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		Score s1 = new Score("aaaa", 90, 70, 80);
		Score s2 = new Score("bbbb", 60, 50, 30);
		Score s3 = new Score("cccc", 40, 55, 88);
		Score s4 = new Score("dddd", 99, 100, 30);
		Score s5 = new Score("eeee", 2, 59, 34);
		list.addAll(Arrays.asList(s1, s2, s3, s4, s5));
		
		oos.writeObject(list);
		oos.close();
		fos.close();
	}
	
	public void read() throws Exception {
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		List<Score> readData = (List<Score>) ois.readObject();
		for(Score s : readData) {
			System.out.println(s);
		}
		
		// 람다식 표현
//		list.forEach(x -> System.out.println(x));
		
		// 람다식 풀어 쓰면 이렇다
//		function(x) {
//			System.out.println(x);
//		}
		
		ois.close();
		fis.close();
	}
	
	public static void main(String[] args) {
		ObjectStreamEx2 ex2 = new ObjectStreamEx2();
		try {
			ex2.write();
			ex2.read();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
