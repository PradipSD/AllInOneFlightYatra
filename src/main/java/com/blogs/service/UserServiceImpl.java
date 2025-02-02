package com.blogs.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogs.dto.UserDTO;
import com.blogs.pojos.User;
import com.blogs.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	

	
	
	
	@Override
	public List<UserDTO>  getAllUsers(){
		List<User> users =  userRepository.findAll();
		return users.stream()
				.map(user->new UserDTO(user.getUserId(),user.getFname(),user.getLname(),user.getPhoneNo()
						,user.getEmail(),user.getPassword(),user.getRole()))
				.collect(Collectors.toList());
		
	}
}
