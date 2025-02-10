package com.blogs.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogs.dto.BookingDTO;
import com.blogs.pojos.BookingFlight;
import com.blogs.pojos.Flight;
import com.blogs.pojos.User;
import com.blogs.repository.BookingRepository;
import com.blogs.repository.FlightRepository;
import com.blogs.repository.UserRepository;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<BookingDTO> getAllBookings() {
        List<BookingFlight> bookings = bookingRepository.findAll();
        return bookings.stream()
                .map(booking -> new BookingDTO(
                        booking.getBookingId(),
                        booking.getBookingDate(),
                        booking.getSeatClass(),
                        booking.getSeatCount(),
                        booking.getAmount(),
                        booking.getUser().getUserId(),
                        booking.getFlight().getFlightId()))
                .collect(Collectors.toList());
    }

    @Override
    public BookingDTO createBooking(BookingDTO bookingDTO) {
        User user = userRepository.findById(bookingDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Flight flight = flightRepository.findById(bookingDTO.getFlightId())
                .orElseThrow(() -> new RuntimeException("Flight not found"));

        BookingFlight booking = new BookingFlight();
        booking.setBookingDate(LocalDateTime.now());
        booking.setSeatClass(bookingDTO.getSeatClass());
        booking.setSeatCount(bookingDTO.getSeatCount());
        booking.setAmount(bookingDTO.getAmount());
        booking.setUser(user);
        booking.setFlight(flight);

        BookingFlight savedBooking = bookingRepository.save(booking);
        return new BookingDTO(
                savedBooking.getBookingId(),
                savedBooking.getBookingDate(),
                savedBooking.getSeatClass(),
                savedBooking.getSeatCount(),
                savedBooking.getAmount(),
                savedBooking.getUser().getUserId(),
                savedBooking.getFlight().getFlightId());
    }

    @Override
    public BookingDTO updateBooking(Long bookingId, BookingDTO bookingDTO) {
        BookingFlight existingBooking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        existingBooking.setSeatClass(bookingDTO.getSeatClass());
        existingBooking.setSeatCount(bookingDTO.getSeatCount());
        existingBooking.setAmount(bookingDTO.getAmount());

        BookingFlight updatedBooking = bookingRepository.save(existingBooking);
        return new BookingDTO(
                updatedBooking.getBookingId(),
                updatedBooking.getBookingDate(),
                updatedBooking.getSeatClass(),
                updatedBooking.getSeatCount(),
                updatedBooking.getAmount(),
                updatedBooking.getUser().getUserId(),
                updatedBooking.getFlight().getFlightId());
    }

    @Override
    public BookingDTO getBookingByEmail(String email) {
        BookingFlight booking = bookingRepository.findByUserEmail(email)
                .orElseThrow(() -> new RuntimeException("No booking found for email: " + email));

        return new BookingDTO(
                booking.getBookingId(),
                booking.getBookingDate(),
                booking.getSeatClass(),
                booking.getSeatCount(),
                booking.getAmount(),
                booking.getUser().getUserId(),
                booking.getFlight().getFlightId());
    }

    
    @Override
    public BookingDTO cancelBookingByEmail(String email) {
        BookingFlight booking = bookingRepository.findByUserEmail(email)
                .orElseThrow(() -> new RuntimeException("Booking not found for email: " + email));

        bookingRepository.delete(booking);
        
        return new BookingDTO(
                booking.getBookingId(),
                booking.getBookingDate(),
                booking.getSeatClass(),
                booking.getSeatCount(),
                booking.getAmount(),
                booking.getUser().getUserId(),
                booking.getFlight().getFlightId());
    }


 
}
