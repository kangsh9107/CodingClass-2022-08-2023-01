<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl/jstl_choose.jsp</title>
</head>
<body>

<%
	int v = 90;
	request.setAttribute("v", v);
%>

<div style='border:3px solid #00f; padding:10px; box-sizing:border-box;'>
	당신의 성적은 ${v } 이며, 등급은
	<c:choose>
		<c:when test='${v >= 90 }'> 최우수 </c:when>
		<c:when test='${v >= 80 }'> 우수 </c:when>
		<c:when test='${v >= 70 }'> 상 </c:when>
		<c:otherwise> 중 </c:otherwise>
	</c:choose>
	입니다.
</div>

</body>
</html>









