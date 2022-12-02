$('#btnHome').on('click', function() {
	window.location.replace('main.jsp');
});

$('#btnMember').on('click', function() {
	$('.contentInnerKang').load('../mms.do');
});

$('#btnScore').on('click', function() {
	$('.contentInnerKang').load('../score.do?job=select');
});

/***** mybatisScore/score.js *****/
$('#btnScoreInsert').on('click', function() {
	var param = $('.frm').serialize();
	$.post('../mybatisScore/score.jsp?job=insert', param, function(data) {
		$('.contentInnerKang').html(data);
	});
});

$('#btnScoreInsertR').on('click', function() {
	var param = $('.frm').serialize();
	$.post('../mybatisScore/score.jsp?job=insertR', param, function(data) {
		$('.contentInnerKang').html(data);
	});
});

$('#btnScoreUpdate').on('click', function() {
	var param = $('.frm').serialize();
	$.post('../mybatisScore/score.jsp?job=update', param, function(data) {
		$('.contentInnerKang').html(data);
	});
});

$('#btnScoreUpdateR').on('click', function() {
	var param = $('.frm').serialize();
	$.post('../mybatisScore/score.jsp?job=updateR', param, function(data) {
		$('.contentInnerKang').html(data);
	});
});

$('#btnScoreDeleteR').on('click', function() {
	var yn = confirm('정말 삭제 하십니까?');
	if( !yn ) return;
	
	var param = $('.frm').serialize();
	$.post('../mybatisScore/score.jsp?job=deleteR', param, function(data) {
		$('.contentInnerKang').html(data);
	});
});

$('#btnScoreList').on('click', function() {
	var param = $('.frm').serialize();
	$.post('../mybatisScore/score.jsp?job=select', param, function(data) {
		$('.contentInnerKang').html(data);
	});
});

$('#btnScoreSearch').on('click', function() {
	var frm = $('.frm')[0];
	frm.nowPage.value = 1;
	
	var param = $(frm).serialize();
	$.post('../mybatisScore/score.jsp?job=select', param, function(data) {
		$('.contentInnerKang').html(data);
	});
});

movePageScore = function(nowPage) {
	var frm = $('.frm')[0];
	frm.nowPage.value = nowPage;
	var param = $(frm).serialize();
	$.post('../mybatisScore/score.jsp?job=select', param, function(data) {
		$('.contentInnerKang').html(data);
	});
}

viewScore = function(serial) {
	var frm = $('.frm')[0];
	frm.serial.value = serial;
	var param = $(frm).serialize();
	$.post('../mybatisScore/score.jsp?job=view', param, function(data) {
		$('.contentInnerKang').html(data);
	});
}