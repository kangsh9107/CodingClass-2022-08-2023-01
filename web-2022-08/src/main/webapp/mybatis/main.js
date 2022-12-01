$('#btnHome').on('click', function() {
	window.location.replace('main.jsp');
});

$('#btnMember').on('click', function() {
	$('.contentInnerKang').load('../mms.do');
});

$('#btnScore').on('click', function() {
	$('.contentInnerKang').load('member_insert.jsp');
});