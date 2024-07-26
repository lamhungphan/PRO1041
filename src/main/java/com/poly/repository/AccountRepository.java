package com.poly.repository;

import com.poly.entity.Account;

public interface AccountRepository {

    Account getAccount (Integer id);

    Account update (Account entity);
}
