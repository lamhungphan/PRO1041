package com.poly.controller;

import com.poly.entity.Account;
import com.poly.injection.AccountInjector;
import com.poly.services.AccountService;
import lombok.RequiredArgsConstructor;

import javax.swing.*;

public class AccountController {

    private static final int NORMAL_ACCOUNT_ID = 1;

    private AccountService service = AccountInjector.getInstance().getAccountService();

    public void loadActiveAccount(JTextField usernameField, JPasswordField passwordField, JCheckBox checkBoxField){
        try{
            Account accountToCheckActivation = getAccountInDB();
            System.out.println(accountToCheckActivation.getIsActived());
            if (accountToCheckActivation.getIsActived()){
                usernameField.setText(accountToCheckActivation.getUsername());
                passwordField.setText(accountToCheckActivation.getPassword());
                checkBoxField.setSelected(accountToCheckActivation.getIsActived());
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void doSavePassword(Account accountRequest ,JCheckBox cbSavePassword) {
            updateAccountFillToFormLogin(accountRequest, cbSavePassword);
            System.out.println("Checkbox duoc chon");
            System.out.println("Luu tai khoan mat khau thanh cong");
    }

    public Account updateAccountFillToFormLogin(Account accountRequest, JCheckBox cbSavePassword){
        Account accountSaveStoredscratch = getAccountInDB();
        if (cbSavePassword.isSelected()){
            accountSaveStoredscratch.setId(NORMAL_ACCOUNT_ID);
            accountSaveStoredscratch.setUsername(accountRequest.getUsername());
            accountSaveStoredscratch.setPassword(accountRequest.getPassword());
            accountSaveStoredscratch.setIsActived(cbSavePassword.isSelected());
        } else {
            accountSaveStoredscratch.setId(NORMAL_ACCOUNT_ID);
            accountSaveStoredscratch.setUsername("");
            accountSaveStoredscratch.setPassword("");
            accountSaveStoredscratch.setIsActived(cbSavePassword.isSelected());
        }
        return service.update(accountSaveStoredscratch);
    }

    public Account getAccountInDB(){
        return service.getAccount(NORMAL_ACCOUNT_ID);
    }

}
