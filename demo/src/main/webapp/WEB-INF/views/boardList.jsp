<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<link rel="stylesheet" href="/static/css/boardList.css">
</head>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<%@ include file="/WEB-INF/views/includes/sideBar.jsp"%>
<body>

			<h2>게시판 리스트</h2>
		<table class = boardTable> 
				
			<tr>
			<th> 번호 </th>
			<th> 제목 </th>
			<th> 글쓴이 </th>
			<th> 내용 </th>			
			</tr>
		
		<c:forEach var ="board" items ="${boardDto}">
			<tr>
			<td>${board.board_no}</td>
			<td> <a href="/boardView?id=${board.board_no}"> ${board.board_title} </a></td>
			<td>${board.board_name}</td>
			<td>${board.board_content}</td>
					</tr>
		
		</c:forEach>
		
		</table>

	<div class="pagination">
		<c:forEach begin="1" end="${totalPage}" var="p">
			<a href="boardList?page=${p}"
			class ="${p == currentPage ? 'active' : '' }">
			[${p}]
			</a>
		</c:forEach>
	
	</div>


</body>
</html>