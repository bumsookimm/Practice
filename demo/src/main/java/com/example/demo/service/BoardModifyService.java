package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDao;

@Service
public class BoardModifyService {

	@Autowired
	private IDao iDao;

	public Map<String, Object> boardUpdate(int board_no, String title, String name, String contents) {

		boolean isUpdate = iDao.boardUpdate(board_no, title, name, contents);

		Map<String, Object> result = new HashMap<>();
		
		if(isUpdate) {
			result.put("message", "수정 완료");
			result.put("messageType", "success");
			
		}else {
			result.put("message", "수정 실패");
			result.put("messageType", "error");
			
		}
		
		return result;
	}

}
