<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script defer src="member.js"></script>
<title>mybatis/member_select.jsp</title>
</head>
<body>

<!-- Member List -->
<div id="member">
	<form name="frm" class="frm" method="post" enctype="multipart/form-data" style="position: relative;">
		<strong style="font-size: 2rem;">회원관리</strong>
		<input type="button" id="btnInsert" class="btn btn-outline-light" value="입력" style="background-color: rgb(151, 188, 98); font-weight: 600; height: 29px; position: absolute; right: 260px; bottom: 9px; line-height: 10px; font-family: Gil Sans;">
		<input type="search" name="findStr" value="${pVo.findStr }" autocomplete="off" style="border-radius: 6px; border: 1px solid rgb(151, 188, 98); position: absolute; right: 68px; bottom: 9px; font-family: Gil Sans;"/>
		<input type="button" id="btnSearch" class="btn btn-outline-light" value="검색" style="background-color: rgb(151, 188, 98); font-weight: 600; height: 28px; position: absolute; right: 0; bottom: 9px; line-height: 10px; font-family: Gil Sans;">
		<input type="hidden" name="nowPage" value="${pVo.nowPage }"/>
	</form>
	<div class="items">
		<div class="item_title" style="font-family: Gugi; font-weight: 600; border-top: 2px solid rgb(151, 188, 98); border-bottom: 2px solid rgb(151, 188, 98); margin: 10px 0 10px 0;">
			<span class="no">NO</span>
			<span class="id">아이디</span>
			<span class="name">성명</span>
			<span class="gender">성별</span>
			<span class="phone">연락처</span>
			<span class="mdate">가입일자</span>
		</div>
		<div id="item_list" style="font-family: Gugi;">
			<c:forEach var="vo" items="${list }" varStatus="status">
				<div class="item" onclick="view('${vo.id }')">
					<span class="no">${status.count + pVo.startNo }</span>
					<span class="id">${vo.id }</span>
					<span class="name">${vo.name }</span>
					<span class="gender">${vo.gender }</span>
					<span class="phone">${vo.phone }</span>
					<span class="mdate">${vo.mDate }</span>
				</div>
			</c:forEach>
		</div>
		
	</div>
</div>

<!-- PageButton -->
<div class="btn-toolbar" style="justify-content: center; border-top: 2px solid rgb(151, 188, 98); margin-top: 10px; padding-top: 10px;" role="toolbar" aria-label="Toolbar with button groups">
	<c:if test="${pVo.startPage > 1 }">
		<div class="btn-group me-2" role="group" aria-label="First group">
			<button type="button" class="btn btn-outline-light" style="background-color: rgb(151, 188, 98); font-family: Gil Sans;" onclick="movePage(1)">처음</button>
			<button type="button" class="btn btn-outline-light" style="background-color: rgb(151, 188, 98); font-family: Gil Sans;" onclick="movePage(${pVo.startPage - 1})"><</button>
		</div>
	</c:if>
	
	<div class="btn-group me-2" role="group" aria-label="Second group">
		<c:forEach var="i" begin="${pVo.startPage }" end="${pVo.endPage }">
			<button type="button" class="btn btn-outline-light" style="background-color: rgb(151, 188, 98); font-family: Gil Sans;" onclick="movePage(${i })">${i }</button>
		</c:forEach>
	</div>
	
	<c:if test="${pVo.totPage > pVo.endPage }">
		<div class="btn-group" role="group" aria-label="Third group">
			<button type="button" class="btn btn-outline-light" style="background-color: rgb(151, 188, 98); font-family: Gil Sans;" onclick="movePage(${pVo.endPage + 1 })">></button>
			<button type="button" class="btn btn-outline-light" style="background-color: rgb(151, 188, 98); font-family: Gil Sans;" onclick="movePage(${pVo.totPage })">맨끝</button>
		</div>
	</c:if>
</div>

</body>
</html>