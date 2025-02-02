package com.blogs.service;

import java.util.List;

import com.blogs.dto.AirlineDTO;

public interface AirlineService {

	AirlineDTO addAirline(AirlineDTO airlineDTO);

	List<AirlineDTO> getAllAirlines();

	AirlineDTO updateAirline(Long id, AirlineDTO airlineDTO);

	void deleteAirline(Long id);

	AirlineDTO getByAirlineName(String airlineName);

}
