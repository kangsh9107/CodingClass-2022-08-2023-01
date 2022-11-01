<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp/useBean2.jsp</title>
</head>
<body>
<!-- submit하면 정보가 request에 저장된다 -->
<form name='frm' method='post' action='useBean2_result.jsp'>
	<span>아이디</span>
	<input type='text' name='id' value='a001'/><br/>
	<span>국어점수</span>
	<input type='text' name='kor' value='99.99'/><br/>
	<span>영어점수</span>
	<input type='text' name='eng' value='78.37'/><br/>
	<span>수학점수</span>
	<input type='text' name='mat' value='96.87'/><br/>
	<input type='submit'/>
</form>

</body>
</html>