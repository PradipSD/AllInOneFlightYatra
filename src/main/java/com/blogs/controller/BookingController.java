package com.blogs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blogs.dto.BookingDTO;
import com.blogs.service.BookingService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

 
    @GetMapping("/getAll")
    public List<BookingDTO> getAllBookings() {
        return bookingService.getAllBookings();
    }

 
    @PostMapping("/create")
    public BookingDTO createBooking(@Valid @RequestBody BookingDTO bookingDTO) {
        return bookingService.createBooking(bookingDTO);
    }


    @PutMapping("/update/{id}")
    public BookingDTO updateBooking(@PathVariable Long id, @Valid @RequestBody BookingDTO bookingDTO) {
        return bookingService.updateBooking(id, bookingDTO);
    }


    @GetMapping("/getByEmail")
    public BookingDTO getBookingByEmail(@RequestParam String email) {
        return bookingService.getBookingByEmail(email);
    }

  
    @DeleteMapping("/cancelByEmail")
    public BookingDTO cancelBookingByEmail(@RequestParam String email) {
        return bookingService.cancelBookingByEmail(email);
    }

 
   
}
