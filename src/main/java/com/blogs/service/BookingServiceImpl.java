package com.blogs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogs.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {

	
	@Autowired
	private BookingRepository bookingRepository;
	
}
