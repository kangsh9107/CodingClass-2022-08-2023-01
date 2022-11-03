/**
 * 학생관리
 * student/student_input_form.jsp
 * student-exam/student_list_exam.jsp
 */

/* 입력 화면 처리 student/student_input_form.jsp -------------------- */
let frmInput = document.stdInput;

if(frmInput != null) {
	frmInput.btnSave.addEventListener('click', function() {
		frmInput.action = 'index.jsp?inc=student/student_input_result.jsp';
		frmInput.submit();
	});
	
	frmInput.btnCancel.addEventListener('click', function() {
		frmInput.action = 'index.jsp?inc=student-exam/student_list_exam.jsp';
		frmInput.submit();
	});
}

/* 조회 화면 처리 student-exam/student_list_exam.jsp -------------------- */
let frmSearch = document.frm_search;

if(frmSearch != null) {
	frmSearch.btnInsert.addEventListener('click', function() {
		frmSearch.action = 'index.jsp?inc=student/student_input_form.jsp';
		frmSearch.submit();
	});
	
	frmSearch.btnSelect.addEventListener('click', function() {
		frmSearch.action = 'index.jsp?inc=student-exam/student_list_exam.jsp';
		frmSearch.nowPage.value = 1; // 어떤 페이지에서 조회를 누르던 1페이지부터 보여주기 위해서.
		frmSearch.submit();
	});
}

function movePage(nowPage) {
	frmSearch.action = 'index.jsp?inc=student-exam/student_list_exam.jsp';
	frmSearch.nowPage.value = nowPage;
	frmSearch.submit();
}

function view(id) {
	frmSearch.action = 'index.jsp?inc=student/student_modify.jsp&id=' + id; // 1) get타입
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
		frm.action = 'index.jsp?inc=student/student_modify_result.jsp';
		frm.submit();
	});
}

if(btnDelete != null) {
	btnDelete.addEventListener('click', function() {
		let frm = document.stdInfoModify;
		frm.action = 'index.jsp?inc=student/student_delete_result.jsp';
		frm.submit();
	});
}

if(btnList != null) {
	btnList.addEventListener('click', function() {
		let frm = document.stdInfoModify;
		frm.action = 'index.jsp?inc=student-exam/student_list_exam.jsp';
		frm.submit();
	});
}




