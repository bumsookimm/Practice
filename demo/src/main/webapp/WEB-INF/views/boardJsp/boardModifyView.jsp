<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/static/css/boardCss/boardView.css">
</head>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<%@ include file="/WEB-INF/views/includes/sideBar.jsp"%>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function(){
	
	var message = "${message}"
	var messageType = "${messageType}"
	console.log("Message: " + message); 
	console.log("Message Type: " + messageType);
	if(messageType === "success"){
		alert(message);
		window.location.href = "/boardList";
	}  else if (messageType === "error") {
		window.location.href = "/boardList";
		alert(message);
	}
});

</script>



<body>

	<div class="container">
		<h2>작성글 수정하기</h2>


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