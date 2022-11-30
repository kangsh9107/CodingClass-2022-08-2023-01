$('#btnMember').on('click', function() {
	$('.contentInnerKang').load('member_select.jsp');
});

$('#btnScore').on('click', function() {
	$('.contentInnerKang').load('member_insert.jsp');
});