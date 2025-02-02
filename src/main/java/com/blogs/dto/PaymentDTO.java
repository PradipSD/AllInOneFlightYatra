package com.blogs.dto;

import com.blogs.pojos.PaymentMethod;
import com.blogs.pojos.PaymentStatus;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {

    private Long paymentId;

    @NotNull(message = "Payment date is required")
    private LocalDateTime paymentDate;

    @NotNull(message = "paymentMethod is required")
    private PaymentMethod paymentMethod;

    @NotNull(message = "Payment status is required")
    private PaymentStatus paymentStatus;

    @Positive(message = "Amount must be a positive value")
    private double amount;

    private Long bookingId;
}
