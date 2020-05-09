package com.proj.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proj.bindingEntity.BoardArticle;
import com.proj.entity.Board;
import com.proj.entity.User;
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
	
	@GetMapping("/article")
	public List<Board> getBoards(){
		return boardService.getBoards();
	}
	
	@GetMapping("/article/{boardIdx}")
	public Board getBoard(@PathVariable Long boardIdx) {
		
		Board theBoard = boardService.getBoard(boardIdx);

		return theBoard;
	}
}
