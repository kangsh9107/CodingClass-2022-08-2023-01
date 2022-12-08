<%@page import="com.example.Spring202208.board.BoardVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEB-INF/view/board/board_select.jsp</title>
</head>
<body>

<%
//mybatis를 사용하지 않을 때
/* List<String> subjects = (List<String>)request.getAttribute("subjects");
for(String s : subjects) {
	out.print("<li>" + s);
} */

List<BoardVo> list = (List<BoardVo>)request.getAttribute("list");
out.print("<ol>");
for(BoardVo v : list) {
	out.print("<li>" + v.getSno() + " / " + v.getId() + " / " + v.getSubject());
}
%>

</body>
</html>