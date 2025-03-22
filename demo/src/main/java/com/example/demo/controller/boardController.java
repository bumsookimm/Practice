package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class boardController {

	@GetMapping("/board")
	private String board() {

		return "/board";
	}

	@GetMapping("/boardList")
	private String boardList() {

		return "/boardList";
	}

	@GetMapping("/boardView")
	private String boardView() {

		return "/boardView";
	}

	@PostMapping("/boardWrite")
	private String boardWrite() {

		return "/boardWrite";
	}

	@PostMapping("/boardModifty")
	private String boardModifty() {

		return "/boardModifty";
	}

	@DeleteMapping("/boardDelete")
	private String boardDelete() {

		return "/boardDelete";
	}

}
