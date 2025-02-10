package com.blogs.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogs.pojos.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
	 Optional<Payment> findByBooking_BookingId(Long bookingId);
	 
	 List<Payment> findByBooking_User_Email(String email);
}
