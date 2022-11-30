<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="VIEWPORT" content="width=device-width, initial-scale=1.0">
<!-- CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css?family=Gugi:400" rel="stylesheet">
<link href="main.css" rel="stylesheet">
<!-- JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<script src="../lib/jquery-3.6.1.min.js"></script>
<script defer src="main.js"></script>
<title>mybatis/member_main.jsp</title>
</head>
<body>

<!-- Navbar -->
<div id="title">
	<nav class="bg-success" style="padding: 10px;">
		<div class="container-fluid" style="padding-left: 3px;">
			<a href="main.jsp">
				<img class="navbar-brand" src="mybatisLogo.png" width="130px" height="40px" style="border-radius: 50px; margin-right: 51px;"/>
			</a>
			<input type="button" id="btnMember" class="btn btn-outline-light" value="회원관리" style="font-weight: 600;">
			<input type="button" id="btnScore" class="btn btn-outline-light" value="성적관리" style="font-weight: 600;">
		</div>
	</nav>
</div>
<!-- Content -->
<div id="contentWrapKang">
	<div class="contentInnerKang" style="border: 2px solid rgb(25, 135, 84); padding: 10px;"></div>
</div>

</body>
</html>