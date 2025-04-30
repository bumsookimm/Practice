package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDao;
import com.example.demo.dto.SchedulerDto;

@Service
public class SchedulerIsDoneService {
	
	@Autowired
	private IDao iDao;
	
	
	public Map<String, Object> calenderisDone(int schedule_id) {

		int isDone = iDao.schedulerIsDone(schedule_id );
		
		Map<String, Object> result = new HashMap<>(); 
		
		if(isDone == 1) {
			result.put("message", "할일 완료! 축하드립니다");
		}else if (isDone == 0){
			result.put("message", "할일 -> 해야될일 변경 완료");
		}else {
			result.put("error", "다시 시도해주세요");
		}
		
		SchedulerDto schedulerDto = new SchedulerDto();
		result.put("isdone", schedulerDto.getIsdone());
		System.out.println("ser_isdone: " + schedulerDto.getIsdone());
		
		return result;
	}
}
