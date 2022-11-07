<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="VIEWPORT" content="width=device-width, initial-scale=1.0">
<title>student_list.jsp</title>
<link rel="stylesheet" href="css/student.css">
</head>
<body>

<main class='student-list'>
	<div class='student-list-title'>학생정보 조회</div>
	<nav class='student-list-nav'>
		<span><a href='student/student_input_form.jsp' title='학생정보 입력'>입력</a></span>
		<input type='text' name='student-list' size='30px'/>
		<span><a href='#' title='준비중 입니다.'>조회</a></span>
	</nav>
	<header class='student-list-header'>
		<div>
			<ul>
			  <li class='student-list-cols1'>No</li>
			  <li class='student-list-cols2'>아이디</li>
			  <li class='student-list-cols3'>성명</li>
			  <li class='student-list-cols4'>성별</li>
			  <li class='student-list-cols5'>연락처</li>
			  <li class='student-list-cols6'>주소</li>
			  <li class='student-list-cols7'>이메일</li>
			  <li class='student-list-cols8'>우편번호</li>
			</ul>
		</div>
	</header>
	<div class='student-list-content'>
		<div>
			<a href='student/student_modify.jsp'>
			<ul>
			  <li class='student-list-cols1'>1</li>
			  <li class='student-list-cols2'>a002</li>
			  <li class='student-list-cols3'>kim2</li>
			  <li class='student-list-cols4'>f</li>
			  <li class='student-list-cols5'>6666</li>
			  <li class='student-list-cols6'>서울 강남구 봉은사로111길 5</li>
			  <li class='student-list-cols7'>6666</li>
			  <li class='student-list-cols8'>06083</li>
			</ul>
			</a>
		</div>
		<div>
			<a href='student_modify.jsp'>
			<ul>
			  <li class='student-list-cols1'>2</li>
			  <li class='student-list-cols2'>a003</li>
			  <li class='student-list-cols3'>hong gil</li>
			  <li class='student-list-cols4'>m</li>
			  <li class='student-list-cols5'>9999</li>
			  <li class='student-list-cols6'>서울 금천구 시흥대로88가길 3</li>
			  <li class='student-list-cols7'>6666</li>
			  <li class='student-list-cols8'>08620</li>
			</ul>
			</a>
		</div>
		<div>
			<a href='student_modify.jsp'>
			<ul>
			  <li class='student-list-cols1'>3</li>
			  <li class='student-list-cols2'>b001</li>
			  <li class='student-list-cols3'>kim</li>
			  <li class='student-list-cols4'>m</li>
			  <li class='student-list-cols5'>010-1111-2222</li>
			  <li class='student-list-cols6'>서울 강남구 강남대로112길 12</li>
			  <li class='student-list-cols7'>kim@jobtc.kr</li>
			  <li class='student-list-cols8'>06120</li>
			</ul>
			</a>
		</div>
		<div>
			<a href='student_modify.jsp'>
			<ul>
			  <li class='student-list-cols1'>4</li>
			  <li class='student-list-cols2'>a010</li>
			  <li class='student-list-cols3'>김씨</li>
			  <li class='student-list-cols4'>m</li>
			  <li class='student-list-cols5'>123456</li>
			  <li class='student-list-cols6'>서울 강남구 봉은사로55길 17</li>
			  <li class='student-list-cols7'>kim@jobtc.kr</li>
			  <li class='student-list-cols8'>06097</li>
			</ul>
			</a>
		</div>
		<div>
			<a href='student_modify.jsp'>
			<ul>
			  <li class='student-list-cols1'>5</li>
			  <li class='student-list-cols2'>a001</li>
			  <li class='student-list-cols3'>나야나</li>
			  <li class='student-list-cols4'>m</li>
			  <li class='student-list-cols5'>123-1234</li>
			  <li class='student-list-cols6'>서울 강북구 삼양로123길 6-8</li>
			  <li class='student-list-cols7'>na@jobtc.kr</li>
			  <li class='student-list-cols8'>01029</li>
			</ul>
			</a>
		</div>
	</div>
	<footer class='student-list-footer'>
		<hr/>
		<div>1</div>
	</footer>
</main>

</body>
</html>