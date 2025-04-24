package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.SchedulerDto;
import com.example.demo.service.SchedulerListService;
import com.example.demo.service.SchedulerSaveService;

@Controller
public class CalendarController {

	@Autowired
	private SchedulerSaveService schedulerSaveService;
	
	@Autowired
	private SchedulerListService schedulerListService;
	
	@GetMapping("/calendar")
	private  String calenderMain() {
		
		
	return"/calendarJsp/calendar";
	}
	
	@PostMapping("/calendar/save")
	private ResponseEntity<String> calendarSave(@RequestBody SchedulerDto schedulerDto) {
		
		String user_id = schedulerDto.getUser_id();
		String content = schedulerDto.getContent();
		Date schedule_date = schedulerDto.getSchedule_date();
		
		schedulerSaveService.scheduleSave(user_id, schedule_date, content);
		
		
		return ResponseEntity.ok("success");
	}
	
	@GetMapping("/calendar/list")
	private ResponseEntity<List<SchedulerDto>> calendarList() {
	
		List<SchedulerDto> ScheduleList = schedulerListService.schedulerList();
		
		return ResponseEntity.ok(ScheduleList);
	}
	
	
}
