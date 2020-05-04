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

import com.proj.entity.User;
import com.proj.rest.exception.UserNotFoundException;
import com.proj.service.UserService;

@RestController
@RequestMapping("/api")
public class UserRestController {

	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
	@GetMapping("/users/{userId}")
	public User getCustomer(@PathVariable String userId) {

		User theUser = userService.getUser(userId);

		if (theUser == null) {
			throw new UserNotFoundException("User id not found - " + userId);
		}
		theUser.getRole().setUsers(null);
		return theUser;
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
