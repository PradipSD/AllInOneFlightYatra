package com.blogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.blogs.pojos.NearestAirportLocations;

public interface NearestAirportLocationRepository extends JpaRepository<NearestAirportLocations, Long> {
}
