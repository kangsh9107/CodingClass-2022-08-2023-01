package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Employee {
	Connection conn;
	
	public Employee() {
		this.conn = new DBConn().getConn();
	}
	
	public static void main(String[] args) {
		Employee e = new Employee();
		try {
			//e.insert();
			//e.select();
			//e.update();
			e.delete();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void insert() throws Exception {
		conn = new DBConn().getConn();
		conn.setAutoCommit(false); // 자동 커밋되어 데이터베이스에 바로 반영되면 문제가 생긴다
		
		String sql = "insert into test(id, name) values(?,?)"; // prearedStatement로 쓰지 않으면 ?에 +hong+, +111+, ... 로 값을 쭉 써야한다.
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "d001"); // 제로베이스가 아니라 원베이스
		ps.setString(2, "김씨");  // 인코딩 안하면 한글은 에러.
		
		int cnt = ps.executeUpdate();
		if(cnt > 0) conn.commit(); // 삭제가 10건이면 10 반환. 즉 cnt가 0보다 크면 정상적으로 실행된 것.
		else        conn.rollback();
		
		ps.close();
		conn.close();
	}
	
	public void select() throws Exception {
		conn = new DBConn().getConn(); // 생성자에서 실행했지만 insert랑 같이 실행할 경우 insert에서 close하기 때문에 다시 실행해야 함.
		
		String sql = "select * from test"; // ex. from where id = ?
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery(); // ResultSet은 반환형이 ResultSet이고 이게 명시적 커서다.
		while(rs.next()) {
			String id = rs.getString("id"); // 커서명.getString("필드명");
			String name = rs.getString("name");
			System.out.printf("%s (%s)\n", id, name);
		}
		
		ps.close();
		conn.close();
	}
	
	public void update() throws Exception {
		conn = new DBConn().getConn();
		conn.setAutoCommit(false);
		
		String sql = "update test set name=? where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "나씨");
		ps.setString(2, "c001");
		
		int cnt = ps.executeUpdate();
		if(cnt > 0) conn.commit();
		else        conn.rollback();
		
		select();
		
		ps.close(); // 닫아야 메모리를 낭비하지 않는다
		conn.close();
	}
	
	public void delete() throws Exception {
		conn = new DBConn().getConn();
		conn.setAutoCommit(false);
		
		String sql = "delete from test where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "a001");
		
		int cnt = ps.executeUpdate();
		if(cnt > 0) {
			System.out.println("삭제완료");
			conn.commit();
		} else {
			System.out.println("삭제할 자료가 없습니다");
			conn.rollback();
		}
		
		select();
		
		ps.close();
		conn.close();
	}
}









