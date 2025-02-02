package com.blogs.dto;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AirlineDTO {

    private Long airlineId;

    @NotBlank(message = "Airline name is required")
    @Size(min = 2, max = 100, message = "Airline name must be between 2 and 100 characters")
    private String airlineName;

    @NotBlank(message = "Country of origin is required")
    private String countryOfOrigin;

    @NotBlank(message = "Contact number is required")
    @Pattern(regexp = "^\\+?[0-9]{7,15}$", message = "Invalid contact number format")
    private String contactNumber;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Website is required")
    @Pattern(regexp = "^(http|https)://.*$", message = "Website must be a valid URL")
    private String website;
}

