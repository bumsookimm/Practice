package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.boardListService;
import com.example.demo.service.boardWriteService;

@Controller
public class boardController {

	@Autowired
	private boardWriteService boardWriteService;

	private boardListService boardListService;
	
	@GetMapping("/board")
	private String board() {

		return "/board";
	}

	@GetMapping("/boardList")
	private String boardList() {

		boardListService.boardList();
		
		
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
	private String boardWrite(@RequestParam("title") String title,
							@RequestParam("name") String name,
							@RequestParam("contents") String contents,
							Model model) {
		
		
		try {
			boardWriteService.boardSave(title, name, contents);
			model.addAttribute("message","게시글 작성에 성공했습니다");
			model.addAttribute("messageType","success");
						
		} catch (Exception e) {
			model.addAttribute("message","게시글 작성에 실패했습니다");
			model.addAttribute("messageType","error");
		}
		

		return "/boardWriteView";
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
