package com.blogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.service.ReviewService;

@RestController
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	

}
