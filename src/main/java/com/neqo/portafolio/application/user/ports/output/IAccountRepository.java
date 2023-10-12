package com.neqo.portafolio.application.user.ports.output;

import com.neqo.portafolio.domain.user.entities.Account;

import java.util.List;

public interface IAccountRepository {
    Account get(String uuid);
    List<Account> getAll();
    Account create(Account account);
    Account update(Account account);
    Boolean delete(String uuid);
}
