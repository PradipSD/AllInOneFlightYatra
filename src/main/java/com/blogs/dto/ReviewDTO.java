package com.blogs.dto;

import lombok.*;
import java.time.LocalDateTime;

import jakarta.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {

    private Long reviewId;
    @Min(value = 1, message = "Minimum rating is 1")
    @Max(value = 5, message = "Maximum rating is 5")
    private int rating;
    @NotBlank(message = "Review cannot be empty")
    private String review;
    private LocalDateTime reviewDate;
    
    private Long userId;
    private String userName;  

    private Long airlineId;
    private String airlineName; 
    
    private Long flightId;

}
