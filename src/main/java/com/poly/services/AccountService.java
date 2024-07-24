package com.poly.services;

import com.poly.entity.Account;

public interface AccountService {

    Account update(Account entity);

    Account getAccount(String id);
}
