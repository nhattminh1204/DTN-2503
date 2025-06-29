package com.data.day4_modelmapper_mapstruct.service;

import com.data.day4_modelmapper_mapstruct.entity.Account;
import com.data.day4_modelmapper_mapstruct.repository.AccountRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // Tạo constructor cho các thuộc tính final
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccountServiceImpl implements AccountService {

    // c1: @RequiredArgsConstructor + final
    // final AccountRepository accountRepo;
    // c2: @RequiredArgsConstructor + makeFinal=true
    AccountRepository accountRepo;

    @Override
    public List<Account> getAll() {
        List<Account> accounts = accountRepo.findAll();
        return accounts;
    }
}
