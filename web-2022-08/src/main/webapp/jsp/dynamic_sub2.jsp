<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp/dynamic_sub2.jsp</title>
</head>
<body>

<%
	int dan = Integer.parseInt(request.getParameter("dan")); // request는 String으로 반환한다.

	for(int i=1; i<=9; i++) {
		int r = dan * i;
		out.print(r + " ");
	}
%>

</body>
</html>