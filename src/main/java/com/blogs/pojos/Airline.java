package com.blogs.pojos;

import jakarta.persistence.*;
import java.util.List;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "airlines")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Airline {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long airlineId;

    @Column(name = "airline_name", nullable = false, unique = true)
    @NotBlank(message = "Airline name is required")
    @Size(min = 2, max = 100, message = "Airline name must be between 2 and 100 characters")
    private String airlineName;

    @Column(name = "country_of_origin", nullable = false)
    @NotBlank(message = "Country of origin is required")
    private String countryOfOrigin;

    @Column(name = "contact_number", nullable = false)
    @NotBlank(message = "Contact number is required")
    @Pattern(regexp = "^\\+?[0-9]{7,15}$", message = "Invalid contact number format")
    private String contactNumber;

    @Column(name = "email", nullable = false, unique = true)
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @Column(name = "website", nullable = false)
    @NotBlank(message = "Website is required")
    @Pattern(regexp = "^(http|https)://.*$", message = "Website must be a valid URL")
    private String website;
    
    @OneToMany(mappedBy = "airline", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Flight> flights;
}