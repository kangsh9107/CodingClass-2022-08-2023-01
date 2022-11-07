<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
div.items {
	display: table-row;
}

div.items span {
	display: table-cell;
	background-color: #44f;
	padding: 5px;
	color: #ff0;
	width: 80px;
}
</style>
<title>jstl/jstl_forTokens.jsp</title>
</head>
<body>

<h3>forTokens</h3>
<%
	String tokens = "강아지,고양이,말,소,돼지";
	pageContext.setAttribute("tokens", tokens);
%>
<c:forTokens var='i' items='${tokens }' delims=',' varStatus='status'>
	<div class='items'>
		<span>${i }</span>
		<span>${status.index }</span>
		<span>${status.count }</span>
	</div>
</c:forTokens>

</body>
</html>