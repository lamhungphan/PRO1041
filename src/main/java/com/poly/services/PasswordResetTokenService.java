package com.poly.services;

import com.poly.entity.PasswordResetToken;

public interface PasswordResetTokenService {
    void save(PasswordResetToken token);
    PasswordResetToken findBytoken(String token);

    void deleteByToken(String token);
}
