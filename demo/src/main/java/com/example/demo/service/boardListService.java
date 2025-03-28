package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDao;

@Service
public class boardListService {
	
	@Autowired
	private IDao iDao;
	
	
	public void boardList() {
		
		iDao.boardList();
		
	}
		
}
