package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDao;

@Service
public class SignUpService {
	
	@Autowired
	private IDao iDao;
	
	public void signUp(String user_name, String user_password) {
		
		iDao.signUp(user_name, user_password);
		
		
	}
}
