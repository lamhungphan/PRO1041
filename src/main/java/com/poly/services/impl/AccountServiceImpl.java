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
        System.out.println("SERVICES"+ entity.getPassword());
        return repo.update(entity);
    }

    @Override
    public Account getAccount(Integer id) {
        return repo.getAccount(id);
    }
}
