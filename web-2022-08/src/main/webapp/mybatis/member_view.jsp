<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script defer src="member.js"></script>
<title>mybatis/member_view.jsp</title>
</head>
<body>

<div id="member">
	<strong style="font-size: 2rem;">회원관리 View</strong>
	<form name="frm" class="frm" method="post">
		<input type="hidden" name="findStr" value="${pVo.findStr }"/>
		<input type="hidden" name="nowPage" value="${pVo.nowPage }"/>
		<input type="hidden" name="delFile" value="${bVo.sysFile }"/>
		
		<span>아이디</span>
		<input type="text" name="id" value="${bVo.id }" readOnly/>
		<br/>
		<span>성명</span>
		<input type="text" name="name" value="${bVo.name }" readOnly/>
		<br/>
		<span>성별</span>
		<label><input type="radio" name="gender" value="m" onclick="return(false)">남자</label>
		<label><input type="radio" name="gender" value="f" onclick="return(false)">여자</label>
		<br/>
		<span>연락처</span>
		<input type="text" name="phone" value="${bVo.phone }" readOnly/>
		<br/>
		<span>가입일</span>
		<input type="date" name="mDate" value="${bVo.mDate }" readOnly/>
		<br/>
		<div style=" position: absolute; top: 104px; left: 330px; text-align: center;">
			<span>프로필 사진</span>
			<br/>
			<img src="../upload/${bVo.sysFile ne '' ? bVo.sysFile : 'anno1.png' }" width="200px" height="200px" style="border-radius: 100px; box-shadow: gray 8px 8px 8px;"/>
		</div>
		<br/>
		<input type="button" id="btnUpdate" value="수정" class="btn btn-outline-light" style="background-color: rgb(151, 188, 98);"/>
		<input type="button" id="btnDeleteR" value="삭제" class="btn btn-outline-light" style="background-color: rgb(151, 188, 98);"/>
		<input type="button" id="btnList" value="취소" class="btn btn-outline-light" style="background-color: rgb(151, 188, 98);"/>
	</form>
</div>

<script>
var gender = '${bVo.gender }';
var frm = $('.frm')[0];
if(gender == 'm') frm.gender[0].checked = true;
else              frm.gender[1].checked = true;
</script>

</body>
</html>