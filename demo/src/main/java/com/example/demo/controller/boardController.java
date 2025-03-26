package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.boardWriteService;

@Controller
public class boardController {

	@Autowired
	private boardWriteService boardWriteService;

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

	@GetMapping("/boardWriteView")
	private String boardWriteView() {

		return "/boardWriteView";
	}

	@PostMapping("/boardWrite")
	private String boardWrite(@RequestParam("title") String board_title, @RequestParam("name") String board_name,
			@RequestParam("content") String board_content) {

		boardWriteService.boardSave(board_title, board_content, board_name);

		return "redirect:/boardWriteView";
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
