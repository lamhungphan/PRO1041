/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.injection;

import com.poly.repository.AccountRepository;
import com.poly.repository.impl.AccountRepoImpl;
import com.poly.services.AccountService;
import com.poly.services.impl.AccountServiceImpl;

/**
 *
 * @author Computer
 */
public class AccountInjector {
    
    private static AccountInjector instance;
    
    private AccountRepository accountRepository;
    private AccountService accountService;
    
    private AccountInjector(){
        this.accountRepository = new AccountRepoImpl();
        this.accountService = new AccountServiceImpl(accountRepository);
    }

    public static AccountInjector getInstance() {
        if(instance == null){
            instance = new AccountInjector();
        }
        return instance;
    }

    public AccountService getAccountService() {
        return accountService;
    }


}
