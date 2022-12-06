<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' href='css/board.css'>
<script defer src='js/board.js'></script>
<title>board/select.jsp</title>
</head>
<body>
	<div id='board'>
		<form class='frm_search' method='post'>
			<input type='hidden' name='nowPage' value='${pVo.nowPage }' /> <input
				type='hidden' name='sno' /> <input type='button' value='입력'
				class='btnInsert' /> <input type='search' autocomplete='off'
				name='findStr' size='40' value='${pVo.findStr }' /> <input
				type='button' value='조회' class='btnSearch' />
		</form>
		<div class='title'>
			<span class='no'>NO</span> <span class='subject'>제목</span> <span
				class='id'>작성자</span> <span class='nal'>작성일</span> <span class='hit'>조회수</span>
		</div>

	<div class='items'>
		<c:forEach var='vo' items='${list }'>
<%-- 			<c:choose>
				<c:when test="${vo.subject eq '삭제된 글입니다.' }">
					<div class='item'>
						<span class='no'>${vo.sno }</span>
						<span class='subject'> ${vo.subject } 
							<c:if test='${vo.attCnt>0 }'>
								(첨부:${vo.attCnt })
							</c:if>
						</span>
						<span class='id'>${vo.id }</span>
						<span class='nal'>${vo.nal }</span>
						<span class='hit'>${vo.hit }</span>
					</div>
				</c:when>
				<c:otherwise> --%>
					<div class='item' onclick="board.view(${vo.subject eq '삭제된 글입니다.' ? '0' : vo.sno })">
						<span class='no'>${vo.sno }</span>
						<span class='subject'> ${vo.subject } 
							<c:if test='${vo.attCnt>0 }'>
								(첨부:${vo.attCnt })
							</c:if>
						</span>
						<span class='id'>${vo.id }</span>
						<span class='nal'>${vo.nal }</span>
						<span class='hit'>${vo.hit }</span>
					</div>
<%-- 				</c:otherwise>
			</c:choose> --%>
		</c:forEach>
	</div>

	<div class='btnZone'>
		<c:if test="${pVo.startPage>1 }">
			<input type='button' value='맨첨' class='btnFirst'
				onclick='board.move(1)' />
			<input type='button' value='이전' class='btnPrev'
				onclick='board.move(${pVo.startPage-1})' />
		</c:if>

		<c:forEach var='i' begin='${pVo.startPage }' end='${pVo.endPage }'>
			<input type='button' value='${i }' class='btnMove'
				onclick='board.move(${i})' />
		</c:forEach>

		<c:if test="${pVo.totPage>pVo.endPage }">
			<input type='button' value='다음' class='btnNext'
				onclick='move(${pVo.endPage+1})' />
			<input type='button' value='맨끝' class='btnLast'
				onclick='board.move(${pVo.totPage})' />
		</c:if>

	</div>
	</div>
</body>
</html>