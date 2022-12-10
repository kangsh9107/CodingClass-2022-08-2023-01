/**
 * index.js
 */

$('#btnHome').on('click', function() {
	location.href="/";
});

$('#btnGuestBook').on('click', function() {
	$('.newGuestbook').load('/guestbook/guestbook_select');
});

$('#btnBoard').on('click', function() {
	$('.newBoard').load('/board/board_select'); 
});
