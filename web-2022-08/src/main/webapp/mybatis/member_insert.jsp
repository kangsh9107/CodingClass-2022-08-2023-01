<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script defer src="member.js"></script>
<title>mybatis/member_insert.jsp</title>
</head>
<body>

<div id="member">
	<strong style="font-size: 2rem;">회원관리 Insert</strong>
	<form name="frm" class="frm" method="post" enctype="multipart/form-data">
		<input type="hidden" name="findStr" value="${pVo.findStr }"/>
		<input type="hidden" name="nowPage" value="${pVo.nowPage }"/>
		
		<span>아이디</span>
		<input type="text" name="id" value="h001"/>
		<br/>
		<span>성명</span>
		<input type="text" name="name" value="홍길동"/>
		<br/>
		<span>성별</span>
		<label><input type="radio" name="gender" value="m">남자</label>
		<label><input type="radio" name="gender" value="f">여자</label>
		<br/>
		<span>연락처</span>
		<input type="text" name="phone" value="010-1111-2222"/>
		<br/>
		<span>가입일</span>
		<input type="date" name="mDate"/>
		<br/>
		<div style=" position: absolute; top: 104px; left: 330px; text-align: center;">
			<span>프로필 사진</span>
			<br/>
			<img id="photo" src="../upload/${bVo.sysFile ne '' ? bVo.sysFile : 'anno1.png' }" width="200px" height="200px" style="border-radius: 100px; box-shadow: gray 8px 8px 8px;"/>
		</div>
		<input id="fileTest" type="file" name="att" style="dispaly: none;"/>
		<br/>
		<input type="button" id="btnInsertR"  value="저장" class="btn btn-outline-light" style="background-color: rgb(151, 188, 98);"/>
		<input type="button" id="btnList"  value="취소" class="btn btn-outline-light" style="background-color: rgb(151, 188, 98);"/>
	</form>
</div>

</body>
</html>