<%@page import="student.StudentVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl/scope.jsp</title>
</head>
<body>

<%
// 1), 2)
StudentVo vo = new StudentVo();
vo.setId("a001");
vo.setName("hong");
vo.setPhone("010-1111-1111");

// 2)
request.setAttribute("vo", vo); // request "vo"에 vo를 저장. ${vo.id}는 게터를 호출하고 page,request,session,application에서 가져온다
%>

<!-- 1) 기존 방법 -->
<ul>
	<li>id : <%=vo.getId() %></li>
	<li>name : <%=vo.getName() %></li>
	<li>phone : <%=vo.getPhone() %></li>
</ul>
<hr/>

<!-- 2) EL 방법 -->
<ul>
	<li>id : ${vo.id }</li>
	<li>name : ${vo.name }</li>
	<li>phone : ${vo.phone }</li>
</ul>

</body>
</html>