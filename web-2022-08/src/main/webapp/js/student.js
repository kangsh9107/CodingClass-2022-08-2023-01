/**
 * 학생관리
 * student/student_input_form.jsp
 * student-exam/student_list_exam.jsp
 */

/* 입력 화면 처리 student/student_input_form.jsp -------------------- */
let frmInput = document.stdInput;

if(frmInput != null) {
	// Servlet을 직접 호출하지 않고 useBean으로 객체를 만든 후
	// Servlet을 호출하는 result.jsp를 호출
	frmInput.btnSave.addEventListener('click', function() {
		frmInput.action = 'result.jsp?job=insertR';
		frmInput.submit();
	});
	
	frmInput.btnCancel.addEventListener('click', function() {
		frmInput.action = 'student.do?job=select';
		frmInput.submit();
	});
}

/* 조회 화면 처리 student-exam/student_list_exam.jsp -------------------- */
let frmSearch = document.frm_search;

if(frmSearch != null) {
	frmSearch.btnInsert.addEventListener('click', function() {
		frmSearch.action = 'student.do?job=insert';
		frmSearch.submit();
	});
	
	frmSearch.btnSelect.addEventListener('click', function() {
		frmSearch.action = 'student.do?job=select';
		frmSearch.nowPage.value = 1; // 어떤 페이지에서 조회를 누르던 1페이지부터 보여주기 위해서.
		frmSearch.submit();
	});
}

function movePage(nowPage) {
	frmSearch.action = 'student.do?job=select';
	frmSearch.nowPage.value = nowPage;
	frmSearch.submit();
}

function view(id) {
	frmSearch.action = 'student.do?job=update&id=' + id; // 1) get타입
	//frmSearch.id.value = id; // 2)
	frmSearch.submit();
}

/* 상세보기, 수정, 삭제 student/student_modify.jsp -------------------- */
let btnModify = document.querySelector('#btnModify');
let btnDelete = document.querySelector('#btnDelete');
let btnList = document.querySelector('#btnList');

if(btnModify != null) {
	btnModify.addEventListener('click', function() {
		let frm = document.stdInfoModify;
		frm.action = 'result.jsp?job=updateR';
		frm.submit();
	});
}

if(btnDelete != null) {
	btnDelete.addEventListener('click', function() {
		let frm = document.stdInfoModify;
		frm.action = 'result.jsp?job=deleteR';
		frm.submit();
	});
}

if(btnList != null) {
	btnList.addEventListener('click', function() {
		let frm = document.stdInfoModify;
		frm.action = 'student.do?job=select';
		frm.submit();
	});
}




