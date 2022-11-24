package findpwd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jdbc.DBConn;

public class FindPwdDao {
	Connection      conn = null;
	PreparedStatement ps = null;
	ResultSet         rs = null;
	String           sql = "";
	
	public FindPwdDao() {
		try {
			conn = new DBConn("mydb").getConn();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void close() {
		try {
			if(rs   != null) rs.close();
			if(ps   != null) ps.close();
			if(conn != null) conn.close();
			
			rs   = null;
			ps   = null;
			conn = null;
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public String findPwd(FindPwdVo vo) {
		if(conn == null) conn = new DBConn("mydb").getConn();
		
		String content = "";
		
		try {
			sql = "select pwd from student where id = ? and email = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getEmail());
			
			rs = ps.executeQuery();
			while(rs.next()) {
				content += rs.getString("pwd");
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return content;
	}

}
