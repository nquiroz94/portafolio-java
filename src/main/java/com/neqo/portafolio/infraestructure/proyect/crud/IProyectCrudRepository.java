package com.neqo.portafolio.infraestructure.proyect.crud;

import com.neqo.portafolio.infraestructure.proyect.models.ProyectDAO;
import org.springframework.data.repository.CrudRepository;

public interface IProyectCrudRepository extends CrudRepository<ProyectDAO, String> {
}
