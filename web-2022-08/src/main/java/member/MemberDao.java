package member;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import jdbc.DBConn;
import servlet.MemberFileUploadServlet;

public class MemberDao {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	public MemberDao() {
		conn = new DBConn("mydb").getConn();
	}
	
	public String insert(MemberVo vo) {
		String msg = "";
		String sql = "insert into member(id, name, gender, phone, sysFile, oriFile) "
				   + "values(?, ?, ?, ?, ?, ?)";
		
		try {
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getName());
			ps.setString(3, vo.getGender());
			ps.setString(4, vo.getPhone());
			ps.setString(5, vo.getSysFile());
			ps.setString(6, vo.getOriFile());
			
			int cnt = ps.executeUpdate();
			if(cnt > 0) {
				conn.commit();
				msg = "저장 성공😀😀";
			} else {
				conn.rollback();
				msg = "저장 오류😢😢";
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return msg;
	}
	
	public JSONArray select(String findStr) {
		JSONArray array = new JSONArray();
		String sql = "select * from member "
				   + "where id like ? "
				   + "or    phone like ? "
				   + "or    name  like ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + findStr + "%");
			ps.setString(2, "%" + findStr + "%");
			ps.setString(3, "%" + findStr + "%");
			
			rs = ps.executeQuery();
			while(rs.next()) {
				JSONObject obj = new JSONObject();
				obj.put("id", rs.getString("id"));
				obj.put("name", rs.getString("name"));
				obj.put("gender", rs.getString("gender"));
				obj.put("phone", rs.getString("phone"));
				obj.put("sysFile", rs.getString("sysFile"));
				obj.put("oriFile", rs.getString("oriFile"));
				
				array.add(obj);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return array;
	}
	
	public JSONObject view(String id) {
		JSONObject obj = new JSONObject();
		String sql = "select * from member where id = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				obj.put("id", rs.getString("id"));
				obj.put("name", rs.getString("name"));
				obj.put("gender", rs.getString("gender"));
				obj.put("phone", rs.getString("phone"));
				obj.put("sysFile", rs.getString("sysFile"));
				obj.put("oriFile", rs.getString("oriFile"));
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return obj;
	}
	
	public String update(MemberVo vo) {
		String msg = "dao update";
		
		try {
			// 파일삭제
			if( !vo.getSysFile().equals("") ) {
				File delFile = new File(MemberFileUploadServlet.path + vo.getDelFile());
				
				if(delFile.exists()) delFile.delete();
			}
			
			// table update
			conn.setAutoCommit(false);
			if( !vo.getSysFile().equals("") ) { // 수정할 파일을 선택한 경우
				String sql = "update member set name    = ?, "
						   + "                  gender  = ?, "
						   + "                  phone   = ?, "
						   + "                  sysFile = ?, "
						   + "                  oriFile = ?  "
						   + "where id = ?";
				
				ps = conn.prepareStatement(sql);
				ps.setString(1, vo.getName());
				ps.setString(2, vo.getGender());
				ps.setString(3, vo.getPhone());
				ps.setString(4, vo.getSysFile());
				ps.setString(5, vo.getOriFile());
				ps.setString(6, vo.getId());
			} else {
				String sql = "update member set name    = ?, "
						   + "                  gender  = ?, "
						   + "                  phone   = ?  "
						   + "where id = ?";
				
				ps = conn.prepareStatement(sql);
				ps.setString(1, vo.getName());
				ps.setString(2, vo.getGender());
				ps.setString(3, vo.getPhone());
				ps.setString(4, vo.getId());
			}
			
			int cnt = ps.executeUpdate();
			if(cnt > 0) {
				if( !vo.getSysFile().equals("") ) {
					File delFile = new File(MemberFileUploadServlet.path + vo.getDelFile());
				
					if(delFile.exists()) delFile.delete();
				}
				
				conn.commit();
				msg = "수정 완료😀😀";
			} else {
				conn.rollback();
				msg = "수정 오류😢😢";
			}
		} catch(Exception ex) {
			ex.printStackTrace();
			msg = ex.getMessage();
		}
		
		return msg;
	}
	
	public String delete(String id, String delFile) {
		String msg = "dao delete";
		String sql = "delete from member where id = ?";
		
		try {
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			
			int cnt = ps.executeUpdate();
			if(cnt > 0) {
				conn.commit();
				msg = "삭제 성공!!";
				
				// 파일삭제
				File file = new File(MemberFileUploadServlet.path + delFile);
				if(file.exists()) file.delete();
			} else {
				conn.rollback();
				msg = "삭제 오류ㅜㅜ";
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return msg;
	}
}








