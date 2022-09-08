<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>web_socket.jsp</title>
<script src='../lib/jquery-3.6.1.min.js'></script>

<style>
* {
	box-sizing: border-box;
	padding: 0;
	margin: 0;
}

#web_client {
	margin: 20px 20px auto;
}

#result {
	width: 500px;
	height: 600px;
	border: 2px solid #aaa;
	padding: 20px;
	overflow: auto;
}

#msg {
	width: 500px;
}
</style>

</head>
<body>

<div id='web_client'>
	<h2>WebSocket을 사용한 채팅 웹</h2>
	<div id='result'></div>
	<input type='text' id='msg'/>
	<input type='button' value='전송' id='btnSend'/>
</div>
<script>
	var webSocket = new WebSocket('ws://192.168.0.11:8888/web-2022-08/chatting'); // 대소문자 구분한다. ws://은 웹소켓을 나타내는 프로토콜.
	
 	webSocket.onopen = function(){
// 		let rs = document.querySelector('#result');
//		re.innerHTML = '연결 성공!!';
		$('#result').html('연결 성공!!'); // jquery를 사용하면 간단하게 표현 가능.
	}
	
	webSocket.onclose = function(){
		$('#result').html('연결 종료!!'); // .html()은 선택한 요소 안의 내용을 가져오거나 다른 내용으로 바꿈.
	}
	
	webSocket.onmessage = function(msg){
		let str = '<div>' + msg.data + '</div>';
		$('#result').append(str);
	}
	
	$('#msg').keyup(function(ev){
		if(ev.keyCode==13) sendFunc();
	});
	$('#btnSend').click(sendFunc);
	
	function sendFunc(){
		let msg = $('#msg').val();
		webSocket.send(msg);
		console.log('msg :', msg);
	}
</script>

</body>
</html>








