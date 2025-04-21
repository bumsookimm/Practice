<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일정표</title>
<link rel="stylesheet" href="/static/css/calendarCss/calendar.css" >
</head>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<%@ include file="/WEB-INF/views/includes/sideBar.jsp"%>


<body>

	<div class="calender-container">
		
		<div class="calendar-header" >
		
		<button id="prevMonth">◀</button>
		
		<h2 id = "currentMonth"></h2>
		
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
		
		<div class="calendar-days" id="calendarDays">
		
		</div>	
	</div>


<script src="/static/js/calendarJs/calendar.js"></script>
</body>
</html>