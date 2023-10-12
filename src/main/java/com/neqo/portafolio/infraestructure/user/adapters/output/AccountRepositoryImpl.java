package com.neqo.portafolio.infraestructure.user.adapters.output;

import com.neqo.portafolio.application.user.ports.output.IAccountRepository;
import com.neqo.portafolio.domain.user.entities.Account;
import com.neqo.portafolio.infraestructure.user.crud.IAccountCrudRepository;
import com.neqo.portafolio.infraestructure.user.mappers.AccountMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class AccountRepositoryImpl implements IAccountRepository {

    private final IAccountCrudRepository account_crud;
    private final AccountMapper mapper;

    public AccountRepositoryImpl(IAccountCrudRepository account_crud, AccountMapper mapper) {
        this.account_crud = account_crud;
        this.mapper = mapper;
    }

    @Override
    public Account get(String uuid) {
        var acc = this.account_crud.findById(uuid);
        if(acc.isEmpty())
            return null;
        var acc_dao = acc.get();
        return mapper.dao_to_domain(acc_dao);
    }

    @Override
    public List<Account> getAll() {

        return mapper.daos_to_domains(this.account_crud.findAll());
    }

    @Override
    public Account create(Account account) {
        var f_acc = this.account_crud.findByUsername(account.getUsername());
        if(!f_acc.isEmpty())
            return this.mapper.dao_to_domain(f_acc.get());

        var n_acc = this.account_crud.save(this.mapper.domain_to_dao(account));
        return this.mapper.dao_to_domain(n_acc);
    }

    @Override
    public Account update(Account account) {
        return this.mapper.dao_to_domain(this.account_crud.save(this.mapper.domain_to_dao(account)));
    }

    @Override
    public Boolean delete(String uuid) {

        var account = this.account_crud.findById(uuid);
        if(account.isEmpty())
            return false;
        var acc_dao = account.get();
        this.account_crud.delete(acc_dao);
        return true;
    }
}
