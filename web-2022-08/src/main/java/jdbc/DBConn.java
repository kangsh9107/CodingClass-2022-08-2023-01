package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
	String driver = "com.mysql.cj.jdbc.Driver"; // 드라이버명 (상수)
	String path = "jdbc:mysql://localhost:3306/classicmodels"
				+ "?useUnicode=true&characterEncoding=utf8";
	String user = "hong";
	String pwd = "1111";
	Connection conn;
	
	public Connection getConn() { // conn getter
		return conn;
	}

	public DBConn() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(path, user, pwd);
			System.out.println("connection ok");
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		DBConn dbcon = new DBConn();
	}
}
