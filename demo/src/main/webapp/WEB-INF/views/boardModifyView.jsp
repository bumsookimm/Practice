<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/static/css/boardView.css">
</head>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<%@ include file="/WEB-INF/views/includes/sideBar.jsp"%>



<body>

	<div class="container">
		<h2>작성글 수정하기</h2>

		<div class="dateBox">
			<p>날짜:${formattedDate}</p>
		</div>
		<hr>
		
	<form action="/boardModify?id=${boardDto.board_no}" method="post">
		<%-- <input type="hidden" name="id" value="${boardDto.board_no}"> --%>
		
		
		<div class="box">
			<p>
				<strong>제목</strong> 
			<input type="text" name="title" value="${boardDto.board_title}">	
			</p>
		</div>



		<div class="box">
			<p>
				<strong>이름</strong> 
			<input type="text" name="name" value="${boardDto.board_name}">	
			</p>
		</div>


		<div class="box">
			<p>
				<strong>내용</strong>
				<textarea name="contents"> ${boardDto.board_content} </textarea>
			</p>
		</div>

		<div class="buttonGroup">
			<button type="submit">확인</button>
			<button onclick="location.href='/boardList'">취소</button>
		</div>
	</form>	
	</div>
</body>
</html>