/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.injection;

import com.poly.services.AuthorizationService;
import com.poly.services.impl.AuthorizationServiceImpl;

/**
 *
 * @author Computer
 */
public class AuthorizationInjector {

    private static AuthorizationInjector instance;
    private final AuthorizationService authorizationService;

    private AuthorizationInjector() {
        this.authorizationService = new AuthorizationServiceImpl();
    }

    
    public static AuthorizationInjector getInstance() {
        if (instance == null) {
            instance = new AuthorizationInjector();
        }
        return instance;
    }

    public AuthorizationService getAuthorizationService() {
        return authorizationService;
    }

}
