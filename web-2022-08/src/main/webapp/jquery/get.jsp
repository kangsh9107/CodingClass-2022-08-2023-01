<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jquery/get.jsp</title>
<script src="../lib/jquery-3.6.1.min.js"></script>
<script>
//window.onload = function(){}
//만약 2개 이상의 페이지에서 서로 다른 window.onload가 있다면
//처음에 만난 window.onload가 실행되었다면 그거만 실행.
//하지만 $(document).ready는 여러개 있어도 다 실행.
//json은 ""여야 파싱 가능
$(document).ready(function() {
	let param = "id=hong&pwd=1234&msg=Hello";
	$.get('get_json.jsp', param, function(data) {
		console.log('id', data.id);
		console.log('pwd', data.pwd);
		console.log('msg', data.msg);
		
		$('#result').html(JSON.stringify(data) + "<br/>" + "콘솔창도 확인해주세요.");
	}, 'json');
});
</script>
</head>
<body>

<div id="result"></div>

</body>
</html>