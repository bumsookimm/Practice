/**
 * 
 */
const calendarDays = document.getElementById("calendarDays");
const currentMonthDisplay = document.getElementById("currentMonth");
let currentDate = new Date();


function renderCalendar(date){
	calendarDays.innerHTML ="";
	
	const year = date.getFullYear();
	const month = date.getMonth();
	currentMonthDisplay.textContent =  `${year}년 ${month +1}월`;
	
	const firstDay = new Date(year, month, 1).getDay();
	const lastDate = new Date(year, month + 1, 0).getDate();
	 
	for(let i = 0; i < firstDay; i++){
		const empty = document.createElement("div");
		calendarDays.appendChild(empty);
	}
	
	
	for(let day = 1; day < lastDate; day++){
		const dayE1 = document.createElement("div");
		dayE1.textContent = day;
	
	
	const today = new Date();
	if(
		year === today.getFullYear() &&
		month === today.getMonth() &&
		day === today.getDate() 
		){
			dayE1.classList.add("today");
		}
		calendarDays.appendChild(dayE1);
	}
}

	renderCalendar(currentDate);
	
	document.getElementById("prevMonth").onclick =() => {
		currentDate.setMonth(currentDate.getMonth() - 1);
		renderCalendar(currentDate);
	};

	document.getElementById("nextMonth").onclick =() => {
		currentDate.setMonth(currentDate.getMonth() +1);
		renderCalendar(currentDate);
	};
