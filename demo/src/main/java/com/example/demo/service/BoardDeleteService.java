package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDao;

@Service
public class BoardDeleteService {

	@Autowired
	private IDao iDao;
	
	public void boardDelete(int board_no) {
		
		iDao.boardDelete(board_no);
		
	}
	
}
