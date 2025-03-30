<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<link rel="stylesheet" href="/static/css/bordList.css">
</head>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<%@ include file="/WEB-INF/views/includes/sideBar.jsp"%>
<body>

			<h2>게시판 리스트</h2>
	<table border="1" class="listTable">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		
		<c:forEach var="pBoard" items="${boardDto}">
			<tr>
			<td>${pBoard.board_no }</td>
			<td><a href="boardView?id=${pBoard.board_no}">${pBoard.board_title}</a></td>
			<td>${pBoard.board_name }</td>
			<td>${pBoard.board_created }</td>		
		</tr>			
		</c:forEach>

	</table>




</body>
</html>