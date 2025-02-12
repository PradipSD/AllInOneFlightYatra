package com.blogs.controller;

import com.blogs.dto.PaymentDTO;
import com.blogs.service.PaymentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:3000") 
@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;


    @PostMapping("/makePayment/{bookingId}")
    public PaymentDTO makePayment(@PathVariable Long bookingId, @RequestBody PaymentDTO paymentDTO) {
        return paymentService.makePayment(bookingId, paymentDTO);
    }


    @GetMapping("/getPaymentDetails/{bookingId}")
    public PaymentDTO getPaymentDetails(@PathVariable Long bookingId) {
        return paymentService.getPaymentDetails(bookingId);
    }


    @PutMapping("/cancelPayment/{bookingId}")
    public String cancelPayment(@PathVariable Long bookingId) {
        paymentService.cancelPayment(bookingId);
        return "Payment has been cancelled successfully.";
    }
    
    
    @GetMapping("/getPaymentDetailsByEmail")
    public List<PaymentDTO> getPaymentDetailsByEmail(@RequestParam String email) {
        return paymentService.getPaymentDetailsByEmail(email);
    }
    
}
