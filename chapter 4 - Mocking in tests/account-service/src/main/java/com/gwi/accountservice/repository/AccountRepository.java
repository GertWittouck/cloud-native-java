package com.gwi.accountservice.repository;

import com.gwi.accountservice.model.Account;
import com.gwi.accountservice.model.AccountNumber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    List<Account> findByUsername(String username);

    Account findAccountByAccountNumber(AccountNumber accountNumber);
}
