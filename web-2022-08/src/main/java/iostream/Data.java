package iostream;

import java.io.Serializable;
import java.util.Vector;

public class Data implements Serializable {
	
	public static long serialVerisionUID = 100L; // 1L이나 다른 숫자도 상관없다
	String id, mName, addr, phone;
	int point;
	
	public Data() {}
	
	public Data(String id, String mName, String addr, String phone,
				int point) {
		this.id    = id;
		this.mName = mName;
		this.addr  = addr;
		this.phone = phone;
		this.point = point;
	}
	
	// JTable의 데이터 속성이 Vector<Vector>
	public Vector getVector() {
		Vector v = new Vector();
		v.add(id);
		v.add(mName);
		v.add(addr);
		v.add(phone);
		v.add(point);
		
		return v;
	}

	// 콘솔창 테스트용
	@Override
	public String toString() {
		String temp = "\n----------"
					+ "\nid : "      + this.id
					+ "\nname : "    + this.mName
					+ "\naddress : " + this.addr
					+ "\nphone : "   + this.phone
					+ "\npoint : "   + this.point;
		return temp;
	}

	@Override
	public int hashCode() {
		return this.id.hashCode(); // 기본 hashCode : 패키지명.클래스명@자신의hashCode
	}

	@Override
	public boolean equals(Object obj) {
		boolean b = false;
		
		if(obj instanceof Data) {
			Data d = (Data)obj;
			b = d.getId().equals(this.id);
		}
		
		return b;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
}









