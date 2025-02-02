package com.blogs.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogs.dto.FlightDTO;
import com.blogs.pojos.Flight;
import com.blogs.repository.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public FlightDTO addFlight(FlightDTO flightDTO) {
		Flight flight  = modelMapper.map(flightDTO, Flight.class);
		Flight savedflight = flightRepository.save(flight);
		return modelMapper.map(savedflight, FlightDTO.class);
	}
	
	@Override
	public List<FlightDTO> getAllFlights(){
		List<Flight> flights = flightRepository.findAll();
		return flights.stream().map(flight->new FlightDTO(
				flight.getFlightId(), 
				flight.getAirlineName(), 
				flight.getDeptAirport(), 
				flight.getArrivalAirport(), 
				flight.getDeptTime(), 
				flight.getArrivalTime(), 
				flight.getAvailableSeats(), 
				flight.getPrice(), 
				flight.getFlightstatus(), flight.getAirline().getAirlineId())).collect(Collectors.toList());
	}
	
	@Override
	public List<FlightDTO> searchFlight(String deptAirport, String arrivalAirport, LocalDate deptDate) {
	    LocalDateTime startOfDay = deptDate.atStartOfDay();      // 2025-02-02 00:00:00
	    LocalDateTime endOfDay = deptDate.atTime(LocalTime.MAX); // 2025-02-02 23:59:59

		List<Flight> flights =   flightRepository.findFlights(deptAirport, arrivalAirport, startOfDay, endOfDay);
				
				return flights.stream().map(flight->new FlightDTO(
						flight.getFlightId(), 
						flight.getAirlineName(), 
						flight.getDeptAirport(), 
						flight.getArrivalAirport(), 
						flight.getDeptTime(), 
						flight.getArrivalTime(), 
						flight.getAvailableSeats(), 
						flight.getPrice(), 
						flight.getFlightstatus(),
						flight.getAirline().getAirlineId())).collect(Collectors.toList());
	}
	
	
	
	
}
