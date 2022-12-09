<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<!-- META -->
<meta charset="UTF-8">
<!-- CSS -->
<link rel="stylesheet" href="css/guestbook.css">
<title>WEB-INF/guestbook/guestbook_select.jsp</title>
</head>
<body>

<!-- CONTENT -->
<div id="guestbook_list">
	<div class="guestbook_items">
		<c:forEach var="i" begin="1" end="4">
			<div class="item">
				<form class="frm frm_insert" method="post" enctype="multipart/form-data">
					<label>작성자</label>
					<input type="text" name="id" value="hong"/><br/>
					<label>제목</label>
					<input type="text" name="subject" class="subject" value="제목"/><br/>
					<label></label>
					<textarea rows="5" cols="50" name="doc" class="doc">내용</textarea><br/>
					<label>첨부</label>
					<input type="file" name="attFile" multiple="multiple"/>
					<div class="btnZone">
						<input type="button" value="취소" class="btnSelect">
						<input type="button" value="저장" class="btnInsertR">
						<input type="hidden" name="nowPage" value="">
						<input type="hidden" name="findStr" value="">
					</div>
				</form>
			</div>
		</c:forEach>
	</div>
</div>
<!-- PAGE BUTTON -->
<div class="btn-toolbar" style="justify-content: center; border-top: 2px solid rgb(27, 84, 75); margin-top: 10px; padding-top: 10px;" role="toolbar" aria-label="Toolbar with button groups">
	<div class="btn-group me-2" role="group" aria-label="First group">
		<button type="button" class="btn btn-outline-light" style="background-color: rgb(164, 32, 42); font-family: Gil Sans; font-weight: 600;">처음</button>
		<button type="button" class="btn btn-outline-light" style="background-color: rgb(164, 32, 42); font-family: Gil Sans; font-weight: 600;"><</button>
	</div>
	
	<div class="btn-group me-2" role="group" aria-label="Second group">
		<c:forEach var="i" begin="1" end="5">
			<button type="button" class="btn btn-outline-light" style="background-color: rgb(164, 32, 42); font-family: Gil Sans; font-weight: 600;">${i }</button>
		</c:forEach>
	</div>
	
	<div class="btn-group" role="group" aria-label="Third group">
		<button type="button" class="btn btn-outline-light" style="background-color: rgb(164, 32, 42); font-family: Gil Sans; font-weight: 600;">></button>
		<button type="button" class="btn btn-outline-light" style="background-color: rgb(164, 32, 42); font-family: Gil Sans; font-weight: 600;">맨끝</button>
	</div>
</div>

</body>
</html>