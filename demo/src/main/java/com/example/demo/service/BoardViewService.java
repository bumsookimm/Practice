package com.example.demo.service;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDao;
import com.example.demo.dto.BoardDto;
import com.example.demo.dto.BoardFileDto;

@Service
public class BoardViewService {

	@Autowired
	private IDao iDao;

	public Map<String, Object> boardView(int board_no) {

		BoardDto boardDto = iDao.boardView(board_no);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String formattedDate;

		if (boardDto.getUpdated_at() != null) {
			formattedDate = sdf.format(boardDto.getUpdated_at());

		} else {

			formattedDate = sdf.format(boardDto.getBoard_created());
		
		}
		System.out.println("board_no" +board_no);
		List<BoardFileDto> boardFileDto = iDao.boardFileView(board_no);
		System.out.println("boardFileDto"+ boardFileDto);
		
		Map<String, Object> result = new HashMap<>();
		result.put("boardDto", boardDto);
		result.put("formattedDate", formattedDate);
		result.put("boardFileDto", boardFileDto);
		
		return result;

	}

}
