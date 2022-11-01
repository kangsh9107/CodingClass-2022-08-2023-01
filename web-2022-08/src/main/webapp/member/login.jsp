<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/login.jsp</title>
<style>
.login2{
	text-align: center;
	padding-top: 25px;
}
</style>
</head>
<body>
<!-- index.jsp에서 실행되기 때문에 action의 경로를 member/login_result.jsp로 해야 한다 -->
<div class='login2'>
	<form name='frm_login' method='post' action='member/login_result.jsp'>
		<span>아이디</span>
		<input type='text' name='mId' value='a001'/>
		<span>암호</span>
		<input type='password' name='pwd' value='1111'/>
		<input type='submit' value='로그인'/>
	</form>
</div>
</body>
</html>