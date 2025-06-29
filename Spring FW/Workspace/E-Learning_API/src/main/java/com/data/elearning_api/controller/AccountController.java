package com.data.elearning_api.controller;

import com.data.elearning_api.dto.request.AccountCreateDTO;
import com.data.elearning_api.dto.request.AccountResponseDTO;
import com.data.elearning_api.dto.request.LoginRequestDTO;
import com.data.elearning_api.entity.Account;
import com.data.elearning_api.entity.ROLE;
import com.data.elearning_api.repository.AccountRepository;
import com.data.elearning_api.utils.HashUtil;
import com.data.elearning_api.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping
    public ResponseEntity<?> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        List<AccountResponseDTO> dtos = new ArrayList<>();

        for (Account account : accounts) {
            dtos.add(toDTO(account));
        }

        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<?> getAccountByUsername(@RequestParam("username") String username) {
        Account account = accountRepository.findByUsername(username);
        if (account == null) {
            return new ResponseEntity<>("Tài khoản không tồn tại!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(toDTO(account), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AccountCreateDTO dto) {

        if (accountRepository.existsByUsername(dto.getUsername())) {
            return new ResponseEntity<>("Username '" + dto.getUsername() + "' đã được sử dụng", HttpStatus.BAD_REQUEST);
        }
        if (accountRepository.existsByEmail(dto.getEmail())) {
            return new ResponseEntity<>("Email '" + dto.getEmail() + "' đã được sử dụng", HttpStatus.BAD_REQUEST);
        }

        Account account = new Account();
        account.setUsername(dto.getUsername());
        account.setPassword(HashUtil.hashPassword(dto.getPassword()));
        account.setRole(ROLE.USER);
        account.setEmail(dto.getEmail());
        account.setCreateAt(new Date());
        account.setUpdateAt(new Date());
        account.setDateOfBirth(dto.getDateOfBirth());
        account.setAddress(dto.getAddress());

        accountRepository.save(account);
        return new ResponseEntity<>("Đăng ký thành công tài khoản '" + dto.getUsername() + "'", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO dto) {
        Account account = accountRepository.findByUsername(dto.getUsername());
        if (account == null) {
            return new ResponseEntity<>("Tài khoản không tồn tại!", HttpStatus.BAD_REQUEST);
        }

        if(!HashUtil.matchPassword(dto.getPassword(), account.getPassword())) {
            return new ResponseEntity<>("Sai mật khẩu", HttpStatus.BAD_REQUEST);
        }

        String token = JwtUtil.generateToken(account.getUsername());
        return ResponseEntity.ok().body(
                Map.of("token", token, "username", account.getUsername(), "role", account.getRole())
        );
    }

    private AccountResponseDTO toDTO(Account account) {
        AccountResponseDTO dto = new AccountResponseDTO();
        dto.setUsername(account.getUsername());
        dto.setEmail(account.getEmail());
        dto.setDateOfBirth(account.getDateOfBirth());
        dto.setAddress(account.getAddress());
        return dto;
    }
}
