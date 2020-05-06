package com.proj.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proj.dao.RoleDao;
import com.proj.dao.UserDao;
import com.proj.entity.User;
import com.proj.user.BulletinUser;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	

	@Override
	@Transactional
	public List<User> getUsers() {
		return userDao.getUsers();
	}

	@Override
	@Transactional
	public User getUser(String theId) {
		return userDao.getUser(theId);
	}

	@Override
	@Transactional
	public void saveUser(BulletinUser bulletinUser) {
		User theUser = new User();
		theUser.setId(bulletinUser.getId());
		theUser.setPw(passwordEncoder.encode(bulletinUser.getPw()));
		theUser.setFirstName(bulletinUser.getFirstName());
		theUser.setLastName(bulletinUser.getLastName());
		theUser.setEmail(bulletinUser.getEmail());
		theUser.setValidity(1);
		theUser.setRole(roleDao.findRoleByName("ROLE_USER"));
		System.out.println("At User Service : "+theUser.toString());
		userDao.saveUser(theUser);
	}

	@Override
	@Transactional
	public void deleteUser(String theId) {
		userDao.deleteUser(theId);
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User tempUser = userDao.getUser(username);
		if(tempUser==null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(tempUser.getRole().getRole_id()));
		return new org.springframework.security.core.userdetails.User(tempUser.getId(), tempUser.getPw(),
				authorities);
	}
	
}
