package com.neqo.portafolio.application.user.services;

import com.neqo.portafolio.application.profile.port.input.IProfileService;
import com.neqo.portafolio.application.user.ports.input.IAccountService;
import com.neqo.portafolio.application.user.ports.output.IAccountRepository;
import com.neqo.portafolio.domain.user.entities.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService {
    private IAccountRepository repository;
    private IProfileService profile_service;

    public AccountServiceImpl(IAccountRepository repository, IProfileService profile_service) {
        this.repository = repository;
        this.profile_service = profile_service;
    }

    @Override
    public Account get(String uuid) {
        return this.repository.get(uuid);
    }

    @Override
    public List<Account> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Account create(Account account) {
        return this.repository.create(account);
    }

    @Override
    public Account update(Account account) {
        return this.repository.update(account);
    }

    @Override
    public Boolean delete(String uuid) {
        return this.repository.delete(uuid);
    }
}
