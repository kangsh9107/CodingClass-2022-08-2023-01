<%@page import="member.MemberVo"%>
<%@page import="java.util.List"%>
<%@page import="mybatis.MyFactory"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mybatis/mybatis_test.jsp</title>
</head>
<body>

<h3>mybatis test</h3>

<%
//MyFactory mf = new MyFactory();
//SqlSession sqlSession = mf.getFactory().openSession();
SqlSession sqlSession = MyFactory.getFactory().openSession(); //얘로 CRUD 처리
List<MemberVo> list = sqlSession.selectList("member.select", "a"); //namespace, parameter

for(MemberVo vo : list) {
	out.print("<li>" + "ID : " + vo.getId() + "</li>");
	out.print("<li>" + "NAME : " + vo.getName() + "</li>");
	out.print("<li>" + "GENDER : " + vo.getGender() + "</li>");
	out.print("<li>" + "PHONE : " + vo.getPhone() + "</li>");
	out.print("-".repeat(50));
}
%>

</body>
</html>