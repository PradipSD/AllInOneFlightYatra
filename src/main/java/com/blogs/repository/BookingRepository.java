package com.blogs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogs.pojos.BookingFlight;

@Repository
public interface BookingRepository extends JpaRepository<BookingFlight, Long> {

    Optional<BookingFlight> findByUserEmail(String email);

}
