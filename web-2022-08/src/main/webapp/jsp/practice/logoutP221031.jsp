<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp/practice/logoutP221031.jsp</title>
</head>
<body>

<%
	session.setAttribute("mId", null);
	response.sendRedirect("loginP221031.jsp");
%>

</body>
</html>