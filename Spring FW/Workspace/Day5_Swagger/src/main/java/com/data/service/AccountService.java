package com.data.service;

import com.data.enitity.Account;

public interface AccountService {
    boolean create(Account account);
    Account findByUsername(String username);
}
