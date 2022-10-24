package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class MemberDto {
	Connection conn;
	
	public int insert(MemberVo vo) {
		int cnt = 0;
		
		conn = new DBConn("mydb").getConn();
		try {
			conn.setAutoCommit(false);
			String sql = "insert into member(id, name, gender, phone, picture, mdate)"
					   + " values(?,?,?,?,?,now())"; // 공백 하나 넣어야 오류 방지
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getIrum());
			ps.setString(3, vo.getGender());
			ps.setString(4, vo.getPhone());
			ps.setString(5, vo.getPicture());
			
			cnt = ps.executeUpdate();
			if(cnt > 0) conn.commit();
			else        conn.rollback();
			
			ps.close();
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return cnt;
	}
	
	public int update(MemberVo vo) {
		int cnt = 0;
		
		return cnt;
	}
	
	public int delete(String id) {
		int cnt = 0;
		
		return cnt;
	}
	
	public Vector<Vector> select(String findStr) {
		Vector<Vector> list = new Vector<>();
		
		try {
			conn = new DBConn("mydb").getConn();
			
			String sql = "select * from member " // 띄어쓰기 없으면 memberwhere라는 테이블로 인식
					   + "where id like ? "
					   + "or    name like ? "
					   + "or    phone like ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			// like '%a%' : a가 포함되어 있는
			// like 'a%' : a로 시작하는
			ps.setString(1, "%" + findStr + "%");
			ps.setString(2, "%" + findStr + "%");
			ps.setString(3, "%" + findStr + "%");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("name"));
				v.add(rs.getString("gender"));
				v.add(rs.getString("phone"));
				v.add(rs.getString("mdate"));
				list.add(v);
			}
		} catch(Exception ex) {
			
		}
		
		return list;
	}

}
