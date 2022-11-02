/**
 * 학생관리
 * student/student_input_form.jsp
 * student-exam/student_list_exam.jsp
 */

/* 입력 화면 처리 student/student_input_form.jsp -------------------- */
let frmInput = document.stdInput;

if(frmInput != null) {
	frmInput.btnSave.addEventListener('click', function() {
		frmInput.action = 'index.jsp?inc=student-exam/student_list_exam.jsp';
		frmInput.submit();
	});
	
	frmInput.btnCancel.addEventListener('click', function() {
		frmInput.action = 'index.jsp?inc=student-exam/student_list_exam.jsp';
		frmInput.submit();
	});
}

/* 조회 화면 처리 student-exam/student_list_exam.jsp -------------------- */
let frmSearch = document.frm_search;

if(frmSearch.btnInsert != null) {
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
