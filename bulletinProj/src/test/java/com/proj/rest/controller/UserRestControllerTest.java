package com.proj.rest.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.proj.config.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(classes = AppConfig.class)
public class UserRestControllerTest {

	@Autowired
	UserRestController userRestController;
	
    private MockMvc mockMvc;
	
    @Before
    public void setUp() throws Exception{
    	mockMvc = MockMvcBuilders.standaloneSetup(userRestController).build();
    }
    
	@Test
	public void getUserTest() {
		
	}
}
