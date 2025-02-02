package com.blogs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.dto.UserDTO;
import com.blogs.pojos.User;
import com.blogs.service.UserService;

@RestController
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	
	
	@GetMapping("/getAllUsers")
	public List<UserDTO> getAllUsers(){
		return userService.getAllUsers();
	}
	

}
