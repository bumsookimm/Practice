const calendarDays = document.getElementById("calendarDays");
const currentMonthDisplay = document.getElementById("currentMonth");
let currentDate = new Date();

const taskModal = document.getElementById("taskModal");
const taskList = document.getElementById("taskList");
const addTaskBtn = document.getElementById("addTaskBtn");
const closeModalBtn = document.getElementById("closeModalBtn");

const addTaskModal = document.getElementById("addTaskModal");
const newTaskContent = document.getElementById("newTaskContent");
const saveNewTaskBtn = document.getElementById("saveNewTaskBtn");
const closeAddModalBtn = document.getElementById("closeAddModalBtn");

const editTaskModal = document.getElementById("editTaskModal");
const editTaskContent = document.getElementById("editTaskContent");
const saveEditTaskBtn = document.getElementById("saveEditTaskBtn");
const closeEditModalBtn = document.getElementById("closeEditModalBtn");

let selectedDate = null;
let selectedDateStr = null;
let scheduleMapGlobal = {}; // 전역에 저장
let editingTaskId = null;   // 수정할 때 사용할 id 저장

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
				map[key].push({ id: item.schedule_id, content: item.content, isdone: item.isdone });

			});
			return map;
		});

	scheduleMapGlobal = scheduleMap;

	for (let i = 0; i < firstDay; i++) {
		const empty = document.createElement("div");
		calendarDays.appendChild(empty);
	}

	for (let day = 1; day <= lastDate; day++) {
		const dayEl = document.createElement("div");

		const dayText = document.createElement("p");
		dayText.textContent = day;

		const today = new Date();
		if (
			year === today.getFullYear() &&
			month === today.getMonth() &&
			day === today.getDate()
		) {
			dayText.classList.add("today");
		}

		const key = `${year}-${(month + 1).toString().padStart(2, "0")}-${day
			.toString()
			.padStart(2, "0")}`;

		if (scheduleMap[key]) {
			const taskListUl = document.createElement("ul");
			taskListUl.classList.add("task-list");

			scheduleMap[key].forEach((item) => {
				const li = document.createElement("li");
				li.textContent = item.content;
				li.classList.add(item.isdone === 1 ? "complete" : "incomplete");
				taskListUl.appendChild(li);
			});

			dayEl.appendChild(taskListUl);
		}

		dayEl.onclick = () => {
			selectedDate = day;
			selectedDateStr = key;
			taskList.innerHTML = "";

			if (scheduleMap[key]) {
				scheduleMap[key].forEach((item) => {
					const li = document.createElement("li");
					li.textContent = item.content;
					li.classList.add(item.isdone === 1 ? "complete" : "incomplete");

					const buttonWrapper = document.createElement("div");
					buttonWrapper.classList.add("button-wrapper");


					const statusBtn = document.createElement("button");
					statusBtn.classList.add("status-btn");
					statusBtn.textContent = item.isdone === 1 ? "완료됨" : "미완료";
					statusBtn.classList.add(item.isdone === 1 ? "complete" : "incomplete");
					statusBtn.onclick = () => {
						const newIsDone = item.isdone === 1 ? 0 : 1;

						fetch(`/calendar/isdone`, {
							method: "PUT",
							headers: { "Content-Type": "application/json" },
							body: JSON.stringify({
								schedule_id: item.id,
								isdone: newIsDone,
							}),
						})
							.then((res) => res.json())
							.then((data) => {
								alert(data.message);

								// 상태 및 클래스 업데이트
								item.isdone = newIsDone;

								// li 요소 클래스 업데이트
								li.classList.remove("complete", "incomplete");
								li.classList.add(newIsDone === 1 ? "complete" : "incomplete");

								// 버튼 텍스트 및 클래스도 즉시 변경
								statusBtn.textContent = newIsDone === 1 ? "완료됨" : "미완료";
								statusBtn.classList.remove("complete", "incomplete");
								statusBtn.classList.add(newIsDone === 1 ? "complete" : "incomplete");
							});
					};

					const editBtn = document.createElement("button");
					editBtn.textContent = "수정";
					editBtn.onclick = () => {
						editingTaskId = item.id;
						editTaskContent.value = item.content;
						taskModal.style.display = "none";
						editTaskModal.style.display = "flex";
					};

					const deleteBtn = document.createElement("button");
					deleteBtn.textContent = "삭제";
					deleteBtn.onclick = () => {
						if (confirm("삭제하시겠습니까?")) {
							fetch(`/calendar/delete/${item.id}`, {
								method: "DELETE",
								headers: { "Content-Type": "application/json" },
								body: JSON.stringify({ schedule_id: item.id }),
							})
								.then((res) => res.json())
								.then((data) => {
									alert(data.message);
									renderCalendar(currentDate);
									taskModal.style.display = "none";
								});
						}
					};

					buttonWrapper.appendChild(statusBtn);
					buttonWrapper.appendChild(editBtn);
					buttonWrapper.appendChild(deleteBtn);

					li.appendChild(buttonWrapper);
					taskList.appendChild(li);
				});
			}

			taskModal.style.display = "flex";
		};

		dayEl.appendChild(dayText);
		calendarDays.appendChild(dayEl);
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

addTaskBtn.onclick = () => {
	taskModal.style.display = "none";
	addTaskModal.style.display = "flex";
};

closeModalBtn.onclick = () => {
	taskModal.style.display = "none";
};

closeAddModalBtn.onclick = () => {
	addTaskModal.style.display = "none";
	newTaskContent.value = "";
};

saveNewTaskBtn.onclick = () => {
	const content = newTaskContent.value;
	if (content && selectedDate !== null) {
		fetch("/calendar/save", {
			method: "POST",
			headers: { "Content-Type": "application/json" },
			body: JSON.stringify({
				user_id: "user01",
				schedule_date: `${currentDate.getFullYear()}-${(currentDate.getMonth() + 1)
					.toString()
					.padStart(2, "0")}-${selectedDate.toString().padStart(2, "0")}`,
				content: content,
			}),
		})
			.then((res) => res.json())
			.then((data) => {
				alert(data.message);
				renderCalendar(currentDate);
				addTaskModal.style.display = "none";
				newTaskContent.value = "";
			})
			.catch((error) => {
				console.error("Error:", error);
			});
	} else {
		alert("할일 내용을 입력해 주세요.");
	}
};


saveEditTaskBtn.onclick = () => {
	const newContent = editTaskContent.value.trim();
	if (newContent && editingTaskId) {
		fetch("/calendar/update", {
			method: "PUT",
			headers: { "Content-Type": "application/json" },
			body: JSON.stringify({
				schedule_id: editingTaskId,
				content: newContent,
			}),
		})
			.then(res => res.json())
			.then(data => {

				alert(data.message);
				editTaskModal.style.display = "none";
				editingTaskId = null;
				renderCalendar(currentDate);
			});
	} else {
		alert("내용을 입력하세요.");
	}
};


closeEditModalBtn.onclick = () => {
	editTaskModal.style.display = "none";
	editingTaskId = null;
};

renderCalendar(currentDate);
