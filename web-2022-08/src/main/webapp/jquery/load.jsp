<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="../lib/jquery-3.6.1.min.js"></script>
<title>jquery/load.jsp</title>
</head>
<body>

<div id="load">
	<input type="button" value="페이지 전체 읽기" id="btnFull"/>
	<input type="button" value="part1만 읽기" id="btnPart1"/>
	<input type="button" value="part2만 읽기" id="btnPart2"/>
	<div class="result"></div>
</div>

<script>
//let으로 하면 다시 load.jsp 불렀을 때 이미 선언되어 있다고 오류 남
//let으로 선언한 변수가 남아 있고 let은 중복선언이 안되기 때문
var $r = $('#load>.result');

$($r).css({
	'background-color': '#eee',
	'padding': '20px',
	'min-height': '120px',
	'margin-top': '10px',
	'border': '2px solid gray',
});

/*
 * JS 방식
 * btn.onclick = function(){}
 * btn.addEventListener("click", function(){});
 * JQ 방식(js로 만들어졌기 때문에 jq에 js방식 사용해도 동작한다)
 * btn.on("click", function(){});
 */
$('#load>#btnFull').on('click', function() {
	$r.load('load_test.jsp');
});
 
$('#load>#btnPart1').on('click', function() {
	$r.load('load_test.jsp #part1');
});

$('#load>#btnPart2').on('click', function() {
	$r.load('load_test.jsp #part2');
});
</script>

</body>
</html>