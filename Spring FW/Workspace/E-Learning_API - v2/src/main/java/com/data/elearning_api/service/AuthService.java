package com.data.elearning_api.service;

import com.data.elearning_api.dto.request.LoginRequest;
import com.data.elearning_api.dto.request.RegisterRequest;
import com.data.elearning_api.dto.response.AuthResponse;

public interface AuthService {
    AuthResponse login(LoginRequest loginRequest);
    AuthResponse register(RegisterRequest registerRequest);
}
