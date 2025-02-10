package com.blogs.service;

import java.util.List;
import com.blogs.dto.NearestAirportLocationsDTO;

public interface NearestAirportLocationService {

    NearestAirportLocationsDTO addNearestAirport(NearestAirportLocationsDTO airportDTO);

    List<NearestAirportLocationsDTO> getAllNearestAirports();

    NearestAirportLocationsDTO getNearestAirportById(Long id);

    NearestAirportLocationsDTO updateNearestAirport(Long id, NearestAirportLocationsDTO airportDTO);

    void deleteNearestAirport(Long id);
}
