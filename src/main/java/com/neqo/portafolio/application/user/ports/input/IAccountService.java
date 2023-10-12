package com.neqo.portafolio.application.user.ports.input;

import com.neqo.portafolio.domain.user.entities.Account;

import java.util.List;

public interface IAccountService {
        Account get(String uuid);
        List<Account> getAll();
        Account create(Account user);
        Account update(Account user);
        Boolean delete(String uuid);
    }
