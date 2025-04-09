package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDao;

@Service
public class BoardWriteService {
	
	@Autowired
	private IDao iDao;
	
	
	public Map<String, Object> boardSave(String title, String name, String contents) {
		
	boolean isSave = iDao.boardSave(name, title, contents);
	Map<String, Object> result = new HashMap<>();
	
	if (isSave) {
		result.put("message","게시글 작성에 성공했습니다");
		result.put("messageType","success");		
	} else {
		result.put("message","게시글 작성에 실패했습니다");
		result.put("messageType","error");	
	}
		
	
	return result;
	
	}

	
}
