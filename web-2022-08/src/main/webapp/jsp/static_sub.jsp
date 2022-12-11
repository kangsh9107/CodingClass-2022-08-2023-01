<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	.ex {
		color: red;
	}
	#test2 {
		color: yellow;
	}
</style>
<title>jsp/static_sub.jsp</title>
</head>
<body>
<%
	String b = "서브에서 선언된 변수";
	//b += v;
%>

<div class="ex">
	기분이 째져
</div>
<%=b %>
<%=10 %>

</body>
</html>