package com.poly.controller;

import com.poly.entity.Account;
import com.poly.services.AccountService;
import com.poly.services.impl.AccountServiceImpl;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // Vi co final nen su dung thay cho constructor
public class AccountController {

    private final AccountService service;

    public Account updateAccount(String username, String password){
        Account account = new Account();
        account.setId(1);
        account.setUsername(username);
        account.setPassword(password);
        return service.update(account);
    }

    public Account setAccount(){
        return service.getAccount("1");
    }

}
