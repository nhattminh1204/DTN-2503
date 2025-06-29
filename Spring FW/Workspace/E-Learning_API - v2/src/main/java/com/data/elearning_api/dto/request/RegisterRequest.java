package com.data.elearning_api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegisterRequest {
    @NotBlank
    @Size(min = 5, max = 20, message = "INVALID_USERNAME_LENGTH")
    String username;

    @NotBlank
    @Size(min = 6, max = 50, message = "INVALID_PASSWORD_LENGTH")
    String password;

    @NotBlank
    @Email(message = "INVALID_EMAIL")
    String email;

    String address;
    LocalDate dateOfBirth;
}
