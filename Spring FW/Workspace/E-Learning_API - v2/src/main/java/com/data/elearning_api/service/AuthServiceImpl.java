package com.data.elearning_api.service;

import com.data.elearning_api.dto.request.LoginRequest;
import com.data.elearning_api.dto.request.RegisterRequest;
import com.data.elearning_api.dto.response.AuthResponse;
import com.data.elearning_api.entity.Account;
import com.data.elearning_api.entity.ROLE;
import com.data.elearning_api.exception.AppException;
import com.data.elearning_api.exception.ErrorCode;
import com.data.elearning_api.repository.AuthRepository;
import com.data.elearning_api.utils.JwtUtil;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthServiceImpl implements AuthService {

    AuthRepository authRepository;
    JwtUtil jwtUtil;
    ModelMapper modelMapper;
    PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse register(RegisterRequest request) {
        if (authRepository.existsByUsername(request.getUsername()) ||
                authRepository.existsByEmail(request.getEmail())) {
            throw new AppException(ErrorCode.USER_EXISTS);
        }

        Account account = modelMapper.map(request, Account.class);
        account.setPassword(passwordEncoder.encode(request.getPassword()));
        account.setRole(ROLE.USER);

        Account saved = authRepository.save(account);
        String token = jwtUtil.generateToken(saved.getUsername());

        return new AuthResponse(token, saved.getUsername());
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        Account user = authRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new AppException(ErrorCode.INVALID_CREDENTIALS));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new AppException(ErrorCode.INVALID_CREDENTIALS);
        }

        String token = jwtUtil.generateToken(user.getUsername());
        return new AuthResponse(token, user.getUsername());
    }
}


