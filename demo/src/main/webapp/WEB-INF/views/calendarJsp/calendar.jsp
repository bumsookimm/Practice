<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일정표</title>
<link rel="stylesheet" href="/static/css/calendarCss/calendar.css">
</head>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<%@ include file="/WEB-INF/views/includes/calendarSideBar.jsp"%>


<body>

	<div class="calender-container">

		<div class="calendar-header">

			<button id="prevMonth">◀</button>

			<h2 id="currentMonth"></h2>

			<button id="nextMonth">▶</button>
		</div>

		<div class="calendar-weekdays">
			<div>일</div>
			<div>월</div>
			<div>화</div>
			<div>수</div>
			<div>목</div>
			<div>금</div>
			<div>토</div>
		</div>

		<div class="calendar-days" id="calendarDays"></div>
	</div>

	<div id="taskModal" class="modal">
		<div class="modal-content">
			<h3>할일 목록</h3>
			<ul id="taskList" class="taskList"></ul>
			<div class="acBtn">
				<button id="addTaskBtn" class="addTaskBtn">추가</button>
				<button id="closeModalBtn" class="closeModalBtn">닫기</button>
			</div>
		</div>
	</div>


	<div id="addTaskModal" class="modal">
		<div class="modal-content">
			<h3>새 할일 추가</h3>
			<textarea id="newTaskContent" placeholder="새 할일을 입력하세요"></textarea>
			<button id="saveNewTaskBtn" class="saveNewTaskBtn">저장</button>
			<button id="closeAddModalBtn" class="closeAddModalBtn">취소</button>
		</div>
	</div>


	
	<div id="editTaskModal" class="modal">
		<div class="modal-content">
			<h3>할일 수정</h3>
			<textarea id="editTaskContent" placeholder="할일을 수정하세요"></textarea>
			<button id="saveEditTaskBtn">수정 완료</button>
			<button id="closeEditModalBtn">취소</button>
		</div>
	</div>


	<script src="/static/js/calendarJs/calendar.js"></script>
</body>
</html>