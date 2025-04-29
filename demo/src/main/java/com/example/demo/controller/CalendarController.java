package com.example.demo.controller;

import java.security.PrivateKey;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.SchedulerDto;
import com.example.demo.service.SchedulerDeleteService;
import com.example.demo.service.SchedulerListService;
import com.example.demo.service.SchedulerSaveService;
import com.example.demo.service.SchedulerUpdateService;

@Controller
public class CalendarController {

	@Autowired
	private SchedulerSaveService schedulerSaveService;

	@Autowired
	private SchedulerListService schedulerListService;

	@Autowired
	private SchedulerUpdateService schedulerUpdateService;

	@Autowired
	private SchedulerDeleteService schedulerDeleteService;

	@GetMapping("/calendar")
	private String calenderMain() {

		return "/calendarJsp/calendar";
	}

	@PostMapping("/calendar/save")
	private ResponseEntity<Map<String, Object>> calendarSave(@RequestBody SchedulerDto schedulerDto) {

		String user_id = schedulerDto.getUser_id();
		String content = schedulerDto.getContent();
		Date schedule_date = schedulerDto.getSchedule_date();

		Map<String, Object> result = schedulerSaveService.scheduleSave(user_id, schedule_date, content);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/calendar/list")
	private ResponseEntity<List<SchedulerDto>> calendarList() {

		List<SchedulerDto> ScheduleList = schedulerListService.schedulerList();

		return ResponseEntity.ok(ScheduleList);
	}

	@PutMapping("/calendar/update")
	private ResponseEntity<Map<String, Object>> calendarUpdate(@RequestBody SchedulerDto schedulerDto) {
		int schedule_id = schedulerDto.getSchedule_id();
		String content = schedulerDto.getContent();

		Map<String, Object> result = schedulerUpdateService.SchedulerUpdate(schedule_id, content);

		return ResponseEntity.ok(result);
	}

	@DeleteMapping("/calendar/delete/{schedule_id}")
	private ResponseEntity<Map<String, Object>> calenderDelete(@PathVariable("schedule_id") int schedule_id) {

		Map<String, Object> result = schedulerDeleteService.SchedulerDelete(schedule_id);

		return ResponseEntity.ok(result);
	}

}
