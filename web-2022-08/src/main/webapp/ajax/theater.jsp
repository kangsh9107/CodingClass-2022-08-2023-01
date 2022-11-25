<%@page import="org.json.simple.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/* file name : ajax/theater.jsp */
/* 지역에 따른 상영관은 JSONArray로 반환 */
/* 원래 DB에서 가져와야 하지만 간단하게 하려고 일부러 JSONArray를 사용했다. */
JSONArray theater = new JSONArray();
String city = request.getParameter("city");

switch(city) {
case "서울":
	theater.add("CGV");
	theater.add("롯데시네마");
	break;
case "인천":
	theater.add("메가박스");
	break;
}

out.print(theater.toJSONString());
%>