package com.poly.services.impl;

import com.poly.entity.Account;
import com.poly.repository.AccountRepository;
import com.poly.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;

@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repo;

    @Override
    public Account update(Account entity) {
        String hashedPassword = BCrypt.hashpw(entity.getPassword(), BCrypt.gensalt());
        entity.setPassword(hashedPassword);
        return repo.update(entity);
    }

    @Override
    public Account getAccount(String id) {
        return repo.getAccount(id);
    }
}
