<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl/jstl_forEach.jsp</title>
</head>
<body>

<h3>forEach를 일반 for문처럼 사용하기</h3>
<c:forEach var='i' begin='0' end='10' step='1'>
	${i }
</c:forEach>
<hr/>

<h3>배열값 출력</h3>
<%
	String[] ani = {"강아지", "고양이", "호랑이"};
	request.setAttribute("ani", ani);
%>
<c:forEach items='${ani }' var='i'>
	${i }
</c:forEach>
<br/>
<c:forEach items='${ani }' var='i' begin='2' end='2'>
	${i }
</c:forEach>
<br/>
<c:forEach items='${ani }' var='i' varStatus='status'>
	<li>${i } -- ${status.current } -- ${status.index } -- ${status.count }</li>
</c:forEach>
<br/>
<c:forEach items='${ani }' var='i' varStatus='status' begin='1' end='2'>
	<li>${i } -- ${status.current } -- ${status.index } -- ${status.count }</li>
</c:forEach>
<br/>
<%
	List<String> list = new ArrayList<>(Arrays.asList(ani));
	request.setAttribute("list", list);
%>
<h3>List Collection</h3>
<c:forEach items='${list }' var='i' varStatus='status'>
	<li>${i } -- ${status.current } -- ${status.index } -- ${status.count }</li>
</c:forEach>
<hr/>

</body>
</html>









