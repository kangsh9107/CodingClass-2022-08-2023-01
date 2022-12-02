<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script defer src="../mybatis/main.js"></script>
<title>mybatisScore/score_view.jsp</title>
</head>
<body>

<div id="score">
	<strong style="font-size: 2rem; display: inline-block; margin-bottom: 20px;">성적관리 View</strong>
	<form name="frm" class="frm" method="post" enctype="multipart/form-data">
		<input type="hidden" name="findStr" value="${pVo.findStr }"/>
		<input type="hidden" name="nowPage" value="${pVo.nowPage }"/>
		<input type="hidden" name="serial" value="${sVo.serial }"/>
		
		<span>아이디</span>
		<input type="text" name="id" value="${sVo.id }" readOnly/>
		<br/>
		<span>과목</span>
		<input type="text" name="subject" value="${sVo.subject }" readOnly/>
		<br/>
		<span>점수</span>
		<input type="text" name="score" value="${sVo.score }" readOnly/>
		<br/>
		<span>시험일자</span>
		<input type="date" name="mDate" value="${sVo.mDate }" readOnly/>
		<br/>
		<input type="button" id="btnScoreUpdate"  value="수정" class="btn btn-outline-light btnScore" style="background-color: rgb(151, 188, 98);"/>
		<input type="button" id="btnScoreDeleteR"  value="삭제" class="btn btn-outline-light btnScore" style="background-color: rgb(151, 188, 98);"/>
		<input type="button" id="btnScoreList"  value="취소" class="btn btn-outline-light btnScore" style="background-color: rgb(151, 188, 98);"/>
	</form>
</div>

</body>
</html>