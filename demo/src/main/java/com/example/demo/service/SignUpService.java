package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDao;
import com.example.demo.dto.UserDto;

@Service
public class SignUpService {
	
	@Autowired
	private IDao iDao;
	
	public void signUp(UserDto userDto) {
		
		String user_name = userDto.getUser_name();
		String user_password = userDto.getUser_password();
		String user_gender = userDto.getUser_gender();
		String user_email = userDto.getUser_email();
		int user_age = userDto.getUser_age();
		
		iDao.signUp(user_name, user_password, user_gender, user_email, user_age);
		
		
	}
}
