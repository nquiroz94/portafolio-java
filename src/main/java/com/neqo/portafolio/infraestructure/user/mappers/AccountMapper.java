package com.neqo.portafolio.infraestructure.user.mappers;

import com.neqo.portafolio.domain.user.entities.Account;
import com.neqo.portafolio.infraestructure.user.models.AccountDAO;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@Component
public class AccountMapper {

    public Account dao_to_domain(AccountDAO acc_dao){

        var account = new Account();
        account.setUuid(acc_dao.getUuid());
        account.setEmail(acc_dao.getEmail());
        account.setUsername(acc_dao.getUsername());
        return account;
    }


    public List<Account> daos_to_domains(Iterable<AccountDAO> account_dao_lst){
        var accounts = new ArrayList<Account>();
        account_dao_lst.forEach(acc_dao ->{
            var account = new Account();
            account.setUuid(acc_dao.getUuid());
            account.setEmail(acc_dao.getEmail());
            account.setUsername(acc_dao.getUsername());
            accounts.add(account);
        });

        return accounts;
    }

    public AccountDAO dao_to_domain(Account account, String password) throws NoSuchAlgorithmException {
        var acc_dao = new AccountDAO();
        acc_dao.setEmail(account.getEmail());
        acc_dao.setUsername(account.getUsername());
        acc_dao.setUuid(account.getUuid());
        return acc_dao;
    }

    public AccountDAO domain_to_dao(Account account) {
        var acc_dao = new AccountDAO();
        acc_dao.setUsername(account.getUsername());
        acc_dao.setEmail(account.getEmail());
        return acc_dao;
    }
}
