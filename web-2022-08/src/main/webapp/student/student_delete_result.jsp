<%@page import="student.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>student/student_delete_result.jsp</title>
</head>
<body>

<jsp:useBean id="pageVo" class="student.Page"/>
<jsp:setProperty property="*" name="pageVo"/>

<jsp:useBean id="sVo" class="student.StudentVo"/>
<jsp:setProperty property="*" name="sVo"/>

<%
StudentDao dao = new StudentDao();
boolean b = dao.delete(sVo);

if(!b) { %>
	<script>
		alert('자료 삭제 오류');
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

</body>
</html>