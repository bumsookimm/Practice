package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDao;

@Service
public class SchedulerUpdateService {

	@Autowired
	private IDao iDao;

	public Map<String, Object> SchedulerUpdate(int schedule_id, String content) {

		int isUpdate = (int) iDao.schedulerUpdate(schedule_id, content);
		
		
		Map<String, Object> result = new HashMap<>();
		
		if(isUpdate > 0) {
			result.put("message","수정완료");
			
		}else {
			result.put("message","수정실패");
		}
		
		
		return result; 
	}
}
