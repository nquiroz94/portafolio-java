package com.neqo.portafolio.infraestructure.profile.crud;

import com.neqo.portafolio.infraestructure.profile.models.ProfileDAO;
import org.springframework.data.repository.CrudRepository;

public interface IProfileCrudRepository extends CrudRepository<ProfileDAO, String> {
}
