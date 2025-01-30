package com.blogs.pojos;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import lombok.*;

@Entity
@Table(name = "nearest_airports")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NearestAirportLocations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nearAirportLocId;

    @Column(name = "airport_name", nullable = false)
    @NotBlank(message = "Airport name is required")
    @Size(min = 3, max = 100, message = "Airport name must be between 3 and 100 characters")
    private String airportName;

    @Column(name = "city", nullable = false)
    @NotBlank(message = "City is required")
    @Size(min = 2, max = 50, message = "City must be between 2 and 50 characters")
    private String city;

    @Column(name = "country", nullable = false)
    @NotBlank(message = "Country is required")
    @Size(min = 2, max = 50, message = "Country must be between 2 and 50 characters")
    private String country;

    @Column(name = "longitude", nullable = false)
    @NotNull(message = "Longitude is required")
    @DecimalMin(value = "-180.0", message = "Longitude must be >= -180.0")
    @DecimalMax(value = "180.0", message = "Longitude must be <= 180.0")
    private Double longitude;

    @Column(name = "latitude", nullable = false)
    @NotNull(message = "Latitude is required")
    @DecimalMin(value = "-90.0", message = "Latitude must be >= -90.0")
    @DecimalMax(value = "90.0", message = "Latitude must be <= 90.0")
    private Double latitude;
}