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
    public void findBytoken(String token) {
        tokenRepos.findByToken(token);
    }
}


