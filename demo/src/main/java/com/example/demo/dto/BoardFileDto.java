package com.example.demo.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class BoardFileDto {

	private int file_no;
	private int board_no;
	private String original_name;
	private String save_name;
	private String file_path;
	private long file_size;
	private String file_extension;
	private Date uploaded_date;
}
