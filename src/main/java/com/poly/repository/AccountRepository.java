package com.poly.repository;

import com.poly.entity.Account;

public interface AccountRepository {
    Account create (Account entity);

    Account getAccount (String id);

    Account update (Account entity);
}
