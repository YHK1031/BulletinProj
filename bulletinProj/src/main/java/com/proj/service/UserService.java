package com.proj.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.proj.bindingEntity.BulletinUser;
import com.proj.entity.User;

public interface UserService extends UserDetailsService{

	public List<User> getUsers();
	
	public User getUser(String theId);
	
	public void saveUser(BulletinUser theUser);	
	
	public void deleteUser(String theId);
	
}
