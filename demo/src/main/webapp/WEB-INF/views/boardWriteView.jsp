<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<link rel="stylesheet" href="/static/css/boardWriteView.css">
</head>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<%@ include file="/WEB-INF/views/includes/sideBar.jsp"%>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script src="/static/js/boardWriteView.js"></script>


<script >

$(document).ready(function() {

	var message = "${message}";
	var messageType = "${messageType}";
	console.log("Message: " + message); // message가 제대로 전달되는지 확인
	console.log("Message Type: " + messageType);
	if (message) {

		if (messageType === "success") {
			alert(message);
			window.location.href ="/board";
		} else if (messageType === "error") {
			alert(message);

		}

	}


});
</script>

<body>

	<div class="container">

		<h2>게시판 작성</h2>




		<form action="boardWriteSave" method="post" class="boardform" enctype="multipart/form-data">			
			
			<input type="file" name="files" multiple>
			
			<div class="form">
				<div class="textgroup">
					<label class="require">필수</label> <label class="texts">제목</label>
				</div>
				<input type="text" id="title" name="title" required>
			</div>

			<div class="form">
				<div class="textgroup">
					<label class="require">필수</label> <label class="texts">이름</label>
				</div>

				<input type="text" id="name" name="name" required>
			</div>

			<div class="form">
				<div class="textgroup">
					<label class="require">필수</label> <label class="texts" >내용</label>
				</div>
				<textarea id="contents" name="contents" rows="10" required></textarea>
			</div>

			<button type="submit">작성</button>

		</form>

		



	</div>


</body>
</html>