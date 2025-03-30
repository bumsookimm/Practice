package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.BoardDto;

@Mapper
public interface IDao {

	public void boardSave(String board_name, String board_title, String board_content);

	public List<BoardDto> boardList();

	public List<BoardDto> boardView(int board_no);
}
