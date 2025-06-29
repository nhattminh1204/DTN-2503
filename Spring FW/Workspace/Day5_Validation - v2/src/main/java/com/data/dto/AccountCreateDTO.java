package com.data.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Singular;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountCreateDTO {
    @Size(min = 5, max = 20, message = "Username length: 5 - 20")
    String username;

    @Email
    String email;

    @Min(value = 0, message = "Quantity value: 0 - 100")
    @Max(value = 100, message = "Quantity value: 0 - 100")
    int quantity;

    Date birthday;
}
