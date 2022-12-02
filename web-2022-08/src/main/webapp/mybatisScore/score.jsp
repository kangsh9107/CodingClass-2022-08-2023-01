<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mybatisScore/score.jsp</title>
</head>
<body>

<jsp:useBean id="sVo" class="score.ScoreVo"/>
<jsp:useBean id="pVo" class="score.ScorePageVo"/>
<jsp:setProperty property="*" name="sVo"/>
<jsp:setProperty property="*" name="pVo"/>

<%
request.setAttribute("sVo", sVo);
request.setAttribute("pVo", pVo);
%>

<jsp:forward page="../score.do"></jsp:forward>

</body>
</html>