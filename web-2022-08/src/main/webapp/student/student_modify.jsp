<%@page import="student.StudentVo"%>
<%@page import="student.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="VIEWPORT" content="width=device-width, initial-scale=1.0">
<title>student_modify.jsp</title>
<link rel="stylesheet" href="css/student.css">
<script defer src="js/student.js"></script>
<script src='//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js'></script>
</head>
<body>

<jsp:useBean id="pageVo" class="student.Page"/>
<jsp:setProperty property="*" name="pageVo"/>

<jsp:useBean id="sVo" class="student.StudentVo"/>
<jsp:setProperty property="*" name="sVo"/>

<%
StudentDao dao = new StudentDao();
StudentVo vo = dao.view(sVo.getId());
%>

<div class='stdInfoModify'>
	<form name='stdInfoModify' method='post'>
		<h2>학생정보 수정</h2><br/>
		<span>아이디</span>
		<input type='text' name='id' value='<%=vo.getId()%>' size='20' maxlength='12' placeholder='영어시작. 영어+숫자가능' autocomplete='off' onchange='ChkId(this.form)'/><br/>
		<span>성명</span>
		<input type='text' name='name' value='<%=vo.getName()%>' size='15' placeholder='한글로만 작성' autocomplete='off' onchange='ChkMName(this.form)'/><br/>
		<span>성별</span>
		<label>남자<input type='radio' name='gender' value='m'/></label>
		<label>여자<input type='radio' name='gender' value='f'/></label><br/>
		<span>암호</span>
		<input type='password' name='pwd' autocomplete='off'/><br/>
		<span>암호확인</span>
		<input type='password' name='pwd2' autocomplete='off'/><br/>
		<span>연락처</span>
		<input type='search' name='phone' value='<%=vo.getPhone()%>' size='30' placeholder='-까지 입력' autocomplete='off' onchange='ChkPhone(this.form)'/><br/>
		<span>우편번호</span>
		<input type='search' name='postalCode' value='<%=vo.getPostalCode()%>' size='10' readOnly/>
		<input type='button' name='btnFindZip' value='우편번호 검색'/><br/>
		<span>주소</span>
		<input type='search' name='address' value='<%=vo.getAddress()%>' size='50' readOnly/><br/>
		<span>상세 주소</span>
		<input type='search' name='address2' value='<%=vo.getAddress2()%>' size='50'/><br/>
		<span>이메일</span>
		<input type='search' name='email' value='<%=vo.getEmail()%>' size='40' autocomplete='off' onchange='ChkEmail(this.form)'/><br/><br/>
		<span class='empty'>
			<ul>
				<li><input type='button' id='btnModify' value='수정'/></li>
				<li><input type='button' id='btnDelete' value='삭제'/></li>
				<li><input type='button' id='btnList' value='목록'/></li>
			</ul>
		</span>
		
		<!-- 수정이나 삭제 후 다시 목록으로 돌아갈 때 보던 페이지를 다시 보여주기 위해 값을 여기에 저장해 둔다. display none으로 안보이게 처리 -->
		<input type='text' name='findStr' value='<%=pageVo.getFindStr()%>'/>
		<input type='text' name='nowPage' value='<%=pageVo.getNowPage()%>'/>
	</form>
	
	
</div>

<script>
/* 라디오버튼 체크 */
checkGender('<%=vo.getGender()%>');

function checkGender(g) {
	let frm = document.stdInfoModify;
	
	if(g == 'm') frm.gender[0].checked = true;
	else         frm.gender[1].checked = true;
}

/* 우편번호 및 정규식 */
let frm = document.stdInfoModify;

frm.btnFindZip.addEventListener('click', function(){
	new daum.Postcode({
		oncomplete : function(data){
			frm.address.value = data.address;
			frm.postalCode.value = data.zonecode;
		}
	}).open();
});

let reg;
let t = false;

function ChkInput(frm) {
	if(t==false) {
		alert('양식을 다시 확인 해주세요.');
		return false;
	}
}

function ChkMName(frm) {
	reg = /^[가-힣]+$/;
	t = reg.test(frm.mName.value);
	if(t==true) {
		return;
	} else {
		t = false
		frm.mName.focus();
		alert('성명은 한글로만 작성 해주세요.');
	}
}

function ChkId(frm) {
	reg = /^[a-zA-Z][\w]+$/;
	t = reg.test(frm.id.value);
	if(t==true) {
		return;
	} else {
		t = false
		frm.id.focus();
		alert('아이디는 영어로만 또는 영어로 시작하는 영어+숫자로 작성 해주세요.');
	}
}

function ChkPhone(frm) {
	reg = /^\d{2,3}-\d{3,4}-\d{4}$/;
	let t = reg.test(frm.phone.value);
	if(t==true) {
		return;
	} else {
		t = false
		frm.phone.focus();
		alert('-까지 입력 해주세요. ex) 010-1111-1111');
	}
}

function ChkEmail(frm) {
	reg = /^[a-zA-Z]+[\w]+@[a-zA-Z]+(\.[\w]+){1,3}$/;
	let t = reg.test(frm.email.value);
	if(t==true) {
		return;
	} else {
		t = false
		frm.email.focus();
		alert('이메일 형식에 맞게 입력 해주세요. ex)ex@naver.com');
	}
}

function ChkPwd(frm) {
	if(frm.pwd.value!='' && frm.pwd2.value!='') {
		if(frm.pwd.value==frm.pwd2.value) {
			return;
		} else {
			t = false
			alert('암호와 암호 확인을 동일하게 입력 해주세요.');
		}
	}
}
</script>

</body>
</html>