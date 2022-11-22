<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member_control.jsp</title>
<link rel='stylesheet' href='css/member_control.css'>
<script defer src='js/member_control.js'></script>
</head>
<body>
<div class='main_member_control'>
	<div class='main_title_member_control'>
		회원 정보 CRUD
	</div>
	<form class='frm_member_control' name='frm_member'>
		<div id='left_member_control'>
			<input type='file' id='photo_file_member_control'/>
			<img src='images/anno1.png' id='photo_member_control'/>
		</div>
		<div id='right_member_control'>
			<span class='span_member_control'>아이디</span>
			<input type='text' name='id' value='a001'/><br/>
			<span class='span_member_control'>성명</span>
			<input type='text' name='name' value='hong'/><br/>
			<span class='span_member_control'>성별</span>
			<!-- 같은 name이면 DOM구조에서는 배열로 처리된다. -->
			<label><input type='radio' name='gender' value='m'/>남자</label>
			<label><input type='radio' name='gender' value='f'/>여자</label>
			<br/>
			<span class='span_member_control'>연락처</span>
			<input type='text' name='phone' value='010-1111-1234'/>
			<hr/>
			<!-- this는 자기 자신. this.form은 form 전체 -->
			<input type='button' value='CREATE' name='btnAppend' onclick='add(this.form)'/>
			<input type='button' value='UPDATE' name='btnUpdate' onclick='update(this.form)'/>
			<input type='button' value='DELETE' name='btnDelete' onclick='deleteFunc(this.form)'/>
		</div>
	</form>
	<div id='list_member_control'>
		<div id='title_member_control'>
			<span class='span_id_member_control'>아이디</span>
			<span class='span_name_member_control'>성명</span>
			<span class='span_gender_member_control'>성별</span>
			<span class='span_phone_member_control'>연락처</span>
		</div>
		<div id='items_member_control'>
			<div class='item_member_control'>
				<span class='span_id_member_control'>a001</span>
				<span class='span_name_member_control'>홍길동</span>
				<span class='span_gender_member_control'>m</span>
				<span class='span_phone_member_control'>010-1111-1234</span>
			</div>
		</div>
	</div>
</div>
</body>
</html>


