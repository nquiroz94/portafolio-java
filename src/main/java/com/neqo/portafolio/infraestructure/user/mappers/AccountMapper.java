package com.neqo.portafolio.infraestructure.user.mappers;

import com.neqo.portafolio.domain.user.entities.Account;
import com.neqo.portafolio.infraestructure.profile.mappers.ProfileMapper;
import com.neqo.portafolio.infraestructure.profile.models.ProfileDAO;
import com.neqo.portafolio.infraestructure.user.models.AccountDAO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountMapper {

    private ProfileMapper profile_mapper;

    public AccountMapper(ProfileMapper mapper) {
        this.profile_mapper = mapper;
    }

    public Account dao_to_domain(AccountDAO acc_dao){
        System.out.println("dao_to_domain");
        System.out.println(acc_dao.toString());
        var account = new Account();
        account.setUuid(acc_dao.getUuid());
        account.setEmail(acc_dao.getEmail());
        account.setUsername(acc_dao.getUsername());
        acc_dao.getProfile().setAccount(acc_dao);
        account.setProfile(this.profile_mapper.dao_to_domain(acc_dao.getProfile()));
        return account;
    }


    public List<Account> daos_to_domains(Iterable<AccountDAO> account_dao_lst){
        var accounts = new ArrayList<Account>();
        account_dao_lst.forEach(acc_dao ->{
            var account = new Account();
            account.setUuid(acc_dao.getUuid());
            account.setEmail(acc_dao.getEmail());
            account.setUsername(acc_dao.getUsername());
            account.setProfile(this.profile_mapper.dao_to_domain(acc_dao.getProfile()));
            accounts.add(account);
        });

        return accounts;
    }

    public AccountDAO domain_to_dao(Account account) {
        var acc_dao = new AccountDAO();
        acc_dao.setUsername(account.getUsername());
        acc_dao.setEmail(account.getEmail());
        System.out.println(account.toString());
        if(account.getProfile() != null)
            acc_dao.setProfile(this.profile_mapper.domain_to_dao(account.getProfile()));
        else
            acc_dao.setProfile(new ProfileDAO());
        return acc_dao;
    }
}
