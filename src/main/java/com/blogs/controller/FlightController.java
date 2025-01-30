package com.blogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.service.FlightService;

@RestController
public class FlightController {

	@Autowired
	private FlightService flightService;
	
	
}
