package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDao;
import com.example.demo.dto.SchedulerDto;

@Service
public class SchedulerListService {
	
	@Autowired
	private IDao idao;
	
	public List<SchedulerDto> schedulerList() {
		return idao.schedulerList();
		
	}
}
