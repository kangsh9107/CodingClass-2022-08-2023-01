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
</style>
<title>jsp/static_sub.jsp</title>
</head>
<body>

<div class="ex">
	<%
		String v = "정적 삽입은 변수 중복 불가";
	%>
	기분이 째져
</div>

</body>
</html>