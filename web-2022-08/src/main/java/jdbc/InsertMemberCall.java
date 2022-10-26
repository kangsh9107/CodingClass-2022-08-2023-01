package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class InsertMemberCall {
	
	public static void main(String[] args) {
		Connection conn = new DBConn("mydb").getConn();
		
		try {
			conn.setAutoCommit(false);
			
			String sql = "{call InsertMember(?, ?, ?, ?, ?, ?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, "test");
			cs.setString(2, "kokoko");
			cs.setString(3, "m");
			cs.setString(4, "010-7777");
			cs.setString(5, "사진");
			cs.registerOutParameter(6, java.sql.JDBCType.INTEGER);
			
			cs.executeQuery();
			/*
			 *  CREATE PROCEDURE InsertMember(m_id varchar(30), m_name varchar(50),
				  			      			  m_gender varchar(10), m_phone varchar(50),
				 		  	  				  m_picture varchar(100), OUT cnt int)
				BEGIN
					INSERT INTO member(id, name, gender, phone, picture, mdate)
								values(m_id, m_name, m_gender, m_phone, m_picture, sysdate());
					SELECT ROW_COUNT() INTO cnt;
				END;
			 */
			
			String[] temp = new String[20];
			ResultSet rs = cs.executeQuery();
			while(rs.next()) {
				int i=0;
				temp[i] = rs.getString("lastName");
				i++;
			}
			
			int cnt = cs.getInt(6);
			
			if(cnt > 0) conn.commit();
			else        conn.rollback();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
