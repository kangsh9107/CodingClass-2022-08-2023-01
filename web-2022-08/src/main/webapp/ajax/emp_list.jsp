<%@page import="java.sql.ResultSet"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="jdbc.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String findStr2 = request.getParameter("findStr2");

	Connection conn = new DBConn().getConn();
	JSONArray jsonArray = new JSONArray();
	String sql = "SELECT e.employeeNumber, e.lastName, o.phone, e.email "
			   + "FROM employees e JOIN offices o "
			   + "ON e.officeCode = o.officeCode "
			   + "WHERE e.employeeNumber LIKE ? "
			   + "OR    e.lastName LIKE ?";
	PreparedStatement ps = conn.prepareStatement(sql);
	ps.setString(1, "%" + findStr2 + "%");
	ps.setString(2, "%" + findStr2 + "%");
	
	ResultSet rs = ps.executeQuery();
	while(rs.next()) {
		JSONObject obj = new JSONObject();
		obj.put("employeeNumber", rs.getString("employeeNumber"));
		obj.put("lastName", rs.getString("lastName"));
		obj.put("phone", rs.getString("phone"));
		obj.put("email", rs.getString("email"));
		
		jsonArray.add(obj);
	}
	
	out.print(jsonArray.toJSONString());
%>