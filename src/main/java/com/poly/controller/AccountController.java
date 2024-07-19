/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.controller;

import com.poly.entity.Account;
import com.poly.services.impl.AccountServiceImpl;
import lombok.RequiredArgsConstructor;
/**
 *
 * @author Computer
 */
@RequiredArgsConstructor
public class AccountController {

    private final AccountServiceImpl service;

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
