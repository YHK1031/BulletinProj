package com.proj.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proj.entity.User;
import com.proj.rest.exception.UserNotFoundException;
import com.proj.service.UserService;

@RestController
@RequestMapping("/api")
public class UserRestController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
	@PostMapping("/users")
	public User addUser(@RequestBody User theUser) {
		User tempUser = userService.getUser(theUser.getId());
		System.out.println(theUser.getId());
		if(tempUser!=null) {
			throw new UserNotFoundException();
		}
		userService.saveUser(theUser);
		theUser.setRole(null);
		return theUser;
	}
}
