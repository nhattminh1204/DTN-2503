package com.data.day6_security.controller;

import com.data.day6_security.dto.AccountCreateDTO;
import com.data.day6_security.entity.Account;
import com.data.day6_security.entity.Product;
import com.data.day6_security.repository.AccountRepository;
import com.data.day6_security.service.AccountService;
import com.data.day6_security.service.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class AccountController {

    AccountRepository accountRepo;
    PasswordEncoder passwordEncoder;

    @GetMapping
    public ResponseEntity<?> getAll() {
        log.info("Get all accounts");
//        log.warn("Get all products");
//        log.error("Get all products");
        List<Account> accounts = accountRepo.findAll();
        return ResponseEntity.ok(accounts);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody AccountCreateDTO dto) {
        log.info("Create account");
        Account account = new Account();
        account.setUsername(dto.getUsername());
        account.setPassword(passwordEncoder.encode(dto.getPassword()));
        account.setFullName(dto.getFullName());
        account.setEmail(dto.getEmail());

        accountRepo.save(account);

        return new ResponseEntity<>(account, HttpStatus.OK);
    }
}
