package com.data.day6_security.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountCreateDTO {
    String username;
    String password;
    String fullName;
    String email;
}
