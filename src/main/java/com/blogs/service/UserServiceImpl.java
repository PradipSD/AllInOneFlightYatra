package com.blogs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogs.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserRepository userRepository;
}
