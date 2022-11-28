<%@page import="org.json.simple.parser.JSONParser"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="jdbc.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String findStr3 = request.getParameter("findStr3");
	System.out.println(findStr3);

	Connection conn = new DBConn().getConn();
	JSONArray jsonArray = new JSONArray();
	String sql = "select * from customers "
			   + "where customerName like ? "
			   + "or    contactLastName like ? "
			   + "or    contactFirstName like ? "
			   + "or    phone like ?";
	PreparedStatement ps = conn.prepareStatement(sql);
	ps.setString(1, "%" + findStr3 + "%");
	ps.setString(2, "%" + findStr3 + "%");
	ps.setString(3, "%" + findStr3 + "%");
	ps.setString(4, "%" + findStr3 + "%");
	
	ResultSet rs = ps.executeQuery();
	while(rs.next()) {
		JSONObject obj = new JSONObject();
		obj.put("customerNumber", rs.getString("customerNumber"));
		obj.put("customerName", rs.getString("customerName"));
		obj.put("phone", rs.getString("phone"));
		obj.put("addressLine1", rs.getString("addressLine1"));
		obj.put("addressLine2", rs.getString("addressLine2"));
		
		jsonArray.add(obj);
	}
	
	System.out.println("toJSONString : " + jsonArray.toJSONString());
	System.out.println("toString : " + jsonArray.toString());
	out.print(jsonArray.toJSONString());
%>