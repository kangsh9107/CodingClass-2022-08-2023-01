package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import security.AES;

public class Login {
	
	public boolean login(String mId, String pwd) {
		boolean b = false;
		AES aes = new AES();
		
		try {
			Connection conn = new DBConn("mydb").getConn();
			String sql = "select * from student where id = ? and pwd = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, mId);
			ps.setString(2, aes.encrypt(pwd));
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) { // mId에 해당하는 아이디가 데이터 베이스에 있다면
				b = true;
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		System.out.println(b);
		return b;
	}
	
	public static void main(String[] args) {
		new Login().login("a001", "");
	}

}
