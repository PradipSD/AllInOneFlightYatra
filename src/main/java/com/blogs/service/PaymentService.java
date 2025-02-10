package com.blogs.service;

import java.util.List;

import com.blogs.dto.PaymentDTO;

public interface PaymentService {
    PaymentDTO makePayment(Long bookingId, PaymentDTO paymentDTO);
    PaymentDTO getPaymentDetails(Long bookingId);
    void cancelPayment(Long bookingId);
    
    List<PaymentDTO> getPaymentDetailsByEmail(String email);

}
