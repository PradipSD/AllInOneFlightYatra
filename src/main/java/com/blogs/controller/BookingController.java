package com.blogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.service.BookingService;

@RestController
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	
}
