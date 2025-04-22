const calendarDays = document.getElementById("calendarDays");
const currentMonthDisplay = document.getElementById("currentMonth");
let currentDate = new Date();

const taskModal = document.getElementById("taskModal");
const taskContent = document.getElementById("taskContent");
const saveTaskBtn = document.getElementById("saveTaskBtn");
const closeModalBtn = document.getElementById("closeModalBtn");

let selectedDate = null;  

function renderCalendar(date) {
  calendarDays.innerHTML = "";
  const year = date.getFullYear();
  const month = date.getMonth();
  currentMonthDisplay.textContent = `${year}년 ${month + 1}월`;

  const firstDay = new Date(year, month, 1).getDay();
  const lastDate = new Date(year, month + 1, 0).getDate();


  for (let i = 0; i < firstDay; i++) {
    const empty = document.createElement("div");
    calendarDays.appendChild(empty);
  }


  for (let day = 1; day <= lastDate; day++) {
    const dayE1 = document.createElement("div");
    dayE1.textContent = day;

    const today = new Date();
    if (
      year === today.getFullYear() &&
      month === today.getMonth() &&
      day === today.getDate()
    ) {
      dayE1.classList.add("today");
    }

   
    dayE1.onclick = () => {
      selectedDate = day;  
      taskModal.style.display = 'flex'; 
    };

    calendarDays.appendChild(dayE1);
  }
}

// 이전 달, 다음 달 버튼 클릭 시 달력 변경
document.getElementById("prevMonth").onclick = () => {
  currentDate.setMonth(currentDate.getMonth() - 1);
  renderCalendar(currentDate);
};

document.getElementById("nextMonth").onclick = () => {
  currentDate.setMonth(currentDate.getMonth() + 1);
  renderCalendar(currentDate);
};


saveTaskBtn.onclick = () => {
  const content = taskContent.value;
  if (content) {
    fetch("/calendar/add", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        user_id: "user01",
        schedule_date: `${currentDate.getFullYear()}-${currentDate.getMonth() + 1}-${selectedDate}`,
        content: content
      })
    }).then(() => {
      renderCalendar(currentDate);
      taskModal.style.display = 'none';  
    });
  }
};


closeModalBtn.onclick = () => {
  taskModal.style.display = 'none';
  taskContent.value = '';  // 텍스트 비우기
};

renderCalendar(currentDate);
