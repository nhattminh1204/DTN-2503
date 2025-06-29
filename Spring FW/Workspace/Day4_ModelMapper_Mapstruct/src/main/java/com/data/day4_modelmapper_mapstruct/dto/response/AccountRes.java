package com.data.day4_modelmapper_mapstruct.dto.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountRes {
    String id;
    String username;
    String password;
    String email;
}
