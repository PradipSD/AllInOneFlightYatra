package com.blogs.service;

import java.util.List;

import com.blogs.dto.BookingDTO;
import com.blogs.pojos.BookingFlight;

public interface BookingService {

	List<BookingDTO> getAllBookings();

}
