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
* AGREGAR IS_VISIBLE:Boolean
*
*/
    private IAccountService account_service;


    public AccountController(IAccountService service){
        this.account_service = service;
    }
// account
//
    @PostMapping //return user uuid
    public Account create_account(@RequestBody Account account){
        System.out.println("////////////////////////////");
        System.out.println(account.toString());
        return this.account_service.create(account);
    }

    @GetMapping("/all")
    public List<Account> get_all_accounts(){
        return this.account_service.getAll();
    }
    @GetMapping
    public Account get_account(@RequestParam String uuid){
        System.out.println("account");

        var acc = this.account_service.get(uuid);
        System.out.println(acc.toString());
        return acc;
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
