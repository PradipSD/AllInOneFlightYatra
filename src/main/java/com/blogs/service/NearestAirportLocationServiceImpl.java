package com.blogs.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogs.dto.NearestAirportLocationsDTO;
import com.blogs.pojos.NearestAirportLocations;
import com.blogs.repository.NearestAirportLocationRepository;

@Service
public class NearestAirportLocationServiceImpl implements NearestAirportLocationService {

    @Autowired
    private NearestAirportLocationRepository airportRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public NearestAirportLocationsDTO addNearestAirport(NearestAirportLocationsDTO airportDTO) {
        NearestAirportLocations airport = modelMapper.map(airportDTO, NearestAirportLocations.class);
        NearestAirportLocations savedAirport = airportRepository.save(airport);
        return modelMapper.map(savedAirport, NearestAirportLocationsDTO.class);
    }

    @Override
    public List<NearestAirportLocationsDTO> getAllNearestAirports() {
        List<NearestAirportLocations> airports = airportRepository.findAll();
        return airports.stream()
                .map(airport -> modelMapper.map(airport, NearestAirportLocationsDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public NearestAirportLocationsDTO getNearestAirportById(Long id) {
        NearestAirportLocations airport = airportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Airport not found with ID: " + id));
        return modelMapper.map(airport, NearestAirportLocationsDTO.class);
    }

    @Override
    public NearestAirportLocationsDTO updateNearestAirport(Long id, NearestAirportLocationsDTO airportDTO) {
        NearestAirportLocations existingAirport = airportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Airport not found with ID: " + id));

        existingAirport.setAirportName(airportDTO.getAirportName());
        existingAirport.setCity(airportDTO.getCity());
        existingAirport.setCountry(airportDTO.getCountry());
        existingAirport.setLongitude(airportDTO.getLongitude());
        existingAirport.setLatitude(airportDTO.getLatitude());

        NearestAirportLocations updatedAirport = airportRepository.save(existingAirport);
        return modelMapper.map(updatedAirport, NearestAirportLocationsDTO.class);
    }

    @Override
    public void deleteNearestAirport(Long id) {
        NearestAirportLocations airport = airportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Airport not found with ID: " + id));
        airportRepository.delete(airport);
    }
}
