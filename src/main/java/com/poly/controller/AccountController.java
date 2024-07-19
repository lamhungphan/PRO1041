/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.controller;

import com.poly.entity.Account;
import com.poly.services.impl.AccountServiceImpl;
import lombok.RequiredArgsConstructor;

import javax.swing.*;

/**
 *
 * @author Computer
 */
@RequiredArgsConstructor
public class AccountController {

    private final AccountServiceImpl service;

    public Account saveAccount(JTextField txtUsername, JPasswordField txtPassword){
        String username = txtUsername.getText();
        String password = String.valueOf(txtPassword.getPassword());
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        return service.save(account);
    }

    public Account setAccount(){
        return service.getAccount("1");
    }


}
