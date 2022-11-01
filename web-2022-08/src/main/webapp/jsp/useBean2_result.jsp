<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp/useBean2_result.jsp</title>
</head>
<body>

<%
	String id = request.getParameter("id");
	double kor = Double.parseDouble(request.getParameter("kor"));
	double eng = Double.parseDouble(request.getParameter("eng"));
	double mat = Double.parseDouble(request.getParameter("mat"));
	double tot = kor + eng + mat;
	double avg = Math.round(tot / 3.0 * 100) / 100.0;
%>
<h3>useBean 태그를 사용하지 않은 방법</h3>
<ul>
	<li>아이디 : <%=id %></li>
	<li>국어점수 : <%=kor %></li>
	<li>영어점수 : <%=eng %></li>
	<li>수학점수 : <%=mat %></li>
	<li>총점 : <%=tot %></li>
	<li>평균 : <%=avg %></li>
</ul>

<h3>useBean 태그를 사용한 방법</h3>
<jsp:useBean id="vo2" class="jsp.BeanTestVo2"/>
<jsp:setProperty property="*" name="vo2"/>
<ul>
	<li>아이디 : <%=vo2.getId() %></li>
	<li>국어점수 : <%=vo2.getKor() %></li>
	<li>영어점수 : <%=vo2.getEng() %></li>
	<li>수학점수 : <%=vo2.getMat() %></li>
	<li>총점 : <%=vo2.getTot() %></li>
	<li>평균 : <%=vo2.getAvg() %></li>
</ul>

</body>
</html>