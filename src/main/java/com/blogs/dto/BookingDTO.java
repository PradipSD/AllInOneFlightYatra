package com.blogs.dto;

import com.blogs.pojos.Airline;
import com.blogs.pojos.SeatClass;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO {

    private Long bookingId;

    @NotNull(message = "Booking date is required")
    private LocalDateTime bookingDate;

    @NotNull(message = "Seat class is required")
    private SeatClass seatClass;

    @Min(value = 1, message = "At least one seat must be booked")
    private int seatCount;

    @Positive(message = "Amount must be a positive value")
    private double amount;

    private Long userId;
    private Long flightId;
    
    
}