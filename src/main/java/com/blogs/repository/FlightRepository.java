package com.blogs.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blogs.pojos.Flight;


@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

	@Query("SELECT f FROM Flight f WHERE f.deptAirport = :deptAirport " +
		       "AND f.arrivalAirport = :arrivalAirport " +
		       "AND f.deptTime BETWEEN :startOfDay AND :endOfDay")
		List<Flight> findFlights(
		    @Param("deptAirport") String deptAirport,
		    @Param("arrivalAirport") String arrivalAirport,
		    @Param("startOfDay") LocalDateTime startOfDay,
		    @Param("endOfDay") LocalDateTime endOfDay
		);
}
