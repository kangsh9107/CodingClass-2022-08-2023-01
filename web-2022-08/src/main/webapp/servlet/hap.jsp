<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
input[type="submit"] {
	width: 80px;
}

#compute {
	display: none;
}
</style>
<title>servlet/hap.jsp</title>
</head>
<body>

<%
double d = 0d;
double su1 = 0d;
double su2 = 0d;

if(request.getAttribute("r") != null) {
	d = (double)request.getAttribute("r");
	su1 = (double)request.getAttribute("su1");
	su2 = (double)request.getAttribute("su2");
}
%>

<h3>Servlet을 활용한 계산기</h3>
<!-- action에 뭘 써도 상관없다. ex) hap, abc, ggg.do ... -->
<form name='frm' method='post' action='hap.do'>
	<textarea rows='5' cols='30'><%=d %></textarea>
	<br/>
	<input type='text' name='su1' value='<%=su1%>'/>
	<br/>
	<input type='text' name='su2' value='<%=su2%>'/>
	<br/>
	<input type='submit' name='btnPlus' value='+'/>
	<input type='submit' name='btnMinus' value='-'/>
	<br/>
	<input type='submit' name='btnDivide' value='/'/>
	<input type='submit' name='btnMultiply' value='*'/>
	<br/>
	<input type='text' name='compute' id='compute'/>
</form>

<script>
let frm = document.frm;

frm.btnPlus.addEventListener('click', function() {
	frm.compute.value = 1;
});

frm.btnMinus.addEventListener('click', function() {
	frm.compute.value = 2;
});

frm.btnDivide.addEventListener('click', function() {
	frm.compute.value = 3;
});

frm.btnMultiply.addEventListener('click', function() {
	frm.compute.value = 4;
});
</script>

<!-- // 강사님 코드
<form name='frm' method='post'>
	<input type='button' value='+' onclick='run(this.value)'/>
	<input type='hidden' name='oper'/>
</form>

<script>
function run(oper) {
	let frm = document.frm;
	frm.oper.value = oper;
	frm.submit();
}
</script>
 -->

</body>
</html>