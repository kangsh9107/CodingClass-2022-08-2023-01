<%@page import="jdbc.Login"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	  rel="stylesheet"
	  integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	  crossorigin="anonymous">
<link href="css/login.css" rel="stylesheet">
<!-- JavaScript Bundle with Popper -->
<script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
		crossorigin="anonymous"></script>
<title>jsp/login.jsp</title>
</head>
<body>

<%
	// jsp 로그인 구현
	// 1) 아이디, 암호를 입력
	// 2) 로그인 전후의 UI
	String test = "테스트";
	if(request.getMethod().equals("POST")) { // POST는 자바에서 상수기 때문에 대문자로 작성한다
		String mId = request.getParameter("mId"); // form의 id를 get
		
		Login l = new Login();
		boolean b = l.login(mId, "");
		if(b) {
			session.setAttribute("mId", mId);
			//session.setMaxInactiveInterval(1); // 초단위로 입력한다. 보통 로그인은 30분, 은행 로그인은 5분마다 로그인 갱신할지 물어보고 안하면 세션 지워짐
		} else {
			out.print("<script>alert('저리가')</script>");
			test = "ok";
		}
		
		//session.setAttribute("mId", mId);
	}

	String sessionId = (String)session.getAttribute("mId");
%>

<form name="frm_login" method="post">
	<span><%=test %></span>
	<%if(sessionId == null) { %>
	<!-- 로그인 전 -->
	<span>아이디</span>
	<input type="text" name="mId" value="a001"/>
	<span>암호</span>
	<input type="password" name="pwd" value="1111"/>
	<input type="button" value="로그인" name="btnLogin" id="btnLogin"/>
	<%} else { %>
	<!-- 로그인 후 -->
	<span><%=sessionId %>님 방가</span>
	<input type="button" value="로그아웃" name="btnLogout"/>
	<%} %>
	
	<!-- 
	<section class="vh-100 gradient-custom">
		<div class="container py-5 h-100">
			<div class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-12 col-md-8 col-lg-6 col-xl-5">
					<div class="card bg-dark text-white" style="border-radius: 1rem;">
						<div class="card-body p-5 text-center">

							<div class="mb-md-5 mt-md-4 pb-5">

								<h2 class="fw-bold mb-2 text-uppercase">Login</h2>
								<p class="text-white-50 mb-5">Please enter your login and password!</p>

								<div class="form-outline form-white mb-4">
									<input type="email" id="typeEmailX" class="form-control form-control-lg" />
									<label id="mId" class="form-label" for="typeEmailX">Id</label>
								</div>

								<div class="form-outline form-white mb-4">
									<input type="password" id="typePasswordX" class="form-control form-control-lg" />
									<label id="password" class="form-label" for="typePasswordX">Password</label>
								</div>

								<p class="small mb-5 pb-lg-2"><a class="text-white-50" href="#!">Forgot password?</a></p>

								<button id="btnLogin" class="btn btn-outline-light btn-lg px-5" type="submit">Login</button>

								<div class="d-flex justify-content-center text-center mt-4 pt-1">
									<a href="#!" class="text-white"><i class="fab fa-facebook-f fa-lg"></i></a>
									<a href="#!" class="text-white"><i class="fab fa-twitter fa-lg mx-4 px-2"></i></a>
									<a href="#!" class="text-white"><i class="fab fa-google fa-lg"></i></a>
								</div>

							</div>

							<div>
								<p class="mb-0">Don't have an account? <a href="#!" class="text-white-50 fw-bold">Sign Up</a>
								</p>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	 -->
</form>

<script>
	let frm = document.frm_login;
	
	//frm.abc.onclick = function() {
	//	alert("OK");
	//}
	// abc가 null이지만 실행할 여지가 없어서 프로그램이 죽지 않는다
	// 근데 왜 login버튼 누르지도 않는데 로그아웃버튼이 실행되지 않는가?
	// 반대로 logout버튼이 null이어도 로그인 버튼은 실행되는 이유는?
	
	if(frm.btnLogin != null) {
		frm.btnLogin.addEventListener("click", function() {
			frm.action = "login.jsp";
			frm.submit();
		});
	}
	
	if(frm.btnLogout != null) {
		frm.btnLogout.addEventListener("click", function() {
			frm.action = "logout.jsp";
			frm.submit();
		});
	}
	
	/*
	let btnLoginTest = document.querySelector("#btnLogin");
	if(btnLoginTest != null) {
		btnLoginTest.addEventListener("click", function() {
			frm.action = "login.jsp";
			frm.submit();
		});
	}
	*/
</script>

</body>
</html>