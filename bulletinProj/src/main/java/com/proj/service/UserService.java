package com.proj.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.proj.entity.User;

public interface UserService extends UserDetailsService{

	public List<User> getUsers();
	
	public User getUser(String theId);
	
	public void saveUser(User theUser);	
	
	public void deleteUser(String theId);
	
}
