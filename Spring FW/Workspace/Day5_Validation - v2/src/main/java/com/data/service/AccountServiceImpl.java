package com.data.service;

import com.data.enitity.Account;
import com.data.repository.AccountRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccountServiceImpl implements AccountService {
    AccountRepository accountRepo;

    @Override
    public boolean create(Account account) {
        accountRepo.save(account);
        return true;
    }
}
