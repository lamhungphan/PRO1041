/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.injection;

import com.poly.services.MailService;
import com.poly.services.UserService;
import com.poly.services.impl.MailServiceImpl;

/**
 *
 * @author Computer
 */
public class MailInjector {
    
    private static MailInjector instance;
    
    private final UserService userService; 
    private final MailService mailService;
    
    private MailInjector(){
        this.userService = UserInjector.getInstance().getUserService();
        this.mailService = new MailServiceImpl(userService);
    }

    public MailInjector getInstance() {
        if(instance == null){
            instance = new MailInjector();
        }
        return instance;
    }

    public MailService getMailService() {
        return mailService;
    }
    
    
}
