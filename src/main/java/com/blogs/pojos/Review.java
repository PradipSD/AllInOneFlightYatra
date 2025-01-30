package com.blogs.pojos;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @NotNull(message = "Rating is required")
    @Min(value = 1, message = "Minimum rating is 1")
    @Max(value = 5, message = "Maximum rating is 5")
    private int rating;

    @NotBlank(message = "Review cannot be empty")
    @Size(max = 500, message = "Review cannot exceed 500 characters")
    private String review;

    @NotNull(message = "Review date is required")
    private LocalDateTime reviewDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "airline_id")
    private Airline airline;
    
    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;
}