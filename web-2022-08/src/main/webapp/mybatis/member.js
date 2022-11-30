$('#btnInsert').on('click', function() {
	var param = $('.frm').serialize();
	$.post('member_insert.jsp', param, function(data) {
		$('.contentInnerKang').html(data);
	});
});

$('#btnInsertR').on('click', function() {
	var frm = $('.frm')[0];
	var data = new FormData(frm);
	
	$.ajax({
		type        : 'POST',
		url         : 'abc.do',
		data        : data,
		contentType : false,
		processData : false,
		success     : function(resp) {
			$('.contentInnerKang').html(resp);
		}
	});
});

$('#btnList').on('click', function() {
	var param = $('.frm').serialize();
	frm.enctype = '';
	$.post('member_select.jsp', param, function(data) {
		$('.contentInnerKang').html(data);
	});
});

$('#btnSearch').on('click', function() {
	var frm = $('.frm')[0];
	frm.nowPage.value = 1;
	var param = $(frm).serialize();
	$.post('member_select.jsp', param, function(data) {
		$('.contentInnerKang').html(data);
	});
});

$('#btnUpdate').on('click', function() {
	var frm = $('.frm')[0];
	var param = $(frm).serialize();
	$.post('member_update.jsp', param, function(data) {
		$('.contentInnerKang').html(data);
	});
});

$('#btnUpdateR').on('click', function() {
	var frm = $('.frm')[0];
	frm.enctype = 'multipart/form-data';
	var data = new FormData(frm);
	
	$.ajax({
		type        : 'POST',
		url         : 'abc.do',
		data        : data,
		contentType : false,
		processData : false,
		success     : function(resp) {
			$('.contentInnerKang').html(resp);
		}
	});
});

$('#btnDeleteR').on('click', function() {
	var yn = confirm('정말 삭제 하십니까?');
	if( !yn ) return;
	
	var param = $('.frm').serialize();
	$.post('member_select.jsp', param, function(data) {
		$('.contentInnerKang').html(data);
	});
});

view = function(id) {
	var frm = $('.frm')[0];
	frm.id.value = id;
	var param = $(frm).serialize();
	$.post('member_view.jsp', param, function(data) {
		$('.contentInnerKang').html(data);
	});
}

movePage = function(nowPage) {
	console.log(nowPage);
	var frm = $('.frm');
	frm.nowPage.value = nowPage;
	console.log("newPage : ", frm.nowPage.value);
	var param = $(frm).serialize();
	$.post('member_select.jsp', param, function(data) {
		$('.contentInnerKang').html(data);
	});
}