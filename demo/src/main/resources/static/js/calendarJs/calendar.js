const calendarDays = document.getElementById("calendarDays");
const currentMonthDisplay = document.getElementById("currentMonth");
let currentDate = new Date();

const taskModal = document.getElementById("taskModal");
const taskContent = document.getElementById("taskContent");
const saveTaskBtn = document.getElementById("saveTaskBtn");
const closeModalBtn = document.getElementById("closeModalBtn");

let selectedDate = null;  

async function renderCalendar(date) {
  calendarDays.innerHTML = "";
  const year = date.getFullYear();
  const month = date.getMonth();
  currentMonthDisplay.textContent = `${year}년 ${month + 1}월`;

  const firstDay = new Date(year, month, 1).getDay();
  const lastDate = new Date(year, month + 1, 0).getDate();

  const scheduleMap = await fetch("/calendar/list", {
    method: "GET",
  })
    .then((res) => res.json())
    .then((data) => {
      const map = {};
      data.forEach((item) => {
        const d = new Date(item.schedule_date);
        const key = `${d.getFullYear()}-${(d.getMonth() + 1)
          .toString()
          .padStart(2, "0")}-${d.getDate().toString().padStart(2, "0")}`;
        if (!map[key]) map[key] = [];
        map[key].push(item.content);
      });
      return map;
    });

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

    const key = `${year}-${(month + 1).toString().padStart(2, "0")}-${day
      .toString()
      .padStart(2, "0")}`;

    if (scheduleMap[key]) {
      const taskList = document.createElement("ul");
      taskList.classList.add("task-list");

      scheduleMap[key].forEach((content) => {
        const li = document.createElement("li");
        li.textContent = content;
        taskList.appendChild(li);
      });

      dayE1.appendChild(taskList);
    }

    dayE1.onclick = () => {
      selectedDate = day;
      taskModal.style.display = "flex";
    };

    calendarDays.appendChild(dayE1);
  }
}

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
  if (content && selectedDate !== null) {  // selectedDate가 null이 아니어야만 처리
    fetch("/calendar/save", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        user_id: "user01",
        schedule_date: `${currentDate.getFullYear()}-${(currentDate.getMonth() + 1)
          .toString().padStart(2, '0')}-${selectedDate.toString().padStart(2, '0')}`,
        content: content
      })
    })
      .then(res => res.text())  
      .then(data => {
        renderCalendar(currentDate); 
        taskModal.style.display = 'none'; 
      })
      .catch(error => {
        console.error("Error:", error);  
      });
  } else {
    alert("날짜를 선택해 주세요.");
  }
};

closeModalBtn.onclick = () => {
  taskModal.style.display = 'none';
  taskContent.value = '';  // 텍스트 비우기
};

renderCalendar(currentDate);
