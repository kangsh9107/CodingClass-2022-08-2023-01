/**
 * index.js
 */

$('#btnHome').on('click', function() {
	location.href="/";
});

$('#btnGuestBook').on('click', function() {
	$('.sectionInner').load('/guestbook/guestbook_select');
});

$('#btnBoard').on('click', function() {
	$('.sectionInner').load('/board/board_select'); 
});
