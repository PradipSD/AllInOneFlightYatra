package com.blogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.service.UserService;

@RestController
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	
	

}
