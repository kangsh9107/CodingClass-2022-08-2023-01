<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="VIEWPORT" content="width=device-width, initial-scale=1.0">
<title>student_modify.jsp</title>
<link rel="stylesheet" href="css/student.css">
<script src='//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js'></script>
</head>
<body>

<form name='stdInfoModify' method='post' action='register.do'>
	<h2>학생정보 수정</h2><br/>
	<span>아이디</span>
	<input type='text' name='id' size='20' maxlength='12' placeholder='영어시작. 영어+숫자가능' autocomplete='off' onchange='ChkId(this.form)'/><br/>
	<span>성명</span>
	<input type='text' name='mName' size='15' placeholder='한글로만 작성' autocomplete='off' onchange='ChkMName(this.form)'/><br/>
	<span>성별</span>
	<label>남자<input type='radio' name='gen' value='m' checked/></label>
	<label>여자<input type='radio' name='gen' value='f'/></label><br/>
	<span>연락처</span>
	<input type='search' name='phone' size='30' placeholder='-까지 입력' autocomplete='off' onchange='ChkPhone(this.form)'/><br/>
	<span>우편번호</span>
	<input type='search' name='zipcode' size='10' readOnly/>
	<input type='button' name='btnFindZip' value='우편번호 검색'/><br/>
	<span>주소</span>
	<input type='search' name='address' size='50' readOnly/><br/>
	<span>상세 주소</span>
	<input type='search' name='address2' size='50'/><br/>
	<span>이메일</span>
	<input type='search' name='email' size='40' autocomplete='off' onchange='ChkEmail(this.form)'/><br/><br/>
	<span class='empty'>
		<ul>
		  <li><a href='#' title='준비중 입니다.' onclick='retrun ChkInput(this.form)'>수정</a></li>
		  <li><a href='student_list.jsp' title='취소하고 목록으로'>취소</a></li>
		  <li><a href='#' title='준비중 입니다.'>삭제</a></li>
		</ul>
	</span>
</form>
<script>
let frm = document.stdInfoModify;
frm.btnFindZip.addEventListener('click', function(){
	new daum.Postcode({
		oncomplete : function(data){
			frm.address.value = data.address;
			frm.zipcode.value = data.zonecode;
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