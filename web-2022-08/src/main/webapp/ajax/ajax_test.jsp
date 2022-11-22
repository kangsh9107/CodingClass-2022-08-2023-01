<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax/ajax_test.jsp</title>
<style>
section#mainSection {
	padding: 0px;
	margin: 0px;
	display: grid;
	grid-template-columns: 1fr 1fr 1fr 1fr;
	grid-column-gap: 10px;
	grid-row-gap: 10px;
}

div.mainDiv {
	display: inline-block;
	box-sizing: border-box;
	padding: 5px;
	border: 2px solid black;
	min-height: 210px;
}

div#student {
	grid-column-start: 1;
	grid-column-end: 5;
	display: grid;
	grid-template-columns: 1fr;
	grid-row-gap: 10px;
	grid-template-rows: 1fr 3fr;
}

div#employee {
	grid-column-start: 1;
	grid-column-end: 5;
	display: grid;
	grid-template-columns: 1fr;
	grid-row-gap: 10px;
	grid-template-rows: 1fr 3fr;
}

span.main {
	box-sizing: border-box;
	border: 2px solid blue;
	min-height: 60px;
}
</style>

</head>
<body>

<h2>Ajax Test</h2>
<input type="button" value="Load Text File" id="btnLoadText"/>
<input type="button" value="Load Html File" id="btnLoadHtml"/>
<input type="button" value="Load Jsp File" id="btnLoadJsp"/>
<input type="button" value="Load Json File" id="btnLoadJson"/>
<input type="button" value="학생정보 조회" id="btnStudent"/>
<input type="button" value="직원정보 조회" id="btnEmployee"/>
<input type="button" value="테스트" id="btnTest2"/>
<hr/>
<section id="mainSection">
	<div class="mainDiv" id="text"></div>
	<div class="mainDiv" id="html"></div>
	<div class="mainDiv" id="jsp"></div>
	<div class="mainDiv" id="json"></div>
	<div class="mainDiv" id="student">
		<span class="main" id="frm"></span>
		<span class="main" id="list"></span>
	</div>
	<div class="mainDiv" id="employee">
		<span class="main" id="frm_employee"></span>
		<span class="main" id="employee_list"></span>
	</div>
</section>
<script src="ajax_test.js"></script>
<script src="test.js"></script>
</body>
</html>









