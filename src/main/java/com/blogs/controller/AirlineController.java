package com.blogs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.dto.AirlineDTO;
import com.blogs.service.AirlineService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/airlines")
public class AirlineController {


	@Autowired
	private AirlineService airlineService;
	
	
	@PostMapping("/addAirline")
	public  AirlineDTO addAirline(@Valid @RequestBody AirlineDTO airlineDTO) {
		return airlineService.addAirline(airlineDTO);
	}
	
	@GetMapping("/getAllAirlines")
	public List<AirlineDTO> getAllAirlines(){
		return airlineService.getAllAirlines();
	}
	
	
	@PostMapping("/updateAirline/{id}")
	public AirlineDTO updateAirline(@PathVariable Long id, @Valid @RequestBody AirlineDTO airlineDTO) {
		return airlineService.updateAirline(id, airlineDTO);
	}

	@PostMapping("/deleteAirline/{id}")
	public void deleteAirline(@PathVariable Long id) {
		 airlineService.deleteAirline(id);
	}
	
	
	@GetMapping("/getByAirlineName/{airlineName}")
	public AirlineDTO getByAirlineName(@PathVariable String airlineName) {
		return airlineService.getByAirlineName(airlineName);
	}
	
}
