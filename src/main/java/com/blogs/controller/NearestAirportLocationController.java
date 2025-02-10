package com.blogs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blogs.dto.NearestAirportLocationsDTO;
import com.blogs.service.NearestAirportLocationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/nearest-airports")
public class NearestAirportLocationController {

    @Autowired
    private NearestAirportLocationService airportService;

    @PostMapping("/add")
    public NearestAirportLocationsDTO addNearestAirport(@Valid @RequestBody NearestAirportLocationsDTO airportDTO) {
        return airportService.addNearestAirport(airportDTO);
    }


    @GetMapping("/getAll")
    public List<NearestAirportLocationsDTO> getAllNearestAirports() {
        return airportService.getAllNearestAirports();
    }


    @GetMapping("/get/{id}")
    public NearestAirportLocationsDTO getNearestAirportById(@PathVariable Long id) {
        return airportService.getNearestAirportById(id);
    }


    @PutMapping("/update/{id}")
    public NearestAirportLocationsDTO updateNearestAirport(@PathVariable Long id, 
                                                           @Valid @RequestBody NearestAirportLocationsDTO airportDTO) {
        return airportService.updateNearestAirport(id, airportDTO);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteNearestAirport(@PathVariable Long id) {
        airportService.deleteNearestAirport(id);
    }
}
