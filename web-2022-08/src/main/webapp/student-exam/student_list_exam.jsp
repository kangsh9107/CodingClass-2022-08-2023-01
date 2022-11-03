<%@page import="student.StudentVo"%>
<%@page import="java.util.List"%>
<%@page import="student.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="VIEWPORT" content="width=device-width, initial-scale=1.0">
<title>student_list_exam.jsp</title>
<link rel="stylesheet" href="student-exam/student_exam.css">
<script defer src="js/student.js"></script>
</head>
<body>

<jsp:useBean id="pageVo" class="student.Page"/>
<jsp:setProperty property="*" name="pageVo"/>

<%
StudentDao dao = new StudentDao();
List<StudentVo> list = dao.select(pageVo);
%>

<div id='std_list'>
	<h2>학생정보 조회</h2>
	<form name='frm_search' method='post'>
		<input type='button' value='입력' name='btnInsert'/>
		<input type='search' name='findStr' value="<%=pageVo.getFindStr() %>"/>
		<input type='button' value='조회' name='btnSelect'/>
		<!-- Page 빈이 잘 작동하는지 테스트. 나중에 hidden 처리. -->
		<input type='text' name='nowPage' value="<%=pageVo.getNowPage() %>"/>
	</form>
	<ul>
		<li class='title'> <!-- 타이틀 -->
			<span class='no'>No</span>
			<span class='id'>아이디</span>
			<span class='mName'>성명</span>
			<span class='gender'>성별</span>
			<span class='phone'>연락처</span>
			<span class='addr'>주소</span>
			<span class='email'>이메일</span>
			<span class='post'>우편번호</span>
		</li>
		<%for(int i=0; i<list.size(); i++) {
			StudentVo v = list.get(i);
		%>
			<li class='item' onclick="view('<%=v.getId() %>')"> <!-- v.getId()가 문자여서 "" 안에 넣어준다 -->
				<span class='no'><%=i + 1 %></span>
				<span class='id'><%=v.getId() %></span>
				<span class='mName'><%=v.getName() %></span>
				<span class='gender'><%=v.getGender() %></span>
				<span class='phone'><%=v.getPhone() %></span>
				<span class='addr'><%=v.getAddress() %></span>
				<span class='email'><%=v.getEmail() %></span>
				<span class='post'><%=v.getPostalCode() %></span>
			</li>
		<%} %>
		<li class='btnPage'> <!-- page이동 버튼 -->
			<%if(pageVo.getStartPage() > 1) { %>
			<input type='button' name='btnStart' value='처음' onclick='movePage(1)'/>
			<input type='button' name='btnPre' value='이전' onclick='movePage(<%=pageVo.getStartPage()-1 %>)'/>
			<%} %>
			
			<%for(int i=pageVo.getStartPage(); i<=pageVo.getEndPage(); i++) { %>
				<input type='button' value='<%=i %>' onclick='movePage(<%=i %>)'/>
			<%} %>
			
			<%if(pageVo.getEndPage() < pageVo.getTotPage()) {%>
			<input type='button' name='btnNext' value='다음' onclick='movePage(<%=pageVo.getEndPage()+1 %>)'/>
			<input type='button' name='btnEnd' value='맨끝' onclick='movePage(<%=pageVo.getTotPage() %>)'/>
			<%} %>
		</li>
	</ul>
</div>

</body>
</html>