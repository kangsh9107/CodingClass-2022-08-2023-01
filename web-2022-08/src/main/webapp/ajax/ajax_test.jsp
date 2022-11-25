<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax/ajax_test.jsp</title>
<link href="https://fonts.googleapis.com/css?family=East+Sea+Dokdo:400" rel="stylesheet">
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
	border: 2px solid black;
	min-height: 60px;
}

#append2 {
	display: grid;
	grid-template-columns: 50px 60px 125px 200px;
	grid-column-gap: 10px;
	width: 545px;
	min-height: 225px;
	overflow: auto;
	position: relative;
	margin-top: 20px;
	margin-bottom: 20px;
	font-family: East Sea Dokdo;
	font-weight: 600;
	font-size: 2rem;
	background-image: linear-gradient(120deg, #a1c4fd 0%, #c2e9fb 100%);
	border-radius: 20px;
	padding: 10px;
	box-sizing: border-box;
	box-shadow: rgba(0, 0, 0, 0.17) 0px -23px 25px 0px inset, rgba(0, 0, 0, 0.15) 0px -36px 30px 0px inset, rgba(0, 0, 0, 0.1) 0px -79px 40px 0px inset, rgba(0, 0, 0, 0.06) 0px 2px 1px, rgba(0, 0, 0, 0.09) 0px 4px 2px, rgba(0, 0, 0, 0.09) 0px 8px 4px, rgba(0, 0, 0, 0.09) 0px 16px 8px, rgba(0, 0, 0, 0.09) 0px 32px 16px;
}

select {
	font-family: East Sea Dokdo;
	font-size: 1.5rem;
}

#city {
	width: 49.26px;
	hegith: 64px;
}

#theater {
	width: 112.67px;
	hegith: 95px;
}

#movie {
	width: 192.67px;
	hegith: 157px;
}
</style>
<script defer src="ajax_test.js"></script>
<!-- <script defer src="test.js"></script> -->

</head>
<body>

<h2>Ajax Test</h2>
<input type="button" value="Load Text File" id="btnLoadText"/>
<input type="button" value="Load Html File" id="btnLoadHtml"/>
<input type="button" value="Load Jsp File" id="btnLoadJsp"/>
<input type="button" value="Load Json File" id="btnLoadJson"/>
<input type="button" value="학생정보 조회" id="btnStudent"/>
<input type="button" value="직원정보 조회" id="btnEmployee"/>

<input type="button" value="추가" id="btnInsert"/>
<input type="button" value="삭제" id="btnDelete"/>
<div id="appendZone"></div>

<hr/>
<div id="append2">
	<div></div>
	<div>
		<span>지역</span>
		<br/>
		<select id="city" size="2">
			<option value="서울">서울</option>
			<option value="인천">인천</option>
		</select>
	</div>
	<div>
		<span>상영관</span>
		<br/>
		<select id="theater" size="3">
		</select>
	</div>
	<div>
		<span>상영 영화</span>
		<br/>
		<select id="movie" size="5">
		</select>
	</div>
</div>

<hr/>
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
	
	<div id="append1"></div>
</section>
</body>
</html>









