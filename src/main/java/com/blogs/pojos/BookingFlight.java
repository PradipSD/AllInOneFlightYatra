package com.blogs.pojos;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bookings")
public class BookingFlight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @NotNull(message = "Booking date is required")
    private LocalDateTime bookingDate;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Seat class is required")
    private SeatClass seatClass;

    @Min(value = 1, message = "At least one seat must be booked")
    private int seatCount;

    @Positive(message = "Amount must be a positive value")
    private double amount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL,orphanRemoval = true)
    private Payment payment;
}