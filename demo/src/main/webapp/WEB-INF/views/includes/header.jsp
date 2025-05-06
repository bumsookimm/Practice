<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/static/css/modal.css">
<link rel="stylesheet" href="/static/css/header.css">

</head>
<body>
	<nav class="headercontain">
		<ul>
			<li><a href="/"> 홈 </a></li>
			<li><a href="/boardList"> 게시판 </a></li>
			<li><a href="/calculator"> 계산기 </a></li>
			<li><a href="/calendar"> 일정 </a></li>


			<li><a href="#" data-modal-target="#signUpModal" class="right-align"> 회원가입 </a></li>
			<li><a href="/logIn" class="right-align"> 로그인 </a></li>

		</ul>


	</nav>


	<div id="signUpModal" class="modal">
		<div class="modal-content">
			<span class="close-btn">&times;</span>
			<%@ include file="/WEB-INF/views/signUpJsp/signUpForm.jsp"%>
		</div>

	</div>

<script src="/static/js/modal.js"></script>

</body>
</html>