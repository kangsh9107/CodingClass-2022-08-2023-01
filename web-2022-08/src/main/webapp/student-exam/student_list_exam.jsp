<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="VIEWPORT" content="width=device-width, initial-scale=1.0">
<title>student_list_exam.jsp</title>
<link rel="stylesheet" href="student_exam.css">
</head>
<body>

<div id='std_list'>
	<h2>학생정보 조회</h2>
	<form name='frm_list' method='post'>
		<input type='button' value='입력'/>
		<input type='search' name='findStr'/>
		<input type='button' value='조회'/>
	</form>
	<ul>
		<li class='title'> <!-- 타이틀 -->
			<span class='no'>No</span>
			<span class='id'>아이디</span>
			<span class='mName'>성명</span>
			<span class='gender'>성별</span>
			<span class='phone'>연락처</span>
			<span class='addr'>주소</span>
			<span class='email'>이메일</span>
			<span class='post'>우편번호</span>
		</li>
		<% for(int i=1; i<=10 ; i++){ %>
			<li class='item'>
				<span class='no'><%=i %></span>
				<span class='id'>a002</span>
				<span class='mName'>kim2</span>
				<span class='gender'>f</span>
				<span class='phone'>6666</span>
				<span class='addr'>서울 강남구 봉은사로111길 5</span>
				<span class='email'>6666</span>
				<span class='post'>06083</span>
			</li>
		<%} %>
		<li class='btnPage'> <!-- page이동 버튼 -->
			<input type='button' value='처음'/>
			<input type='button' value='이전'/>
			
			<input type='button' value='1'/>
			<input type='button' value='2'/>
			<input type='button' value='3'/>
			<input type='button' value='4'/>
			
			<input type='button' value='다음'/>
			<input type='button' value='맨끝'/>
		</li>
	</ul>
</div>

</body>
</html>