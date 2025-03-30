package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDao;
import com.example.demo.dto.BoardDto;

@Service
public class BoardViewService {
	
	@Autowired
	private IDao iDao;
	
	
	public List<BoardDto> boardList(int board_no) {
		
		return iDao.boardView(board_no);
		
	}
		
}
