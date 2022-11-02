package student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.DBConn;

public class StudentDao {
	
	Connection conn;
	
	public StudentDao() {
		try {
			conn = new DBConn("mydb").getConn();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	public boolean insert(StudentVo vo) {
		boolean b = false;
		String sql = "insert into student(id, name, gender, pwd, phone, "
				   + "                    postalCode, address, address2, email) "
				   + "            values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql);
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
			
			ps.close();
			conn.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return b;
	}
	
	public List<StudentVo> select(Page pageVo) {
		List<StudentVo> list = new ArrayList<>();
		
		String sql = "select * from student "
				   + "where id like ? " // %?%이라고 쓰면 %'abc'%가 되어 에러
				   + "or    name like ? "
				   + "or    phone like ? "
				   + "or    address like ? "
				   + "or    address2 like ? "
				   + "or    email like ? "
				   + "order by name";
		
		try {
			//conn.setAutoCommit(false); // DML이 아니라 DQL이라 굳이 필요 없다
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + pageVo.getFindStr() + "%");
			ps.setString(2, "%" + pageVo.getFindStr() + "%");
			ps.setString(3, "%" + pageVo.getFindStr() + "%");
			ps.setString(4, "%" + pageVo.getFindStr() + "%");
			ps.setString(5, "%" + pageVo.getFindStr() + "%");
			ps.setString(6, "%" + pageVo.getFindStr() + "%");
			
			ResultSet rs = ps.executeQuery();
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
			
			ps.close();
			conn.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return list;
	}
	
}
