package com.proj.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.proj.bindingEntity.BulletinUser;
import com.proj.entity.User;

@Service
public class UserServiceRestClientImpl implements UserService {
	
	private RestTemplate restTemplate;
	private String restUrl;	
	private Logger logger = Logger.getLogger(getClass().getName());
	

	@Autowired
	public UserServiceRestClientImpl(RestTemplate theRestTemplate, 
										@Value("${rest.url}") String theUrl) {
		restTemplate = theRestTemplate;
		restUrl = theUrl;
				
		logger.info("Loaded property:  rest.url=" + restUrl);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsers() {
		logger.info("in getUsers(): Calling REST API " + restUrl);

		// make REST call
		ResponseEntity<List<User>> responseEntity = 
											restTemplate.exchange(restUrl, HttpMethod.GET, null, 
																  new ParameterizedTypeReference<List<User>>() {});

		// get the list of customers from response
		List<User> customers = responseEntity.getBody();

		logger.info("in getUsers(): customers" + customers);
		
		return customers;
	}

	@Override
	public User getUser(String theId) {
		logger.info("in getUser(): Calling REST API " + restUrl);

		// make REST call
		User theUser = 
				restTemplate.getForObject(restUrl + "/" + theId, 
						User.class);

		logger.info("in getUser(): theUser=" + theUser);
		
		return theUser;
	}

	@Override
	public void saveUser(BulletinUser bulletinUser) {
		logger.info("in saveUser(): Calling REST API " + restUrl);
		
		User tempUser = restTemplate.getForObject(restUrl+"/"+bulletinUser.getId(),User.class);
		
		// make REST call
		if (tempUser == null) {
			// add employee
			restTemplate.postForEntity(restUrl, bulletinUser, String.class);			
		
		} else {
			// update employee
			restTemplate.put(restUrl, bulletinUser);
		}

		logger.info("in saveUser(): success");	

	}

	@Override
	public void deleteUser(String theId) {
		logger.info("in deleteUser(): Calling REST API " + restUrl);

		// make REST call
		restTemplate.delete(restUrl + "/" + theId);

		logger.info("in deleteUser(): deleted customer theId=" + theId);

	}

}
