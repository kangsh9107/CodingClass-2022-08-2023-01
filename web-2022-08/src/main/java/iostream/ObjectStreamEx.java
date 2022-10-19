package iostream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectStreamEx {
	
	List<Data> list = new ArrayList<>();
	String fileName = "object.obj";
	
	public void write() throws Exception { // 예외 처리는 각각 하는 게 정석. exception은 너무 포괄적이다
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		Data d1 = new Data("aaaa", "hong", "서울", "010-1111", 90);
		Data d2 = new Data("bbbb", "kim", "인천", "010-2222", 70);
		Data d3 = new Data("cccc", "park", "부산", "010-3333", 80);
		Data d4 = new Data("dddd", "nam", "대구", "010-4444", 60);
		list.addAll(Arrays.asList(d1, d2, d3, d4));
		
		oos.writeObject(list);
		oos.close(); // close는 마지막에 열린 것부터 처음 열린 것 순으로 한다
		fos.close();
	}
	
	public void read() throws Exception {
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		List<Data> readData = (List<Data>) ois.readObject();
		for(Data d : readData) {
			System.out.println(d);
		}
		ois.close();
		fis.close();
	}
	
	public static void main(String[] args) {
		ObjectStreamEx ex = new ObjectStreamEx();
		try {
			ex.write();
			ex.read();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
