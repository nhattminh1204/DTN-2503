package com.data.elearning_api.service;

import com.data.elearning_api.entity.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccountService extends UserDetailsService {
    Account getByUsername(String username);
}
