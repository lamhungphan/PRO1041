package com.poly.repository;

import com.poly.entity.PasswordResetToken;
import com.poly.repository.impl.PasswordResetTokenRepoImpl;

public interface PasswordResetTokenRepository{
    PasswordResetToken save(PasswordResetToken entity);
    PasswordResetToken findByToken(String token);
}
