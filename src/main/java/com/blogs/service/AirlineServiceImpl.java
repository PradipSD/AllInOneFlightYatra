package com.blogs.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogs.dto.AirlineDTO;
import com.blogs.pojos.Airline;
import com.blogs.repository.AirlineRepository;

@Service
public class AirlineServiceImpl implements AirlineService {

	
	@Autowired
	private AirlineRepository airlineRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public AirlineDTO addAirline(AirlineDTO airlineDTO) {
//		Airline airline = new Airline();
//		airline.setAirlineName(airlineDTO.getAirlineName());
//		airline.setContactNumber(airlineDTO.getContactNumber());
//		airline.setCountryOfOrigin(airlineDTO.getCountryOfOrigin());
//		airline.setEmail(airlineDTO.getEmail());
//		airline.setWebsite(airlineDTO.getWebsite());
		
		Airline airline=modelMapper.map(airlineDTO, Airline.class);
		Airline savedairline=airlineRepository.save(airline);
		return modelMapper.map(savedairline, AirlineDTO.class);
		
	}
	
	
	
	@Override
	public AirlineDTO getByAirlineName(String airlineName){

		Airline airline = airlineRepository.findByAirlineName(airlineName);
		
		return modelMapper.map(airline, AirlineDTO.class);
		
	}
	
	@Override
	public List<AirlineDTO> getAllAirlines(){
		
		List<Airline> airlines = airlineRepository.findAll();
		
		return airlines.stream().map(airline->new AirlineDTO(airline.getAirlineId(), airline.getAirlineName(), airline.getCountryOfOrigin(), airline.getContactNumber(), airline.getEmail(), airline.getWebsite()))
				.collect(Collectors.toList());
	}
	
	@Override
	public AirlineDTO updateAirline(Long id,AirlineDTO airlineDTO) {

		Airline airline=airlineRepository.findById(id).orElseThrow();
//		return modelMapper.map(airline, AirlineDTO.class);
		
//		airline.setAirlineId(airlineDTO.getAirlineId());
		// Update only non-null fields
	    if (airlineDTO.getAirlineName() != null) {
	        airline.setAirlineName(airlineDTO.getAirlineName());
	    }
	    if (airlineDTO.getContactNumber() != null) {
	        airline.setContactNumber(airlineDTO.getContactNumber());
	    }
	    if (airlineDTO.getCountryOfOrigin() != null) {
	        airline.setCountryOfOrigin(airlineDTO.getCountryOfOrigin());
	    }
	    if (airlineDTO.getEmail() != null) {
	        airline.setEmail(airlineDTO.getEmail());
	    }
	    if (airlineDTO.getWebsite() != null) {
	        airline.setWebsite(airlineDTO.getWebsite());
	    }
		Airline updatedairline = airlineRepository.save(airline);
		return modelMapper.map(updatedairline, AirlineDTO.class);
		
		
		
	}
	
	
	@Override
	public void deleteAirline(Long id) {
		Airline airline = airlineRepository.findById(id).orElseThrow();
		 airlineRepository.delete(airline);
	}
	
	
	
	
}
