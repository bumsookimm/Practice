package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.BoardDto;

@Mapper
public interface IDao {

	public boolean boardSave(String board_name, String board_title, String board_content);

	public List<BoardDto> boardList();

	public BoardDto boardView(int board_no);

	public void boardDelete (int board_no);

	public boolean boardUpdate (int board_no, String board_title, String board_name, String board_content);

	public int boardTotalCount();
	
	public List<BoardDto> boardListPaging (int pageSize, int offset);
}
