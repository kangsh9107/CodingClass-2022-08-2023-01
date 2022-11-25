<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style>
#find_pwd_wrap {
	text-align: center;
	padding-top: 25px;
}
</style>

<title>member/find_pwd.jsp</title>
</head>
<body>

<div id="find_pwd_wrap">
	<form name="frm_find_pwd" method="post">
		<span>아이디</span>
		<input type="text" name="id" value="a001"/>
		<span>이메일</span>
		<input type="email" name="email" value="아이디@naver.com"/>
		<input type="button" name="btnFindPwd" value="메일로 비밀번호 발송"/>
		<input type="button" name="btnCheck" value="Ajax"/>
		
		<input type="hidden" name="receiver" value="아이디@naver.com"/>
		<input type="hidden" name="subject" value="비밀번호 찾기"/>
		<input type="hidden" name="sender" value="아이디@naver.com"/>
	</form>
	<div class="msg"></div>
</div>

<script>
let frm = document.frm_find_pwd;

frm.btnFindPwd.onclick = function() {
	if(frm.id.value == "") {
		alert("아이디를 입력해주세요.");
		return;
	} else if(frm.email.value == "") {
		alert("이메일을 입력해주세요.");
		return;
	}
	
	frm.action = "FindPwd.do";
	frm.submit();
}

/* Ajax */
frm.btnCheck.onclick = function() {
	let xhr = new XMLHttpRequest();
	xhr.open("post", "FindPwd.do");
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send(`id=\${frm.id.value}&email=\${frm.email.value}&receiver=\${frm.receiver.value}&subject=\${frm.subject.value}&sender=\${frm.sender.value}`);
	xhr.onreadystatechange = function() {
		if(xhr.status == 200 && xhr.readyState == 4) {
			let data = xhr.responseText;
			let msg = document.querySelector(".msg");
			msg.innerHTML = data;
		}
	}
}
</script>

</body>
</html>