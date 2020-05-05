package com.proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.proj.service.UserService;

@Controller
public class LoginController {

	@Autowired
	@Qualifier("userServiceRestClientImpl")
	private UserService userService;
	
	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		
		// return "plain-login";

		return "fancy-login";
		
	}
	
	// add request mapping for /access-denied
	
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		
		return "access-denied";
		
	}
	
}
