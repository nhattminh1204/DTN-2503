package com.data.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountCreateDTO {
    @Size(min = 5, max = 20, message = "INVALID_USERNAME_LENGTH")
    String username;

    @Email(message = "INVALID_EMAIL")
    String email;

    @Min(value = 0, message = "INVALID_QUANTITY")
    @Max(value = 100, message = "INVALID_QUANTITY")
    int quantity;

    Date birthday;
}
