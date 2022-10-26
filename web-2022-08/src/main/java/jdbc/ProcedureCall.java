package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;

public class ProcedureCall {
	
	public ProcedureCall() {
		Connection conn = new DBConn().getConn();
		
		try {
			String sql = "{call hap(?, ?, ?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, 10);
			cs.setInt(2, 20);
			cs.registerOutParameter(3, java.sql.JDBCType.INTEGER);
			
			cs.executeQuery();
			int h = cs.getInt(3);
			System.out.println(h);
			
			cs.close();
			conn.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void getPhone() {
		Connection conn = new DBConn().getConn();
		
		try {
			String sql = "{call getPhone(?, ?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, 1002);
			cs.registerOutParameter(2, java.sql.JDBCType.VARCHAR);
			
			cs.executeQuery();
			String p = cs.getString(2);
			System.out.println(p);
			
			cs.close();
			conn.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ProcedureCall().getPhone();
	}

}
