package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.SignUpService;

@Controller
public class SignUpController {

	@Autowired
	private SignUpService signUpService;
	
	
	
	@PostMapping("/signUp")
	public void signUpForm(@RequestParam("username") String user_name,
							@RequestParam("password") String user_password) {
		
		signUpService.signUp(user_name, user_password);
		

	}

	
}
