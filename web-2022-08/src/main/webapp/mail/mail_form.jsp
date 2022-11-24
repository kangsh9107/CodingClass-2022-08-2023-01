<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

#mail_form_wrap {
	display: inline-block;
	margin: 20px 20px;
	padding: 20px;
	border: 3px solid black;
	border-radius: 5px;
}

input[type="text"] {
	width: 300px;
	margin-bottom: 10px;
}

.textarea_title {
	vertical-align: top;
}

textarea {
	width: 300px;
	margin-bottom: 10px;
}

input[type="button"] {
	width: 100%;
	font-size: 15pt;
	font-weight: 600;
}
</style>

<title>mail/mail_form.jsp</title>
</head>
<body>

<div id="mail_form_wrap">
	<h2>메일 쓰기</h2>
	<form name="frm_mail" method="post">
		<span>수 신</span>
		<input type="text" name="receiver" value="아이디@naver.com"/>
		<br/>
		<span>제 목</span>
		<input type="text" name="subject" value="Hello"/>
		<br/>
		<div>
			<span class="textarea_title">내 용</span>
			<textarea rows="5" cols="60" name="content">Hello</textarea>
			<input type="hidden" name="sender" value="아이디@naver.com"/>
		</div>
		<div>
			<input type="button" value="메일발송(NAVER)" onclick="sendMail()"/>
		</div>
	</form>
	<div>
		${msg }
	</div>
</div>

<script>
let frm = document.frm_mail;

function sendMail() {
	frm.action = "../SendNaverServlet.do";
	frm.submit();
}
</script>

</body>
</html>