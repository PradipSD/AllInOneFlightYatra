package com.blogs.service;

import java.util.List;
import com.blogs.dto.BookingDTO;

public interface BookingService {

    List<BookingDTO> getAllBookings();

    BookingDTO createBooking(BookingDTO bookingDTO);

    BookingDTO updateBooking(Long bookingId, BookingDTO bookingDTO);

    BookingDTO cancelBookingByEmail(String email);

    BookingDTO getBookingByEmail(String email);


}
