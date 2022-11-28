/* jquery/jquery_main.jsp */
$('main>*').css('box-sizing','border-box');

$('main').css({
	'border': '2px solid gray',
	'width': '800px',
	'min-height': '500px',
	'box-shadow': '5px 5px 8px gray',
	'border-radius': '10px',
	'position': 'relative',
	'margin-top': '10px'
});

$('header, footer').css({
	'padding': '10px',
	'background-color': '#ddd',
	'border-radius': '10px 10px 0 0'
}).text('Header');

$('footer').css({
	'position': 'absolute',
	'bottom': '0',
	'width': '100%',
	'border-radius': '0 0 10px 10px'
}).text('Footer');

$('div#content').text('Hello').css({
	'color': 'blue',
	'padding': '10px'
});

/* jquery/load.jsp */
$('#btnLoad').on('click', function() {
	$('main>div#content').load('load.jsp');
});

/* jquery/gugudan.jsp */
$('#btnGugudan').on('click', function() {
	let $dan = $('#dan').val();
	$('main>div#content').load('gugudan.jsp');
});

/* jquery/get.jsp */
$('#btnGet').on('click', function() {
	$('main>div#content').load('get.jsp');
});

/* jquery/post.jsp */
$('#btnPost').on('click', function() {
	$('main>div#content').load('post.jsp');
});

/* jquery/customer.jsp */
$('#btnCustomer').on('click', function() {
	$('main>div#content').load('customer.jsp');
});
