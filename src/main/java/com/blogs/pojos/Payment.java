package com.blogs.pojos;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.Data;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    @NotNull(message = "Payment date is required")
    private LocalDateTime paymentDate;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "paymentMethod is required")
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Payment status is required")
    private PaymentStatus paymentStatus;

    @Positive(message = "Amount must be a positive value")
    private double amount;

    @OneToOne
    @JoinColumn(name = "booking_id")
    private BookingFlight booking;
}