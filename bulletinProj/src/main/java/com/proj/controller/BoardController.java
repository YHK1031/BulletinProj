package com.proj.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.proj.bindingEntity.BoardArticle;
import com.proj.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	@Qualifier("boardServiceRestClientImpl")
	private BoardService boardService;
	
	@GetMapping("/newArticle")
	public String newArticle(Model theModel) {
		
		// create model attribute to bind form data
		BoardArticle boardArticle = new BoardArticle();
		
		theModel.addAttribute("boardArticle", boardArticle);
		
		return "article-form";
	}
	
	@PostMapping("/writeArticle")
	public String writeArticle(
			@Valid @ModelAttribute("boardArticle") BoardArticle boardArticle, 
			BindingResult theBindingResult, 
			Model theModel) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
		UserDetails userDetails = (UserDetails)principal; 
		String username = userDetails.getUsername();
		boardArticle.setUserId(username);
		
		if (theBindingResult.hasErrors()){
			theModel.addAttribute("registrationError", "Something wrong with the article");
			return "article-form";
	     }
		
		boardService.saveBoard(boardArticle);
		
		return "home";
	}
	
	
}
