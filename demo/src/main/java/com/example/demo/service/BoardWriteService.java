package com.example.demo.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.IDao;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class BoardWriteService {
	
	@Autowired
	private IDao iDao;
	
	
	public Map<String, Object> boardSave(String title, String name, String contents) {
	
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("board_title", title);
		paramMap.put("board_name", name);
		paramMap.put("board_content", contents);
		
		
		
	boolean isSave = iDao.boardSave(paramMap);
	
	
	
	Map<String, Object> result = new HashMap<>();
	if (isSave ) {
		Number boardNum = (Number) paramMap.get("board_no");
		int board_no = boardNum.intValue();
		result.put("board_no", board_no);
		result.put("message","게시글 작성에 성공했습니다");
		result.put("messageType","success");		
	} else {
		result.put("message","게시글 작성에 실패했습니다");
		result.put("messageType","error");	
	}
		
	
	return result;
	
	}

	
	public void boardSaveFile (MultipartFile [] files, HttpServletRequest request, long board_no) {
	
		String uploadPath = request.getServletContext().getRealPath("/upload/").replace("\\", "/");

		
		if(files != null && files.length > 0) {
			for(MultipartFile file : files) {
				if(!file.isEmpty()) {
					String original = file.getOriginalFilename();
					String uuid = UUID.randomUUID().toString();
					String saved = uuid + "_"+ original;
					String extension = original.substring(original.lastIndexOf(".") +1);
					long fileSize = file.getSize();
					
					try {
						file.transferTo(new java.io.File(uploadPath + saved));
					} catch (IllegalStateException | IOException e) {
						
						e.printStackTrace();
					}
					
					iDao.boardSaveFile(board_no, original, saved, uploadPath, fileSize, extension);
				
				}
			}
		}
	}
	
}
