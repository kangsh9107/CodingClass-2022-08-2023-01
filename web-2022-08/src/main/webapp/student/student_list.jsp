<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="VIEWPORT" content="width=device-width, initial-scale=1.0">
<title>student_list.jsp</title>
<link rel="stylesheet" href="../css/student.css">
</head>
<body>

<main class='student-list'>
<div class='student-list'>학생정보 조회</div>
<nav class='student-list-nav'>
	<span><a href='student_input_form.jsp' title='학생정보 입력'>입력</a></span>
	<input type='text' name='student-list' size='30px'/>
	<span><a href='#' title='준비중 입니다.'>조회</a></span>
</nav>
<header class='student-list-header'>
	<div>
		<ul>
			<li class='student-list1'>No</li>
			<li class='student-list2'>아이디</li>
			<li class='student-list3'>성명</li>
			<li class='student-list4'>성별</li>
			<li class='student-list5'>연락처</li>
			<li class='student-list6'>주소</li>
			<li class='student-list7'>이메일</li>
			<li class='student-list8'>우편번호</li>
		</ul>
	</div>
</header>
<div class='student-list-content'>
	<div class='content1'>
		<a href='student_modify.jsp'>
		<ul>
			<li class='student-list1'>1</li>
			<li class='student-list2'>a002</li>
			<li class='student-list3'>kim2</li>
			<li class='student-list4'>f</li>
			<li class='student-list5'>6666</li>
			<li class='student-list6'>서울 강남구 봉은사로111길 5</li>
			<li class='student-list7'>6666</li>
			<li class='student-list8'>06083</li>
		</ul>
		</a>
	</div>
	<div class='content2'>
		<a href='student_modify.jsp'>
		<ul>
			<li class='student-list1'>2</li>
			<li class='student-list2'>a003</li>
			<li class='student-list3'>hong gil</li>
			<li class='student-list4'>m</li>
			<li class='student-list5'>9999</li>
			<li class='student-list6'>서울 금천구 시흥대로88가길 3</li>
			<li class='student-list7'>6666</li>
			<li class='student-list8'>08620</li>
		</ul>
		</a>
	</div>
	<div class='content3'>
		<a href='student_modify.jsp'>
		<ul>
			<li class='student-list1'>3</li>
			<li class='student-list2'>b001</li>
			<li class='student-list3'>kim</li>
			<li class='student-list4'>m</li>
			<li class='student-list5'>010-1111-2222</li>
			<li class='student-list6'>서울 강남구 강남대로112길 12</li>
			<li class='student-list7'>kim@jobtc.kr</li>
			<li class='student-list8'>06120</li>
		</ul>
		</a>
	</div>
	<div class='content4'>
		<a href='student_modify.jsp'>
		<ul>
			<li class='student-list1'>4</li>
			<li class='student-list2'>a010</li>
			<li class='student-list3'>김씨</li>
			<li class='student-list4'>m</li>
			<li class='student-list5'>123456</li>
			<li class='student-list6'>서울 강남구 봉은사로55길 17</li>
			<li class='student-list7'>kim@jobtc.kr</li>
			<li class='student-list8'>06097</li>
		</ul>
		</a>
	</div>
	<div class='content5'>
		<a href='student_modify.jsp'>
		<ul>
			<li class='student-list1'>5</li>
			<li class='student-list2'>a001</li>
			<li class='student-list3'>나야나</li>
			<li class='student-list4'>m</li>
			<li class='student-list5'>123-1234</li>
			<li class='student-list6'>서울 강북구 삼양로123길 6-8</li>
			<li class='student-list7'>na@jobtc.kr</li>
			<li class='student-list8'>01029</li>
		</ul>
		</a>
	</div>
</div>
<footer class='student-list-footer'>
	<hr/><div>1</div>
</footer>
</main>

</body>
</html>