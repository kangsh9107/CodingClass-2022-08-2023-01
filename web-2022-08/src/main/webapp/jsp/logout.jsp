<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp/logout.jsp</title>
</head>
<body>

<%
	//out.print("<script>"
	//		+ "window.open('/');"
	//		+ "</script>");
	session.setAttribute("mId", null);
	//session.invalidate(); // 세션의 모든 값을 지우기 때문에 잘 안쓴다.
	response.sendRedirect("login.jsp"); // 페이지 이동. 이 코드가 실행되는 순간 페이지가 바뀌기 때문에 밑에 코드는실행 안된다
%>

</body>
</html>