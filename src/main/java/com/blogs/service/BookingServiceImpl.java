package com.blogs.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogs.dto.BookingDTO;
import com.blogs.pojos.BookingFlight;
import com.blogs.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {

	
	@Autowired
	private BookingRepository bookingRepository;
	

	
	
	@Override
	public List<BookingDTO>  getAllBookings(){
		List<BookingFlight> bookings =  bookingRepository.findAll();
		
		return bookings.stream()
				.map(booking->new BookingDTO(booking.getBookingId(), booking.getBookingDate(),booking.getSeatClass(), booking.getSeatCount(), booking.getAmount(), booking.getUser().getUserId(), booking.getFlight().getFlightId()))
				.collect(Collectors.toList());
	}
	
}
