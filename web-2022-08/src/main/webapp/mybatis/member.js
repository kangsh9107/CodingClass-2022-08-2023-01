$('#btnInsert').on('click', function() {
	var param = $('.frm').serialize();
	$.post('bean.jsp?job=insert', param, function(data) {
		$('.contentInnerKang').html(data);
	});
});

$('#btnInsertR').on('click', function() {
	var frm = $('.frm')[0];
	var data = new FormData(frm);
	
	$.ajax({
		type        : 'POST',
		url         : '../mmfs.do?job=insert',
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
	$.post('bean.jsp?job=select', param, function(data) {
		$('.contentInnerKang').html(data);
	});
});

$('#btnSearch').on('click', function() {
	var frm = $('.frm')[0];
	frm.nowPage.value = 1;
	
	var param = $(frm).serialize();
	$.post('bean.jsp?job=select', param, function(data) {
		$('.contentInnerKang').html(data);
	});
});

$('#btnUpdate').on('click', function() {
	var frm = $('.frm')[0];
	var param = $(frm).serialize();
	$.post('bean.jsp?job=update', param, function(data) {
		$('.contentInnerKang').html(data);
	});
});

$('#btnUpdateR').on('click', function() {
	var frm = $('.frm')[0];
	frm.enctype = 'multipart/form-data';
	var data = new FormData(frm);
	
	$.ajax({
		type        : 'POST',
		url         : '../mmfs.do?job=update',
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
	$.post('bean.jsp?job=delete', param, function(data) {
		$('.contentInnerKang').html(data);
	});
});

view = function(id) {
	var frm = $('.frm')[0];
	frm.id.value = id; //쓸모가 없을 줄 알았지만 굉장히 중요한 아이. 클릭한 id를 담아서 form 전송 시 보낼 수 있게 함.
	var param = $(frm).serialize();
	$.post('bean.jsp?job=view', param, function(data) {
		$('.contentInnerKang').html(data);
	});
}

movePage = function(nowPage) {
	var frm = $('.frm')[0];
	frm.nowPage.value = nowPage;
	var param = $(frm).serialize();
	$.post('bean.jsp?job=select', param, function(data) {
		$('.contentInnerKang').html(data);
	});
}