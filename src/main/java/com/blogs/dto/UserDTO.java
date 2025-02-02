package com.blogs.dto;

import com.blogs.pojos.Role;

import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long userId;

    @NotBlank(message = "First name is required")
    private String fname;

    @NotBlank(message = "Last name is required")
    private String lname;

    @NotBlank(message = "Phone number is required")
    private String phoneNo;

    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    private Role role;

//    private List<BookingDTO> bookings;
}
