package com.proj.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.proj.bindingEntity.BoardArticle;
import com.proj.service.BoardService;

@Controller
public class BoardController {

	@Autowired
//	@Qualifier("userServiceRestClientImpl")
	private BoardService boardService;
	
	@GetMapping("/newArticle")
	public String newArticle(
			@Valid @ModelAttribute("boardArticle") BoardArticle boardArticle, 
			BindingResult theBindingResult, 
			Model theModel) {
		
		if (theBindingResult.hasErrors()){
			theModel.addAttribute("registrationError", "Something wrong with the article");
			return "article-form";
	     }
		
		boardService.saveBoard(boardArticle);
		
		return "article-form";
	}
	
	
}
