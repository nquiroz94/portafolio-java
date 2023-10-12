package com.neqo.portafolio.infraestructure.user.adapters.input;

import com.neqo.portafolio.application.user.ports.input.IAccountService;
import com.neqo.portafolio.domain.user.entities.Account;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "${v1API}/account")
public class AccountController {
/*
* TODO:
* login
* logout
* reset_pwd.
*
*/
    private IAccountService account_service;


    public AccountController(IAccountService service){
        this.account_service = service;
    }
// account
//
    @PostMapping //return user uuid
    public String create_account(@RequestBody Account account){
        return this.account_service.create(account).getUuid();
    }

    @GetMapping("/all")
    public List<Account> get_all_accounts(){
        return this.account_service.getAll();
    }
    @GetMapping
    public Account get_account(@RequestParam String uuid){
        return this.account_service.get(uuid);
    }

    @PutMapping
    private Account update(@RequestBody Account account){
        return this.account_service.update(account);
    }

    @DeleteMapping
    public Boolean delete(@RequestBody String uuid){
        return this.account_service.delete(uuid);
    }
}
