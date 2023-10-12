package com.neqo.portafolio.infraestructure.user.crud;

import com.neqo.portafolio.infraestructure.user.models.AccountDAO;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IAccountCrudRepository extends CrudRepository<AccountDAO, String> {
    /**
     * @param username
     */
    Optional<AccountDAO> findByUsername(String username);

}
