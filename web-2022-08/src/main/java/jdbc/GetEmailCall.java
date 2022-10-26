package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;

public class GetEmailCall {

	public static void main(String[] args) {
		Connection conn = new DBConn().getConn();
		
		/*
		 * SELECT email INTO em FROM employees
		 * WHERE lastName LIKE concat("%", lName, "%")
		 * AND   firstName LIKE concat("%", fName, "%");
		 */
		try {
			conn.setAutoCommit(false);
			
			String sql = "{call GetEmail(?, ?, ?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, "Murphy");
			cs.setString(2, "Diane");
			cs.registerOutParameter(3, java.sql.JDBCType.VARCHAR);
			
			cs.executeQuery();
			String em = cs.getString(3);
			System.out.println(em);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
