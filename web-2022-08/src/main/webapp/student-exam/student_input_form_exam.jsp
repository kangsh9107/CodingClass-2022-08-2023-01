<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="VIEWPORT" content="width=device-width, initial-scale=1.0">
<title>student_input_form_exam.jsp</title>
<link rel="stylesheet" href="student_exam.css">
</head>
<body>

<div id='std_input'>
<form name='frm_input' method='post'>
	<h2>학생정보 입력</h2><br/>
	<span>*아이디</span>
	<input type='text' name='id' required size='20' maxLength='12' autocomplete='off' placeholder='영어와 숫자로 최대 12글자'/><br/>
	<span>*성명</span>
	<input type='text' name='mName' required size='15' autocomplete='off' placeholder='한글로 입력'/><br/>
	<span>*성별</span>
	<label><input type='radio' name='gender' value='m' checked/>남자</label>
	<label><input type='radio' name='gender' value='f'/>여자</label><br/>
	<span>*암호</span>
	<input type='password' name='pwd' required size='25' maxLength='20'/><br/>
	<span>*암호 확인</span>
	<input type='password' name='pwd2' required size='25'/><br/>
	<span>*연락처</span>
	<input type='search' name='phone' required size='15' maxLength='20' autocomplete='off'/><br/>
	<span>우편번호</span>
	<input type='search' name='post' size='10' readOnly/>
	<input type='button' value='우편번호 검색'/><br/>
	<span>주소</span>
	<input type='search' name='addr' size='40'/><br/>
	<span>상세 주소</span>
	<input type='search' name='addr2' size='40' autocomplete='off'/><br/>
	<span>*이메일</span>
	<input type='search' name='email' required size='30' autocomplete='off'/><br/><br/>
	<span></span>
	<input type='submit' value='저장'/>
	<input type='button' value='취소'/>
</form>
</div>

</body>
</html>