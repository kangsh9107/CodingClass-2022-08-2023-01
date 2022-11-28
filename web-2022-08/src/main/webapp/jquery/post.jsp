<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="../lib/jquery-3.6.1.min.js"></script>
<title>jquery/post.jsp</title>
</head>
<body>

<h3>POST</h3>
<form name="frm" method="post">
	<label>작성자</label>
	<input type="text" name="id" value="a001"/><br/>
	<label>제목</label>
	<input type="text" name="subject" value="제목이다."/><br/>
	<textarea cols="30" rows="3" name="doc"></textarea><br/>
	<input type="button" value="전송" id="btnSend"/>
</form>
<hr/>
<div id="result"></div>

<script>
//data에서 dataTest로 이름 바꿔도 작동한다
//data는 문자열 형식이거나 자바스크립트의 object형식이어야 한다
//마지막에 데이터타입을 지정하면 해당유형으로 파싱하지 않아도 알아서 그 데이터타입이 된다
$('#btnSend').on('click', function() {
	let param = $('form').serialize();
	$.post('post_result.jsp', param, function(dataTest) {
		$('#result').html(JSON.stringify(dataTest));
		console.log('id : ', dataTest.id);
		console.log('subject : ', dataTest.subject);
		console.log('doc : ', dataTest.doc);
	}, 'json');
});
</script>

</body>
</html>