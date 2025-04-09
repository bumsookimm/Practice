package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDao;

@Service
public class BoardModifyService {

	@Autowired
	private IDao iDao;

	public void boardUpdate(int board_no, String title, String name, String contents) {

		iDao.boardUpdate(board_no, title, name, contents);

	}

}
