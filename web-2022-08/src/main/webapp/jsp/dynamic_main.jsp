<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp/dynamic_main</title>
<style>
</style>
</head>
<body>

<h2>동적 삽입 메인 페이지</h2>
<!-- 
	1) 페이지의 실행 결과가 삽입된다.
	2) url 변수 사용 가능.
	3) 메인페이지와 삽입페이지의 변수가 충돌하지 않는다.
 -->
 
<%
	String url = "dynamic_sub.jsp";
%>
<jsp:include page="<%=url %>">
	<jsp:param value="홍길동" name="irum"/>
</jsp:include>
<hr/>
<jsp:include page="dynamic_sub2.jsp">
	<jsp:param value="99" name="dan"/>
</jsp:include>

<h2>메인 페이지 꼬릿말</h2>

</body>
</html>









