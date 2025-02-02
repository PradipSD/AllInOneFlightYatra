package com.blogs.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.blogs.dto.FlightDTO;
import com.blogs.pojos.Flight;

public interface FlightService {

	FlightDTO addFlight(FlightDTO flightDTO);

	List<FlightDTO> getAllFlights();

	

	List<FlightDTO> searchFlight(String deptAirport, String arrivalAirport, LocalDate deptDate);

}
