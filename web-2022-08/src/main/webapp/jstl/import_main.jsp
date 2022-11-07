<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl/import_main.jsp</title>
</head>
<body>

<!-- 
	(1) param이 url에 전달되어 실행 된다.
	(2) 그 결과가 page라는 변수에 담긴다.
	
	동적삽입이나 정적삽입과 비슷하다.
 -->
<h2>import main page</h2>
<c:import url="import_sub.jsp" var="page">
	<c:param name="id" value="a001"/>
	<c:param name="phone" value="010-1111-1111"/>
</c:import>

${page }

<h3>footer</h3>

</body>
</html>