package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.BoardDeleteService;
import com.example.demo.service.BoardFileDownloadService;
import com.example.demo.service.BoardListService;
import com.example.demo.service.BoardModifyService;
import com.example.demo.service.BoardViewService;
import com.example.demo.service.BoardWriteService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
	
	@Autowired
	private BoardModifyService boardModifyService;
	
	@Autowired
	private BoardFileDownloadService boardFileDownloadService;

	
	@GetMapping("/boardList")
	private String boardList(@RequestParam(defaultValue = "1") int page, Model model) {

		boardListService.boardList(page, model);
		
		return "/boardList";
	}

	@GetMapping("/boardView")
	private String boardView(@RequestParam("id") int board_no, Model model) {

		
		Map<String, Object> result = boardViewService.boardView(board_no);
		
		model.addAttribute("boardDto", result.get("boardDto"));
		model.addAttribute("formattedDate", result.get("formattedDate"));
		model.addAttribute("fileList", result.get("boardFileDto"));
	
		return "/boardView";
	}

	@GetMapping("/boardFileDownload")
	private void boardFileDownload (@RequestParam("fileName") String fileName,
									@RequestParam("originName") String originName,
									@RequestParam("filePath") String filePath,
									HttpServletResponse response) throws Exception {
		System.out.println(fileName + originName);
		boardFileDownloadService.boardFileDownload(fileName, originName, filePath, response);
		
		
	}
	
	
	
	@GetMapping("/boardWriteView")
	private String boardWriteView() {

		return "/boardWriteView";
	}
	
	

	@PostMapping("/boardWriteSave")
	private String boardWrite(@RequestParam("title") String title,
							@RequestParam("name") String name,
							@RequestParam("contents") String contents,
							@RequestParam("files") MultipartFile [] files,
							HttpServletRequest request,
							Model model) {
		
		
		
		
		Map<String, Object> result = boardWriteService.boardSave(title, name, contents);
		model.addAttribute("message", result.get("message"));
		model.addAttribute("messageType", result.get("messageType"));
		
		int board_no = (int) result.get("board_no");
		
		boardWriteService.boardSaveFile(files, request, board_no);

		return "redirect:/boardList";
	}

	@PostMapping("/boardModify")
	private String boardModify(@RequestParam("title") String title,
								@RequestParam("name") String name,
								@RequestParam("contents") String contents,
								@RequestParam("id") int board_no,
								Model model) {

		Map<String, Object> result = boardModifyService.boardUpdate(board_no, title, name, contents);
		model.addAttribute("message", result.get("message"));
		model.addAttribute("messageType", result.get("messageType"));
		
		Map<String, Object> boardResult = boardViewService.boardView(board_no);
	    model.addAttribute("boardDto", boardResult.get("boardDto"));
		
		return "/boardModifyView";
	}

	
	@GetMapping("/boardModifyView")
	private String boardModiftyView(@RequestParam("id") int board_no, Model model) {

		Map<String, Object> result = boardViewService.boardView(board_no);
	   
		
		model.addAttribute("boardDto", result.get("boardDto"));
		 
		return "/boardModifyView";
	}	
	
	
	@GetMapping("/boardDelete")
	private String boardDelete(@RequestParam("id") int board_no) {

		boardDeleteService.boardDelete(board_no);
		
		return "redirect:/boardList";
	}

}
