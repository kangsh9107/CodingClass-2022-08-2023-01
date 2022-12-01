<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mabatis/bean.jsp</title>
</head>
<body>

<jsp:useBean id="bVo" class="member.MemberVo"/>
<jsp:useBean id="pVo" class="member.MybatisPageVo"/>
<jsp:setProperty property="*" name="bVo"/>
<jsp:setProperty property="*" name="pVo"/>

<%
request.setAttribute("bVo", bVo);
request.setAttribute("pVo", pVo);
%>

<jsp:forward page="../mms.do"></jsp:forward>

</body>
</html>