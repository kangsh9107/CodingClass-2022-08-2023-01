<%@page import="student.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>student/student_input_result.jsp</title>
</head>
<body>

<jsp:useBean id="pageVo" class="student.Page"/>
<jsp:setProperty property="*" name="pageVo"/>

<jsp:useBean id="studentVo" class="student.StudentVo"/>
<jsp:setProperty property="*" name="studentVo"/>

<%
StudentDao dao = new StudentDao();
boolean b = dao.insert(studentVo);

if(!b) { %>
	<script>
		alert('자료 저장 오류');
	</script>
<%} %>

<form name='frm' method='post'>
	<input type='text' name='findStr' value="<%=pageVo.getFindStr()%>"/>
	<input type='text' name='nowPage' value="<%=pageVo.getNowPage()%>"/>
</form>

<script>
	let frm = document.frm;
	frm.action = 'index.jsp?inc=student-exam/student_list_exam.jsp';
	frm.submit();
</script>
<!-- 
<ul>
	<li>id : <%//=studentVo.getId() %></li>
	<li>name : <%//=studentVo.getName() %></li>
	<li>gender : <%//=studentVo.getGender() %></li>
	<li>pwd : <%//=studentVo.getPwd() %></li>
	<li>phone : <%//=studentVo.getPhone() %></li>
	<li>postalCode : <%//=studentVo.getPostalCode() %></li>
	<li>address : <%//=studentVo.getAddress() %></li>
	<li>address2 : <%//=studentVo.getAddress2() %></li>
	<li>email : <%//=studentVo.getEmail() %></li>
</ul>
 -->
</body>
</html>