package com.example.demo.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.BoardDto;
import com.example.demo.dto.BoardFileDto;
import com.example.demo.dto.SchedulerDto;

@Mapper
public interface IDao {

	/*---------------------게시판---------------*/	
	
	public boolean boardSave(Map<String, Object> paramMap);
	
	public void boardSaveFile(long boardNo, String originalName, String saveName,
			String filePath, long fileSize, String fileExtension);
	
	public BoardDto boardView(int board_no);

	public void boardDelete (int board_no);

	public boolean boardUpdate (int board_no, String board_title, String board_name, String board_content);

	public int boardTotalCount();
	
	public List<BoardDto> boardListPaging (int pageSize, int offset);

	public List<BoardFileDto> boardFileView (int board_no);
	
	
	/*---------------------일정표---------------*/	

	public int schedulerSave(String user_id, Date schedule_date, String content);
	
	public List<SchedulerDto> schedulerList ();

	public int schedulerUpdate(int schedule_id, String content);

	public int schedulerDelete(int schedule_id);

	public int schedulerIsDone(int schedule_id);
	
	
	/*---------------------회원가입---------------*/	
	
	public void signUp(String user_name, String user_password);
	
	
}
