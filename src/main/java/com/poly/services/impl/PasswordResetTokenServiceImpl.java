package com.poly.services.impl;

import com.poly.entity.PasswordResetToken;
import com.poly.repository.PasswordResetTokenRepository;
import com.poly.repository.impl.PasswordResetTokenRepoImpl;
import com.poly.services.PasswordResetTokenService;

public class PasswordResetTokenServiceImpl implements PasswordResetTokenService {
    private final PasswordResetTokenRepository tokenRepos = new PasswordResetTokenRepoImpl();

    @Override
    public void save(PasswordResetToken token) {
        tokenRepos.save(token);
    }

    @Override
    public PasswordResetToken findBytoken(String token) {
     return  tokenRepos.findByToken(token);
    }

    @Override
    public void deleteByToken(String token) {
        tokenRepos.deleteByToken(token);
    }
}


