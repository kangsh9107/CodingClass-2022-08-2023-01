<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="../lib/jquery-3.6.1.min.js"></script>
<title>jquery/gugudan.jsp</title>
</head>
<body>

<input type="text" id="dan" size="12" placeholder="단을 입력하세요."/>
<input type="button" id="btnResult" value="구구단 출력"/>
<div id="gugudan"></div>

<script>
$('#btnResult').on('click', function() {
	let dan = document.querySelector("#dan").value;
	$('div#gugudan').load('gugudan_result.jsp', 'dan=' + dan);
	//let dan = $('#dan').val();
	//$('div#gugudan').load('gugudan_result.jsp?dan=' + dan);
});
</script>

</body>
</html>