package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDao;

@Service
public class SchedulerDeleteService {

	@Autowired
	private IDao iDao;

	public Map<String, Object> SchedulerDelete(int scheduler_id) {

		int isDelete = iDao.schedulerDelete(scheduler_id);

		Map<String, Object> result = new HashMap<>();

		if (isDelete > 0) {
			result.put("message", "삭제가 완료됐습니다");

		} else {
			result.put("message", "삭제가 실패됐습니다");

		}

		return result;

	}
}
