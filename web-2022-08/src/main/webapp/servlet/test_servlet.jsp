<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
strong {
	color: blue;
	font-size: 20pt;
}
</style>
<title>servlet/test_servlet.jsp</title>
</head>
<body>

<strong>Servlet 호출 테스트</strong>
<hr/>

<h3>a href="" get타입</h3>
<a href="sbs.kr?id=hong&phone=010-1111">SBS</a>
<hr/>

<h3>form method="get"</h3>
<form method="get" action="sbs.kr"> <!-- method를 지정하지 않으면 default로 get이 들어간다 -->
	<span>ID</span>
	<input type='text' name='id' value='kim'/><br/>
	<span>PHONE</span>
	<input type='text' name='phone' value='010-1111-1111'/><br/>
	<input type="submit" value="SBS"/>
</form>
<hr/>

<h3>form method="post"</h3>
<form method="post" action="mbc.kr">
	<span>ID</span>
	<input type='text' name='id' value='park'/><br/>
	<span>PHONE</span>
	<input type='text' name='phone' value='010-1111-1111'/><br/>
	<input type="submit" value="MBC"/>
</form>
<hr/>

</body>
</html>