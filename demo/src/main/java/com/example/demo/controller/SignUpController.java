package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {

	@GetMapping("/signUp")
	public String signUpForm() {
		
		
		return "/signUpJsp/signUpForm";
	}
	
	/*
	 * @PostMapping("/signUp") public String signUp() {
	 * 
	 * 
	 * return null; }
	 */
	
}
