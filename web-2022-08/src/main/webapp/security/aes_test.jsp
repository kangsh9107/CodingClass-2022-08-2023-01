<%@page import="security.AES"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>security/aes.test.jsp</title>
</head>
<body>

<%
AES aes = new AES();
String msg = "abc 123 가나다";
String enc = aes.encrypt(msg); // 암호화
String dec = aes.decrypt(enc); // 복호화

String msg2 = "1";
String enc2 = aes.encrypt(msg2);
String dec2 = aes.decrypt(enc2);
%>

<h2>대칭키 방식</h2>
<ul>
	<li>원본 : <%=msg %></li>
	<li>암호화 : <%=enc %></li>
	<li>복호화 : <%=dec %></li>
</ul>
<hr/>
<ul>
	<li>원본 : <%=msg2 %></li>
	<li>암호화 : <%=enc2 %></li>
	<li>복호화 : <%=dec2 %></li>
</ul>

</body>
</html>