package com.blogs.pojos;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flightId;

    @NotBlank(message = "Airline name is required")
    private String airlineName;

    @NotBlank(message = "Departure airport is required")
    private String deptAirport;

    @NotBlank(message = "Arrival airport is required")
    private String arrivalAirport;

    @NotNull(message = "Departure time is required")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime deptTime;

    @NotNull(message = "Arrival time is required")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime arrivalTime;

    @Min(value = 1, message = "Available seats must be at least 1")
    private int availableSeats;

    @Positive(message = "Price must be a positive value")
    private double price;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "FlightStatus is required")
    private FlightStatus flightstatus;  

    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<BookingFlight> bookings;

    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Review> reviews;

    @ManyToOne
    @JoinColumn(name = "airline_id")
    private Airline airline;
}