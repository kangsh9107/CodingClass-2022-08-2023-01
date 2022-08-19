<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="VIEWPORT" content="width=device-width, initial-scale=1.0">
<title>student_modify.jsp</title>
<link rel="stylesheet" href="../css/student.css">
</head>
<body>

<form name='student-info-modify' method='post' action='register.do'>
<div class='student-info-modify'>학생정보 수정</div><br/><br/>
<span>아이디</span><input type='text' name='id-modify' size='20' maxlength='12' placeholder='영어와 숫자로 최대 12글자'/><br/>
<span>성명</span><input type='text' name='name-modify' size='15' placeholder='한글로'/><br/>
<span>성별</span><label>남자<input type='radio' name='gen' value='m' checked/></label>
<label>여자<input type='radio' name='gen' value='f'/></label><br/>
<span>연락처</span><input type='search' name='phone' size='30' placeholder='-까지 입력'/><br/>
<span>우편번호</span>
<input class='post-number' type='search' name='post-number' size='10'/>
<input type='button' name='button-post' value='우편번호 검색'/><br/>
<span>주소</span><input type='search' name='post-addr' size='50'/><br/>
<span>상세 주소</span><input type='search' name='post-addr-detail' size='50'/><br/>
<span>이메일</span><input type='search' name='mail' size='40'/><br/><br/>
<span class='empty-modify'>
<ul>
	<li><a href='#'>저장</a></li>
	<li><a href='student_list.jsp' title='취소하고 목록으로'>취소</a></li>
	<li><a href='#'>삭제</a></li>
</ul>
</span>
</form>

</body>
</html>