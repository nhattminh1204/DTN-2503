package com.data.elearning_api.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        // cross site forgery: chặn việc request giả mạo
        httpSecurity.csrf().disable();

        // Phân quyền các endpoint
        httpSecurity.authorizeRequests()
                // endpoint public
                .requestMatchers("/auth/register", "/auth/login").permitAll()
                .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()

                // endpoint yêu cầu xác thực
                .requestMatchers(
                        "/categories/**",
                        "/certificates/**",
                        "/courses/**",
                        "/lessons/**"
                ).authenticated()

                // Mặc định: các request khác đều phải xác thực
                .anyRequest().authenticated();

        httpSecurity.httpBasic();

        return httpSecurity.build();
    }
}
