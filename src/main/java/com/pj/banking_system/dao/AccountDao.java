package com.pj.banking_system.dao;

import com.pj.banking_system.model.Account;
import java.util.Optional;

public interface AccountDao {

    Account save(Account a);

    Optional<Account> findById(Long id);

    Account findByAccountNumber(String accountNumber);
}
