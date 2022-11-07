<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl/el_oper.jsp</title>
</head>
<body>

<h2>el에서 사용할 수 있는 연산자</h2>
<c:set var='kor' value='90'/>
<c:set var='eng' value='80'/>
<c:set var='tot' value='${kor+eng }'/>
<c:set var='avg' value='${tot/2 }'/>
<%
int kor = 10;
%>
<ul>
	<li>int kor = <%=kor %></li>
	<li>kor = ${kor }</li>
	<li>eng = ${eng }</li>
	<li>tot = ${kor+eng }</li>
	<li>avg = ${(kor+eng)/2 }</li>
	<li>result = ${(kor+eng)/2 ge 60 ? 'pass' : 'fail' }</li>
	<br/>
	<li>tot2 = ${tot }</li>
	<li>avg2 = ${avg }</li>
	<li>result2 = ${avg ge 60 ? 'pass' : 'fail' }</li>
</ul>

</body>
</html>