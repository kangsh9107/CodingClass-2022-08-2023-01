<%@page import="security.AES"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 경유지 용도 -->
<jsp:useBean id="pageVo" class="student.Page"/>
<jsp:setProperty property="*" name="pageVo"/>

<jsp:useBean id="sVo" class="student.StudentVo"/>
<jsp:setProperty property="*" name="sVo"/>

<%
	request.setAttribute("pageVo", pageVo);
	request.setAttribute("sVo", sVo);
	
	AES aes = new AES();
	String pwd = sVo.getPwd();
	String enc = aes.encrypt(pwd);
	sVo.setPwd(enc);
%>

<jsp:forward page="student.do"/>