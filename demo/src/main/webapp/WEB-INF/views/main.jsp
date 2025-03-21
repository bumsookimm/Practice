<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연습용 홈페이지</title>
<link rel="stylesheet" href="/static/css/main.css">

</head>



<body>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
	<div class="slider">
		<div class="slide fade">
			<img alt="슬라이드 1" src="/static/images/slider1.png">
		</div>
		
		<div class="slide fade">
			<img alt="슬라이드 2" src="/static/images/slider2.jpg">
		</div>
		
		<div class="slide fade">
			<img alt="슬라이드 3" src="/static/images/slider3.jpg">
		</div>
	</div>

<script src="/static/js/main.js"></script>

</body>
</html>