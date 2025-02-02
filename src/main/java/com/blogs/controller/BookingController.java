package com.blogs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.dto.BookingDTO;
import com.blogs.pojos.BookingFlight;
import com.blogs.service.BookingService;

@RestController
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	@GetMapping("/getAllBookings")
	public List<BookingDTO> getAllBookings(){
		return bookingService.getAllBookings();
	}
}
