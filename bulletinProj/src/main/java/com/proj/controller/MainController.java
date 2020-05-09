package com.proj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.proj.entity.Board;
import com.proj.service.BoardService;

@Controller
public class MainController {

	@Autowired
	@Qualifier("boardServiceRestClientImpl")
	private BoardService boardService;
	
	@GetMapping("/")
	public String showHome(Model theModel) {
		
		List<Board> boards = boardService.getBoards();
		
		theModel.addAttribute("boards", boards);
		
		return "home";
	}
	
}
