package com.data.elearning_api.controller;

import com.data.elearning_api.dto.request.LoginRequest;
import com.data.elearning_api.dto.request.RegisterRequest;
import com.data.elearning_api.service.AuthService;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
@Hidden
public class AuthController {

    private final AuthService authService;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginRequest", new LoginRequest());
        return "auth/login"; // đã cập nhật
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute("loginRequest") @Valid LoginRequest request,
                               BindingResult result,
                               Model model) {
        if (result.hasErrors()) {
            return "auth/login";
        }

        try {
            var response = authService.login(request);
            model.addAttribute("message", "Đăng nhập thành công! Token: " + response.getToken());
        } catch (Exception e) {
            model.addAttribute("error", "Đăng nhập thất bại: " + e.getMessage());
        }

        return "auth/login";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("registerRequest", new RegisterRequest());
        return "auth/register";
    }

    @PostMapping("/register")
    public String processRegister(@ModelAttribute("registerRequest") @Valid RegisterRequest request,
                                  BindingResult result,
                                  Model model) {
        if (result.hasErrors()) {
            return "auth/register";
        }

        try {
            var response = authService.register(request);
            model.addAttribute("message", "Đăng ký thành công! Token: " + response.getToken());
        } catch (Exception e) {
            model.addAttribute("error", "Đăng ký thất bại: " + e.getMessage());
        }

        return "auth/register";
    }
}
