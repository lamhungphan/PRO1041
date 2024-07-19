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
    private final Account account;

    public Account saveAccount(JTextField txtUsername, JPasswordField txtPassword){
        String username = txtUsername.getText();
        String password = String.valueOf(txtPassword.getPassword());
        account.setUsername(username);
        account.setPassword(password);
        return service.save(account);
    }


}
