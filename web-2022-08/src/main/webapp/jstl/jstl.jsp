<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl/jstl.jsp</title>
</head>
<body>
<%
/*
<!-- 
<c:out value="<h2>hi</h2>"/>
	<, > 문자가 문자 그대로 출력
	< -> &lt (less than)
	> -> &gt (greater than)

이 기능을 escapeXml="false"로 설정하면 <, > 문자가 태그로 사용된다
 -->

<!-- 
<c:set var='변수명' value='값' scope='page|request|session|application'/>
set의 scope를 정해주지 않으면 default가 pageScope다
 -->

<!-- 
<c:remove var='변수명' scope='scope의 종류'/>
 -->
*/
%>


<h2>c:out</h2>
<c:out value="Hello, World!"/><hr/>
<c:out value="<h2>hi</h2>"/><hr/>
<c:out value="<h2>hi</h2>" escapeXml="false"/><hr/>


<h2>c:set</h2>
<c:set var='id' value='a001'/>
id : ${pageScope.id }, ${id }, 없다 : ${requestScope.id }
<br/>
<c:set var='phone' value='010-3333-3333' scope='request'/>
phone : ${requestScope.phone }, ${phone }, 없다 :  ${pageScope.phone }
<%
String phone = (String)request.getAttribute("phone");
out.print(", 원래는 이렇게 쓴다 : " + phone);
%>


<br/>
<c:remove var='phone' scope='request'/>
After : ${requestScope.phone }...


<br/>
<c:set var='n1' value='100'/>
<c:set var='n2' value='200'/>
<li>n1 : <c:out value='${n1 }'/>
<li>n2 : <c:out value='${n2 }'/>
<br/>
<c:if test="${n1<n2 }">n1이 n2보다 큼</c:if>

</body>
</html>