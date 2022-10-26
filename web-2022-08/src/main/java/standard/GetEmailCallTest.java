package standard;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import jdbc.DBConn;

public class GetEmailCallTest {

	public static void main(String[] args) {
		Connection conn = new DBConn().getConn();
		
		try {
			conn.setAutoCommit(false);
			
			String sql = "{call test3(?, ?, ?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, "M");
			cs.setString(2, "M");
			cs.registerOutParameter(3, java.sql.JDBCType.LONGVARCHAR);
			
			cs.executeQuery();
			String em = cs.getString(3);
			System.out.println(em);
			
			/*
			String sql = "{call test5(?, ?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, "M");
			cs.setString(2, "M");
			
			ResultSet rs = cs.executeQuery();
			while(rs.next()) {
				String temp = rs.getString("str");
				System.out.println(temp);
			}
			*/
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
