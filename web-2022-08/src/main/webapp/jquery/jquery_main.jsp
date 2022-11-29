<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="../lib/jquery-3.6.1.min.js"></script>
<script defer src="../js/jquery_main.js"></script>
<style>
input[type="button"] {
	width: 150px;
	height: 30px;
	margin-bottom: 5px;
}
</style>
<title>jquery/jquery_main.jsp</title>
</head>
<body>

<input type="button" value="load.jsp" id="btnLoad"/>
<input type="button" value="gugudan.jsp" id="btnGugudan"/>
<input type="button" value="get.jsp" id="btnGet"/>
<input type="button" value="post.jsp" id="btnPost"/>
<input type="button" value="customer.jsp" id="btnCustomer"/>
<br/>
<input type="button" value="ajax.jsp" id="btnAjax"/>
<input type="button" value="serialize.jsp" id="btnSerialize"/>
<input type="button" value="multipart_form.jsp" id="btnMultipart"/>
<main>
	<header></header>
	<div id="content"></div>
	<footer></footer>
</main>

</body>
</html>