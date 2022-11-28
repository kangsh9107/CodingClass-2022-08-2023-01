<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- main에 있어서 jquery 연결 안해도 괜찮다 -->
<script src="../lib/jquery-3.6.1.min.js"></script>
<title>jquery/ajax.jsp</title>
</head>
<body>

<h3>$.ajax를 사용한 파일 로드</h3>
<input type="button" value='$.ajaxx' id='btn'/>
<div id='result'></div>

<script>
$(document).ready(function() {
	$('#btn').on('click', function() {
		
		$.ajax({
			'type' : 'POST',
			'url' : 'load_test.jsp',
			dataType : 'html', //'text'
			success : function(receiveData, status) {
				//$('#result').append(receiveData);
				$('#result').html(receiveData);
			},
			error: function(xhr, status, err) {
				alert(status + "," + xhr + "," + err);
			}
		});
		
		$('#result').slideToggle('slow');
	});
});
</script>

</body>
</html>