<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="VIEWPORT" content="width=device-width, initial-scale=1.0">
<title>웹 프로젝트</title>
<link rel="stylesheet" href="css/index.css">
</head>
<body>
<%
String inc22 = "temp.html";
if(request.getParameter("inc") != null) {
	inc22 = request.getParameter("inc");
}

String sessionId = (String)session.getAttribute("sessionId");
%>

<main class='main_index'>
<div class='login_index'>
	<%if(sessionId == null) { %>
		<a href='index.jsp?inc=member/login.jsp'>로그인</a>
	<%} else { %>
		[<%=sessionId %> 님 방가]
		<a href='member/logout.jsp'>로그아웃</a>
	<%} %>
</div>
<header class='header_index'>
	<img class='logo' src='images/logo1.png' alt='logo'/>
	<div class='corpname_index'>Web Project</div>
	<nav class='nav_index'>
		<ul class='ul_index'>
			<li><a href='index.jsp?inc=student-exam/student_list_exam.jsp' title='학생정보 조회'>학생관리</a></li>
			<li><a href='index.jsp?inc=javascript/score_crud.html'>성적관리</a></li>
			<li><a href='index.jsp?inc=member/member_control.html'>회원관리</a></li>
			<li><a href='#'>제품관리</a></li>
			<li><a href='#'>생산관리</a></li>
			<li><a href='#'>방명록</a></li>
			<li><a href='#'>게시판</a></li>
		</ul>
	</nav>
</header>
<div class='content_index'>
	<jsp:include page="<%=inc22 %>"/>
</div>
<footer class='footer_index'>
	대한민국
</footer>
</main>

</body>
</html>


