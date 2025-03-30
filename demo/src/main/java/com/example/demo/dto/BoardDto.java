package com.example.demo.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BoardDto {

	int board_no;
	String board_name;
	String board_title;
	String board_content;
	Date board_created;

}
