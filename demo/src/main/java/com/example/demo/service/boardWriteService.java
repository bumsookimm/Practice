package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDao;

@Service
public class boardWriteService {

	@Autowired
	private IDao iDao;

	public void boardSave(String board_title, String board_content, String board_name) {

		iDao.saveBoard(board_title, board_content, board_name);

	}

}
