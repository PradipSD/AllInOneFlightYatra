package com.blogs.dto;

import lombok.*;


import jakarta.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NearestAirportLocationsDTO {

    private Long nearAirportLocId;

    @NotBlank(message = "Airport name is required")
    @Size(min = 3, max = 100, message = "Airport name must be between 3 and 100 characters")
    private String airportName;

    @NotBlank(message = "City is required")
    @Size(min = 2, max = 50, message = "City must be between 2 and 50 characters")
    private String city;

    @NotBlank(message = "Country is required")
    @Size(min = 2, max = 50, message = "Country must be between 2 and 50 characters")
    private String country;

    @NotNull(message = "Longitude is required")
    @DecimalMin(value = "-180.0", message = "Longitude must be >= -180.0")
    @DecimalMax(value = "180.0", message = "Longitude must be <= 180.0")
    private Double longitude;

    @NotNull(message = "Latitude is required")
    @DecimalMin(value = "-90.0", message = "Latitude must be >= -90.0")
    @DecimalMax(value = "90.0", message = "Latitude must be <= 90.0")
    private Double latitude;
}
