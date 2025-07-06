package com.data.elearning_api.dto.response;

import com.data.elearning_api.entity.ROLE;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountResponseDTO {
    int id;
    String username;
    String email;
    String address;
    LocalDate dateOfBirth;
    LocalDateTime createAt;
    LocalDateTime updateAt;
    ROLE role;
}
