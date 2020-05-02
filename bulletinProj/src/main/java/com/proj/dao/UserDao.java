package com.proj.dao;

import java.util.List;

import com.proj.entity.User;

public interface UserDao {

	public List<User> getUsers();
	
	public User getUser(String theId);
	
	public void saveUser(User theUser);	
	
	public void deleteUser(String theId);
	
	
}
