package com.example.demo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDao;

@Service
public class SchedulerSaveService {

	@Autowired
	private IDao iDao;	
	
	public void scheduleSave(String user_id, Date schedule_date, String content) {

		  iDao.schedulerSave(user_id, schedule_date, content);
		
		
	}

}
