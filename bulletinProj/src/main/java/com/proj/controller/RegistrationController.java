package com.proj.controller;

import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proj.entity.User;
import com.proj.service.UserService;
import com.proj.user.BulletinUser;

@Controller
@RequestMapping("/register")
public class RegistrationController {

	@Autowired
	@Qualifier("userServiceRestClientImpl")
	private UserService userService;

	private Logger logger = Logger.getLogger(getClass().getName());

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		BulletinUser theUser = new BulletinUser();
		
		theModel.addAttribute("user", theUser);
		
		return "user-form";
	}
	
	
	@PostMapping("/processRegistrationForm")
	public String processRegistrationForm(
				@Valid @ModelAttribute("user") BulletinUser theBulletinUser, 
				BindingResult theBindingResult, 
				Model theModel) {
		
		String userId = theBulletinUser.getId();
		logger.info("Processing registration form for: " + userId);
		
		// form validation
		 if (theBindingResult.hasErrors()){
			 return "user-form";
	     }

		// check the database if user already exists
        User existing = userService.getUser(userId);
        System.out.println("ProcessRegistrationForm");
        if (existing != null){
        	theModel.addAttribute("user", new BulletinUser());
			theModel.addAttribute("registrationError", "User name already exists.");
			
			logger.warning("User name already exists.");
        	return "user-form";
        }
     // create user account        						
        userService.saveUser(theBulletinUser);
        logger.info("Successfully created user: " + userId);
        
        return "registration-confirmation";		
	}
	
}
