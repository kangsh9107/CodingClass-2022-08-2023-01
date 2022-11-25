<%@page import="org.json.simple.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/* file name : ajax/movie.jsp */
/* 상영관에 따른 영화제목은 JSONArray로 반환 */
/* 원래 DB에서 가져와야 하지만 간단하게 하려고 일부러 JSONArray를 사용했다. */
JSONArray movie = new JSONArray();
String theater = request.getParameter("theater");

switch(theater) {
case "CGV":
	movie.add("아바타");
	movie.add("어벤져스: 엔드게임");
	movie.add("타이타닉");
	movie.add("스타워즈: 깨어난 포스");
	movie.add("어벤져스: 인피니티 워");
	movie.add("쥬라기 월드");
	movie.add("어벤져스");
	movie.add("분노의 질주: 더 세븐");
	movie.add("겨울왕국 2");
	movie.add("어벤져스: 에이지 오브 울트론");
	movie.add("블랙 팬서");
	movie.add("해리 포터와 죽음의 성물 2부");
	movie.add("스타워즈: 라스트 제다이");
	movie.add("쥬라기 월드: 폴른 킹덤");
	movie.add("겨울왕국");
	movie.add("미녀와 야수");
	break;
case "롯데시네마":
	movie.add("인크레더블 2");
	movie.add("분노의 질주: 더 익스트림");
	movie.add("아이언맨 3");
	movie.add("미니언즈");
	movie.add("캡틴 아메리카: 시빌 워");
	movie.add("아쿠아맨");
	movie.add("캡틴 마블");
	movie.add("트랜스포머 3");
	movie.add("반지의 제왕: 왕의 귀환");
	movie.add("007 스카이폴");
	movie.add("트랜스포머: 사라진 시대");
	movie.add("다크 나이트 라이즈");
	break;
case "메가박스":
	movie.add("토이 스토리 3");
	movie.add("캐리비안의 해적: 낯선 조류");
	movie.add("슈퍼배드 3");
	movie.add("쥬라기 공원");
	movie.add("도리를 찾아서");
	movie.add("스타워즈 에피소드 1: 보이지 않는 위험");
	movie.add("이상한 나라의 앨리스");
	movie.add("주토피아");
	movie.add("호빗: 뜻밖의 여정");
	movie.add("해리포터와 마법사의 돌");
	movie.add("다크 나이트");
	movie.add("슈퍼배드 2");
	movie.add("라이온 킹");
	movie.add("정글 북");
	movie.add("캐리비안의 해적: 세상의 끝에서");
	movie.add("쥬만지: 새로운 세계");
	movie.add("해리 포터와 죽음의 성물 1부");
	movie.add("호빗: 스마우그의 폐허");
	movie.add("호빗: 다섯 군대 전투");
	movie.add("니모를 찾아서");
	movie.add("해리 포터와 불사조 기사단");
	break;
}

out.print(movie.toJSONString());
%>