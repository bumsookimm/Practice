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

<script>
function deleteBoard(boardNo){
	if(confirm("정말 삭제하시겠습니까?")){
		location.href = "/boardDelete?id=" + boardNo;
	}
}


</script>

<body>

	<div class="container">
		<h2>작성글 상세보기</h2>

		<div class="dateBox">
			<p>날짜:${formattedDate}</p>
		</div>
		<hr>
		<div class="box">
			<p>
				<strong>제목</strong> ${boardDto.board_title}
			</p>
		</div>



		<div class="box">
			<p>
				<strong>이름</strong> ${boardDto.board_name}
			</p>
		</div>


		<div class="box">
			<p>
				<strong>내용</strong>
				<textarea readonly> ${boardDto.board_content} </textarea>
			</p>
		</div>

		<div class="buttonGroup">
			<button onclick="location.href='/boardModifyView?id=${boardDto.board_no}'" >수정</button>
			<button onclick="deleteBoard(${boardDto.board_no})">삭제</button>
		</div>
	</div>
</body>
</html>