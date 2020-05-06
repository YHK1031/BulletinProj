package com.proj.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.proj.entity.User;
import com.proj.user.BulletinUser;

public interface UserService extends UserDetailsService{

	public List<User> getUsers();
	
	public User getUser(String theId);
	
	public void saveUser(BulletinUser theUser);	
	
	public void deleteUser(String theId);
	
}
