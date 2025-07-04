package com.data.day6_security.service;

import com.data.day6_security.entity.Account;
import com.data.day6_security.repository.AccountRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccountService implements UserDetailsService {
    AccountRepository accountRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Username: " + username);

        Account account = accountRepo.findByUsername(username);

        if (account == null) {
            throw new RuntimeException("Account not exists: " + username) ;
        }

//        return new User(username, account.getPassword(), Collections.emptyList());
        return new User(username, account.getPassword(), AuthorityUtils.createAuthorityList(account.getRole()));
    }
}
