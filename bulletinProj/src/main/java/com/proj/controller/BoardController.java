package com.proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.proj.service.UserService;

@Controller
public class BoardController {

	@Autowired
	@Qualifier("userServiceRestClientImpl")
	private UserService userService;
	
	@GetMapping("/newArticle")
	public String newArticle() {
		
		return "article-form";
	}
	
	
}
