package com.data.elearning_api.dto.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountRes {
    int id;
    String username;
    String email;
    String role;
    Date dateOfBirth;
    String address;
    Date createAt;
    Date updateAt;

}
