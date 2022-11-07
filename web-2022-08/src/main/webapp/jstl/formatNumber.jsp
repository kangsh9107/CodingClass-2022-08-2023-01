<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl/formatNumber.jsp</title>
</head>
<body>

<h2>formatNumber | parseNumber</h2>
<fmt:formatNumber value='12345.6789' var='su' pattern='#,###,###.##'/>
<div>su = ${su }</div>
<fmt:formatNumber value='12345.6789' var='su2' pattern='0,000,000.00'/>
<div>su = ${su2 }</div>
<hr/>

<fmt:parseNumber value='${su }' var='nSu' pattern='#,###,###.##'/>
<div>nSu : ${nSu }</div>
<fmt:parseNumber value='${su }' var='nSu' pattern='#,###,###.##' integerOnly='true'/>
<div>nSu : ${nSu }</div>
<fmt:parseNumber value='${su }' var='nSu' pattern='#######.##' integerOnly='true'/>
<div>nSu : ${nSu }</div>

</body>
</html>