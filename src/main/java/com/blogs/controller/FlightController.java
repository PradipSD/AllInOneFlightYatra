package com.blogs.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.dto.FlightDTO;
import com.blogs.pojos.Flight;
import com.blogs.service.FlightService;

@RestController
public class FlightController {

	@Autowired
	private FlightService flightService;
	
	@PostMapping("/addFlight")
	public FlightDTO addFlight(FlightDTO flightDTO) {
		return flightService.addFlight(flightDTO);
	}

	@GetMapping("/getAllFlights")
	public List<FlightDTO> getAllFlights(){
		return flightService.getAllFlights();
	}

	 @GetMapping("/search")
	    public List<FlightDTO> searchFlights(  @RequestParam String deptAirport,
	    	    @RequestParam String arrivalAirport,
	    	    @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate deptDate) {
	        return flightService.searchFlight(deptAirport, arrivalAirport, deptDate);
	    }
	
}
