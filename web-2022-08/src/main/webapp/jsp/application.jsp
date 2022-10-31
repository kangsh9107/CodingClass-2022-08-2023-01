<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp/application.jsp</title>
</head>
<body>

<%
// application 영역에 저장된 접속자수를 가져옴
// application은 1개만 존재하고 서버를 껐다 켜는 게 아니면 초기화 되지 않는다
// 그래서 새로운 사용자가 접속하면 누적된 cnt가 출력된다
Object o = application.getAttribute("cnt"); // 오브젝트 타입은 자바로 만든 모든 클래스를 저장할 수 있다
int cnt = 1;

if(o == null) { // 방문자가 없는 경우
	cnt = 1;
} else {
	cnt = (Integer)o;
	cnt++;
}

application.setAttribute("cnt", cnt);
%>

<b>오늘 방문자 수 : <%=cnt %></b>
</body>
</html>