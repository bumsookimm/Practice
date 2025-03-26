package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IDao {

	public void saveBoard (String board_title, String board_content, String board_name);

}
