package webpractice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jdbc.DBConn;

public class LoginP221031 {
	
	public boolean login(String mId, String pwd) {
		boolean b = false;
		
		try {
			Connection conn = new DBConn("mydb").getConn();
			String sql = "select * from member where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, mId);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				b = true;
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return b;
	}

}
