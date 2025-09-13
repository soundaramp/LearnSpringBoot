package com.security.empLogin.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public record LoginPojo(
        @NotBlank(message = "Username is required")
        @Size(min = 3, max = 20, message = "Username must be 3-20 characters")
        String username,

        @NotBlank(message = "Password is required")
        @Size(min = 6, message = "Password must be at least 6 characters")
        String password,

        @NotBlank(message = "Role is required")
        @Size(min=3, message = "Role must be at least 3 characters")
        String role
) {

}
