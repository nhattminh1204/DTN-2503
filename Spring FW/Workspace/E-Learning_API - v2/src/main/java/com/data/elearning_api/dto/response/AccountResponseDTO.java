package com.data.elearning_api.dto.response;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountResponseDTO {

    @NotBlank
    @Size(min = 5, max = 100)
    String username;

    @NotBlank
    @Size(min = 5, max = 1000)
    String password;

    @NotBlank
    @Email
    @Size(max = 100)
    String email;

    LocalDate dateOfBirth;

    String address;
}
