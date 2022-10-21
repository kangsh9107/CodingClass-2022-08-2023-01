package test;

import java.io.Serializable;

public class Data implements Serializable {
	public static long serialVersionUID = 100L;
	
	String id;
	String mName;
	String addr;
	String phone;
	int point;
	
	public Data(String id, String mName, String addr, String phone,
				int point) {
		this.id = id;
		this.mName = mName;
		this.addr = addr;
		this.phone = phone;
		this.point = point;
	}
	
    @Override
    public String toString() {
        String temp = "\n---------------"
                + "\nid : " + this.id
                + "\nname : " + this.mName
                + "\naddress : " + this.addr
                + "\nphone : " + this.phone
                + "\npoint : " + this.point;
        return temp;
    }
}
