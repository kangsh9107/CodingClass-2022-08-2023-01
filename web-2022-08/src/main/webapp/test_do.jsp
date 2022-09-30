<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("id");
	String name = request.getParameter("name");
	
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		String DB_URL = "jdbc:mysql://localhost:3306/web01?useUnicode=true&characterEncoding=utf8";
		
		Connection con = DriverManager.getConnection(DB_URL, "hong", "1111");
		
		String sql = "INSERT INTO member(id, name) VALUES(?, ?)";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, name);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	catch(ClassNotFoundException e)
	{
		out.println(e);
	}
	catch(SQLException e)
	{
		out.println(e);
	}
	response.sendRedirect("list.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test_do.jsp</title>
</head>
<body>

</body>
</html>