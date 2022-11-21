package student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.DBConn;

public class StudentDao {
	Connection conn;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public StudentDao() {
		try {
			conn = new DBConn("mydb").getConn();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void close() { // rs, ps, conn close
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(conn != null) conn.close();
			
			rs = null;
			ps = null;
			conn = null;
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	public boolean insert(StudentVo vo) {
		if(conn == null) conn = new DBConn("mydb").getConn();
		
		boolean b = false;
		String sql = "insert into student(id, name, gender, pwd, phone, "
				   + "                    postalCode, address, address2, email) "
				   + "            values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getName());
			ps.setString(3, vo.getGender());
			ps.setString(4, vo.getPwd());
			ps.setString(5, vo.getPhone());
			ps.setString(6, vo.getPostalCode());
			ps.setString(7, vo.getAddress());
			ps.setString(8, vo.getAddress2());
			ps.setString(9, vo.getEmail());
			
			int cnt = ps.executeUpdate();
			
			if(cnt > 0) {
				conn.commit();
				b = true;
			} else {
				conn.rollback();
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return b;
	}
	
	public List<StudentVo> select(Page pageVo) {
		if(conn == null) conn = new DBConn("mydb").getConn();
		
		List<StudentVo> list = new ArrayList<>();
		String sql = "";
		
		try {
			/* 검색된 전체 건수를 가져온다 */
			// 검색된 전체 건수를 가져오는 where 조건은 검색의 where 조건과 같아야 한다
			sql = "select count(id) totSize from student "
				+ "where id like ? "
				+ "or    name like ? "
				+ "or    phone like ? "
				+ "or    address like ? "
				+ "or    address2 like ? "
				+ "or    email like ?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + pageVo.getFindStr() + "%");
			ps.setString(2, "%" + pageVo.getFindStr() + "%");
			ps.setString(3, "%" + pageVo.getFindStr() + "%");
			ps.setString(4, "%" + pageVo.getFindStr() + "%");
			ps.setString(5, "%" + pageVo.getFindStr() + "%");
			ps.setString(6, "%" + pageVo.getFindStr() + "%");
			System.out.println("dao : " + pageVo.getTotSize());
			rs = ps.executeQuery();
			rs.next();
			int totSize = rs.getInt("totSize");
			pageVo.setTotSize(totSize);
			pageVo.compute();
			
			/* 검색 */
			sql = "select * from student "
				+ "where id like ? " // %?%이라고 쓰면 %'abc'%가 되어 에러
				+ "or    name like ? "
				+ "or    phone like ? "
				+ "or    address like ? "
				+ "or    address2 like ? "
				+ "or    email like ? "
				+ "order by id "
				+ "limit ?, ?";
		
			//conn.setAutoCommit(false); // DML이 아니라 DQL이라 굳이 필요 없다
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + pageVo.getFindStr() + "%");
			ps.setString(2, "%" + pageVo.getFindStr() + "%");
			ps.setString(3, "%" + pageVo.getFindStr() + "%");
			ps.setString(4, "%" + pageVo.getFindStr() + "%");
			ps.setString(5, "%" + pageVo.getFindStr() + "%");
			ps.setString(6, "%" + pageVo.getFindStr() + "%");
			ps.setInt(7, pageVo.getStartNo());
			ps.setInt(8, pageVo.getListSize());
			
			rs = ps.executeQuery();
			while(rs.next()) {
				StudentVo vo = new StudentVo();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setGender(rs.getString("gender"));
				vo.setPhone(rs.getString("phone"));
				vo.setPostalCode(rs.getString("postalCode"));
				vo.setAddress(rs.getString("address"));
				vo.setAddress2(rs.getString("address2"));
				vo.setEmail(rs.getString("email"));
				
				list.add(vo);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		close();
		return list;
	}
	
	public StudentVo view(String id) {
		if(conn == null) conn = new DBConn("mydb").getConn();
		
		StudentVo vo = new StudentVo();
		String sql = "select * from student where id = ?";
		
		try {
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setGender(rs.getString("gender"));
				vo.setPhone(rs.getString("phone"));
				vo.setPostalCode(rs.getString("postalCode"));
				vo.setAddress(rs.getString("address"));
				vo.setAddress2(rs.getString("address2"));
				vo.setEmail(rs.getString("email"));
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		close();
		return vo;
	}
	
	public boolean modify(StudentVo sVo) {
		if(conn == null) conn = new DBConn("mydb").getConn();
		
		boolean b = false;
		String sql = "update student set name = ?, gender = ?, phone = ?, "
				   + "postalCode = ?, address = ?, address2 = ?, email = ? "
				   + "where id = ? and pwd = ?";
		
		try {
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			ps.setString(1, sVo.getName());
			ps.setString(2, sVo.getGender());
			ps.setString(3, sVo.getPhone());
			ps.setString(4, sVo.getPostalCode());
			ps.setString(5, sVo.getAddress());
			ps.setString(6, sVo.getAddress2());
			ps.setString(7, sVo.getEmail());
			ps.setString(8, sVo.getId());
			ps.setString(9, sVo.getPwd());
			
			int cnt = ps.executeUpdate();
			if(cnt > 0) {
				b = true;
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return b;
	}
	
	public boolean delete(StudentVo sVo) {
		if(conn == null) conn = new DBConn("mydb").getConn();
		
		boolean b = false;
		String sql = "delete from student where id = ? and pwd = ?";
		
		try {
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			ps.setString(1, sVo.getId());
			ps.setString(2, sVo.getPwd());
			
			int cnt = ps.executeUpdate();
			if(cnt > 0) {
				b = true;
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return b;
	}
	
}
