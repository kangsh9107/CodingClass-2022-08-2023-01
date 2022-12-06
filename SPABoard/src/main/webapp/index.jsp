<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<!-- META -->
<meta charset="UTF-8">
<meta name="VIEWPORT" content="width=device-width, initial-scale=1.0">
<!-- FAVICON -->
<link rel="apple-touch-icon" sizes="57x57" href="img/apple-icon-57x57.png">
<link rel="apple-touch-icon" sizes="60x60" href="img/apple-icon-60x60.png">
<link rel="apple-touch-icon" sizes="72x72" href="img/apple-icon-72x72.png">
<link rel="apple-touch-icon" sizes="76x76" href="img/apple-icon-76x76.png">
<link rel="apple-touch-icon" sizes="114x114" href="img/apple-icon-114x114.png">
<link rel="apple-touch-icon" sizes="120x120" href="img/apple-icon-120x120.png">
<link rel="apple-touch-icon" sizes="144x144" href="img/apple-icon-144x144.png">
<link rel="apple-touch-icon" sizes="152x152" href="img/apple-icon-152x152.png">
<link rel="apple-touch-icon" sizes="180x180" href="img/apple-icon-180x180.png">
<link rel="icon" type="image/png" sizes="192x192"  href="img/android-icon-192x192.png">
<link rel="icon" type="image/png" sizes="32x32" href="img/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="96x96" href="img/favicon-96x96.png">
<link rel="icon" type="image/png" sizes="16x16" href="img/favicon-16x16.png">
<link rel="manifest" href="img/manifest.json">
<meta name="msapplication-TileColor" content="#ffffff">
<meta name="msapplication-TileImage" content="img/ms-icon-144x144.png">
<meta name="theme-color" content="#ffffff">
<!-- CSS -->
<link rel=stylesheet href="css/index.css">
<!-- JS -->
<script src="lib/jquery-3.6.1.min.js"></script>
<script defer src="js/index.js"></script>
<title>index.jsp</title>
</head>
<body>
<div id='main'>
    <header>
        <nav>
            <a href='index.jsp'>HOME</a>
            <a href='#' class='board'>게시판</a>
        </nav>
    </header>
    <div id='content'>
        <div class='info'>
            <h3>SPA(Single Page Application)를 제작함.</h3>
            <ul>
                <li>API & Library : servlet, jstl, ajax, jquery</li>
                <li>DB : mysql </li>
                <li>Framework : mybatis</li>
            </ul>               
        </div>
    </div>
    <footer>
        <font size='5' color='#00f'>S P A</font><br/>
        servlet,jstl,jquery,mysql로 만들어진 Single Page Application
    </footer>
</div>
</body>
</html>
