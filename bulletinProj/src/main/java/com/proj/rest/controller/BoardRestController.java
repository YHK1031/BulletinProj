package com.proj.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proj.bindingEntity.BoardArticle;
import com.proj.service.BoardService;

@RestController
@RequestMapping("/api")
public class BoardRestController {

	@Autowired
	@Qualifier("boardServiceImpl")
	private BoardService boardService;
	
	@PostMapping("/article")
	public BoardArticle addBoard(@RequestBody BoardArticle boardArticle) {
		
		boardService.saveBoard(boardArticle);
		
		return boardArticle;
	}
}