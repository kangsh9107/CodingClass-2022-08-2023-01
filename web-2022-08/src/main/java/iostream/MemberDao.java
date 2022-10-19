package iostream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Vector;

public class MemberDao {
	
	public String fileName = "member.obj";
	List<Data> list = new Vector<Data>();
	ObjectOutputStream oos;
	ObjectInputStream ois;
	
	public MemberDao() {
		list = read();
	}

	public void write(Data d) {
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			
			list.add(d);
			oos.writeObject(list);
			oos.flush();
			oos.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Data> read() {
		/*
		 * List<Data> list = new Vector<Data>();로 하지 않은 이유는
		 * 쓸데없이 객체를 한번 더 만들어서 메모리를 차지하지 않게 하려고.
		 * 가비지콜렉션이 실행되기 전까지 계속 메모리를 점유하고 있게 된다.
		 */
		// List<Data> list = null; // 필드에 저장 하는 게 더 낫다.
		
		try {
			FileInputStream fis = new FileInputStream(fileName);
			ois = new ObjectInputStream(fis);
			list = (List<Data>)ois.readObject();
			
			ois.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void modify() {
		
	}
	
	public void delete() {
		
	}
	
	public void view() {
		
	}
	
}









