package com.blogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogs.pojos.Airline;

public interface AirlineRepository extends JpaRepository<Airline, Long> {
	Airline findByAirlineName(String airlineName);
}
