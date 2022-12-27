package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdbc.DBConn;

@WebServlet(urlPatterns="/ChattestServlet")
public class ChattestServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JSONParser jParser = new JSONParser();
		JSONObject jObject = new JSONObject();
		try {
			jObject = (JSONObject)jParser.parse(req.getParameter("chat"));
			System.out.println(jObject.toJSONString());
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		
		
//		Connection conn;
//		conn = new DBConn("mydb").getConn();
//		String sql = "";
//		
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		
//		String doc = "";
//		doc = jObject.toJSONString();
//		
//		sql = "select doc from chattest";
//		try {
//			ps = conn.prepareStatement(sql);
//			rs = ps.executeQuery();
//			while(rs.next()) {
//				doc += rs.getString("doc");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		try {
//			sql = "insert into chattest(NO, doc, TIME) values(?, ?, now())";
//			conn.setAutoCommit(false);
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, req.getParameter("no"));
//			ps.setString(2, doc);
//			
//			boolean b = false;
//			int cnt = ps.executeUpdate();
//			if(cnt > 0) {
//				conn.commit();
//				b = true;
//			} else {
//				conn.rollback();
//			}
//		} catch(Exception ex) {
//			ex.printStackTrace();
//		}
		
		

//		doc = jObject.toJSONString();
		String url = "chat_test.jsp";
		RequestDispatcher rd = req.getRequestDispatcher(url);
//		req.setAttribute("doc", doc);
		rd.include(req, resp);
	}

}
