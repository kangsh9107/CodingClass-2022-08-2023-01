<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.3.js" integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>
<form name="frm" class="frm" method="post">
	<textarea name="doc" class="doc">
		<%-- <c:forEach item="${list }" var="v">
			${v.getDoc }
		</c:forEach> --%>
		${doc }
	</textarea>
	<input type="text" name="chat"/>
	<input type="button" name="btnSend" class="btnSend" value="전송"/>
	<input type="hidden" name="no" value="1"/>
</form>

<script>

$('.btnSend').on('click', function(){
	var frm = $('.frm')[0];
	var param;
	var url='ChattestServlet';
//	frm.chat.value = '{"말":"말한다","듣":"듣는다","내":' + '\"' + frm.chat.value + '\"' + '}';
	
	frm.chat.value = '{"말":"말한다","듣":"듣는다","내":"첫번째"}, {"말":"말한다","듣":"듣는다","내":"두번째"}';
    param = $(frm).serialize();
    $.post(url, param, function(data){
        $('.doc').html(data);
    })
})
</script>
</body>
</html>