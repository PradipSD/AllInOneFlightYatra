package com.blogs.service;

import com.blogs.dto.PaymentDTO;
import com.blogs.pojos.BookingFlight;
import com.blogs.pojos.Payment;
import com.blogs.pojos.PaymentStatus;
import com.blogs.repository.BookingRepository;
import com.blogs.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public PaymentDTO makePayment(Long bookingId, PaymentDTO paymentDTO) {
        BookingFlight booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        Payment payment = new Payment();
        payment.setBooking(booking);
        payment.setPaymentMethod(paymentDTO.getPaymentMethod());
        payment.setAmount(paymentDTO.getAmount());
        payment.setPaymentStatus(PaymentStatus.COMPLETED); 
        payment.setPaymentDate(LocalDateTime.now());

        // Save payment details
        Payment savedPayment = paymentRepository.save(payment);

        // Return DTO
        return new PaymentDTO(
                savedPayment.getPaymentId(),
                savedPayment.getPaymentDate(),
                savedPayment.getPaymentMethod(),
                savedPayment.getPaymentStatus(),
                savedPayment.getAmount(),
                savedPayment.getBooking().getBookingId());
    }

    @Override
    public PaymentDTO getPaymentDetails(Long bookingId) {
        Payment payment = paymentRepository.findByBooking_BookingId(bookingId)
                .orElseThrow(() -> new RuntimeException("No payment found for this booking"));

        return new PaymentDTO(
                payment.getPaymentId(),
                payment.getPaymentDate(),
                payment.getPaymentMethod(),
                payment.getPaymentStatus(),
                payment.getAmount(),
                payment.getBooking().getBookingId());
    }
    
    @Override
    public List<PaymentDTO> getPaymentDetailsByEmail(String email) {
        List<Payment> payments = paymentRepository.findByBooking_User_Email(email);
        if (payments.isEmpty()) {
            throw new RuntimeException("No payments found for the given email.");
        }
        return payments.stream()
                .map(payment -> new PaymentDTO(
                        payment.getPaymentId(),
                        payment.getPaymentDate(),
                        payment.getPaymentMethod(),
                        payment.getPaymentStatus(),
                        payment.getAmount(),
                        payment.getBooking().getBookingId()))
                .collect(Collectors.toList());
    }


    @Override
    public void cancelPayment(Long bookingId) {
        Payment payment = paymentRepository.findByBooking_BookingId(bookingId)
                .orElseThrow(() -> new RuntimeException("Payment not found for this booking"));

        payment.setPaymentStatus(PaymentStatus.CANCELLED);
        paymentRepository.save(payment);
    }
}
