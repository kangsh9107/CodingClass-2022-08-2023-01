<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jquery/multipart_form.jsp</title>
</head>
<body>

<h3>Multipart Form</h3>
<form id="frm" enctype="multipart/form-data">
	<label>작성자</label>
	<input type="text" name="id" value="홍길동"/>
	<br/>
	<label>첨부파일</label>
	<input type="file" name="att" multiple/>
	<br/>
	<input type="button" id="btnSend" value="전송"/>
</form>
<fieldset>
	<legend>RESULT</legend>
	<div id="result"></div>
</fieldset>

<script>
$('#btnSend').on('click', function() {
	let data = new FormData($('#frm')[0]);
	//let data = $('#frm').serialize();
	
	$.ajax({
		type        : 'POST',
		url         : '../ajaxFileUpload.do',
		contentType : false, //contentType과 processData를 false로 해야 object로 간다
		processData : false,
		data        : data,
		dataType    : 'json',
		success     : function(resp) { //xhr.status == 200 && xhr.readyState == 4 일 때가 success다.
			//$('#result').html(resp.msg);
			let str = '<ul>';
			str += '<li>첨부파일</li>'
				+  '  <ol>';
			for(f of resp.att) {
				str += '<li>' + f + '</li>';
			}
			str += '  </ol>'
				+  '<li>id : ' + resp.id + '</li>'
				+  '<li>msg : ' + resp.msg + '</li>'
				+  '</ul>';
			$('#result').html(str);
		}
	});
});
</script>

</body>
</html>