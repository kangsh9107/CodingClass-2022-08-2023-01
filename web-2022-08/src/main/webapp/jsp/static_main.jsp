<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp/static_main.jsp</title>
</head>
<body>

<h2>정적 삽입 메인 페이지</h2>

<%
	String v = "메인에서 선언된 변수";
%>
<%@include file="static_sub.jsp" %>
<hr/>
<span>위에 표시된 페이지는 정적으로 삽입된 페이지입니다.</span>

<h2>메인 페이지 꼬릿말</h2>

</body>
</html>