package com.blogs.dto;

import com.blogs.pojos.FlightStatus;

import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightDTO {

    private Long flightId;

    private String airlineName;

    private String deptAirport;

    private String arrivalAirport;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime deptTime;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime arrivalTime;

    @Min(value = 1, message = "Available seats must be at least 1")
    private int availableSeats;

    @Positive(message = "Price must be a positive value")
    private double price;

    @NotNull(message = "FlightStatus is required")
    private FlightStatus flightStatus;

    @NotNull(message = "airlineId is required")
    private Long airlineId;
//    private List<BookingDTO> bookings;
}
