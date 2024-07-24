package com.poly.services.impl;

import com.poly.entity.Account;
import com.poly.repository.AccountRepository;
import com.poly.services.AccountService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repo;

    @Override
    public Account update(Account entity) {
        return repo.update(entity);
    }

    @Override
    public Account getAccount(String id) {
        return repo.getAccount(id);
    }
}
