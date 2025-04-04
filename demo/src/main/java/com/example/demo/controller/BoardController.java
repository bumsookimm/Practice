package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.BoardDto;
import com.example.demo.service.BoardDeleteService;
import com.example.demo.service.BoardListService;
import com.example.demo.service.BoardViewService;
import com.example.demo.service.BoardWriteService;

@Controller
public class BoardController {

	@Autowired
	private BoardWriteService boardWriteService;
	
	@Autowired
	private BoardListService boardListService;
	
	@Autowired
	private BoardViewService boardViewService;
	
	@Autowired
	private BoardDeleteService boardDeleteService;
	
	@GetMapping("/board")
	private String board() {

		return "/board";
	}

	@GetMapping("/boardList")
	private String boardList(Model model) {

		List<BoardDto> boardDto = boardListService.boardList();
		
		model.addAttribute("boardDto",boardDto);
		
		return "/boardList";
	}

	@GetMapping("/boardView")
	private String boardView(@RequestParam("id") int board_no, Model model) {

		
		BoardDto boardDto = boardViewService.boardView(board_no);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = sdf.format(boardDto.getBoard_created());
	   
		model.addAttribute("formattedDate",formattedDate);
		model.addAttribute("boardDto", boardDto);
		 
		return "/boardView";
	}

	@GetMapping("/boardWriteView")
	private String boardWriteView() {

		return "/boardWriteView";
	}
	
	

	@PostMapping("/boardWriteSave")
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

	@GetMapping("/boardDelete")
	private String boardDelete(@RequestParam("id") int board_no) {

		System.out.println("board_no" + board_no);
		boardDeleteService.boardDelete(board_no);
		
		return "redirect:/boardList";
	}

}
