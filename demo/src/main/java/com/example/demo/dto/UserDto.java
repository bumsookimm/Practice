package com.example.demo.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDto {

	private int  user_no ;
	private String user_name ;
	private String user_password ;
	private Date user_created ;

}
