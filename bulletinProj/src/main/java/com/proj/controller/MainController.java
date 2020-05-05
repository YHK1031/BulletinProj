package com.proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.proj.entity.User;
import com.proj.service.UserService;

@Controller
public class MainController {

	@Autowired
	@Qualifier("userServiceRestClientImpl")
	private UserService userService;
	
	@GetMapping("/")
	public String showHome() {
		
		return "home";
	}
	
}
