package com.blogs.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.blogs.dto.FlightDTO;
import com.blogs.pojos.Flight;
import com.blogs.service.FlightService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:3000") 
@RestController
@RequestMapping("/api/flights")
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
	
	  @PutMapping("/updateFlight/{id}")
	    public FlightDTO updateFlight(@PathVariable Long id, @Valid @RequestBody FlightDTO flightDTO) {
	        return flightService.updateFlight(id, flightDTO);
	    }


	    @DeleteMapping("/deleteFlight/{id}")
	    public void deleteFlight(@PathVariable Long id) {
	        flightService.deleteFlight(id);
	    }
}
