package com.blogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogs.pojos.Flight;


@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

}
