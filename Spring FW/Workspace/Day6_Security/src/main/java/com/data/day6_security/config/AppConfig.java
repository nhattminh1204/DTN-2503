package com.data.day6_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AppConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        // cross site forgery: chặn việc request giả mạo
        httpSecurity.csrf().disable();

        // Tất cả request đều phải xác thực gửi username/password
        httpSecurity.authorizeRequests().requestMatchers("/products/**").hasRole("ADMIN");

        httpSecurity.authorizeRequests().requestMatchers("/account").permitAll();

        // Tất cả request đều phải xác thực gửi username/password
        httpSecurity.authorizeRequests().anyRequest().authenticated();

        httpSecurity.httpBasic();

        return httpSecurity.build();
    }
}
