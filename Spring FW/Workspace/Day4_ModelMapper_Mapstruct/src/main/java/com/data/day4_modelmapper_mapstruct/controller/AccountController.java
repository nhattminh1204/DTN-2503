package com.data.day4_modelmapper_mapstruct.controller;

import com.data.day4_modelmapper_mapstruct.dto.response.AccountRes;
import com.data.day4_modelmapper_mapstruct.entity.Account;
import com.data.day4_modelmapper_mapstruct.service.AccountService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("account")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccountController {
    AccountService accountService;
    ModelMapper modelMapper;

    public ResponseEntity<?> getAll() {
        List<Account> accounts = accountService.getAll();
        // Dùng ModelMapper
        List<AccountRes> accountResList = modelMapper
                .map(accounts, new TypeToken<List<AccountRes>>() {}.getType());

        return new ResponseEntity<>(accountResList, HttpStatus.OK);
    }
}
