package com.poly.services;

import com.poly.entity.PasswordResetToken;

public interface PasswordResetTokenService {
    void save(PasswordResetToken token);
    void findBytoken(String token);

}
