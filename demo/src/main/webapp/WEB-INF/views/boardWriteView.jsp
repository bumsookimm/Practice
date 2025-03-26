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


<script src="/static/js/boardWriteView.js"></script>

<body>

	<div class="boardwritecontain">
		<h1>게시글 작성</h1>

		<form action="boardWrite" method="post">
			<div class="form-group">
				<div class = form-text>
				<label class="require">*필수</label> 
				<label for="title">제목</label> 
				</div>
				<input type="text" id="title" name="title" required>
			</div>

			<div class=form-group>
				<div class = form-text>
				<label class="require">*필수</label> 
				<label for="name">이름</label> 
				</div>
				<input type="text" id="name" name="name" required>

			</div>


			<div class=form-group>
				<div class = form-text>
				<label class="require">*필수</label> 
				<label for="content">내용</label>
				</div>
				<textarea id="content" name="content" rows="10" required></textarea>


			</div>

			<button type="submit">등록</button>
		</form>



	</div>


</body>
</html>