<%@page import="webpractice.LoginP221031"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp/practice/loginP221031.jsp</title>
</head>
<body>

<%
	if(request.getMethod().equals("POST")) {
		String mId = request.getParameter("mId");
		
		LoginP221031 l = new LoginP221031();
		boolean b = l.login(mId, "");
		
		if(b) {
			session.setAttribute("mId", mId);
		} else {
			out.print("<script>alert('로그인 실패')</script>");
		}
	}

	String sessionId = (String)session.getAttribute("mId");
%>

<form name="frm" method="post">
	<%if(sessionId == null) { %>
	<span>아이디</span>
	<input type="text" name="mId" value="a001">
	<span>비밀번호</span>
	<input type="password" name="pwd" value="1111">
	<input type="button" name="btnLogin" value="로그인">
	<%} else { %>
	<span><%=sessionId %>님 방가</span>
	<input type="button" name="btnLogout" value="로그아웃">
	<%} %>
</form>

<script>
	let frm = document.frm;
	
	if(frm.btnLogin != null) {
		frm.btnLogin.onclick = function() {
			frm.action = "loginP221031.jsp";
			frm.submit();
		}
	}
	
	if(frm.btnLogout != null) {
		frm.btnLogout.onclick = function() {
			frm.action = "logoutP221031.jsp";
			frm.submit();
		}
	}
</script>

</body>
</html>