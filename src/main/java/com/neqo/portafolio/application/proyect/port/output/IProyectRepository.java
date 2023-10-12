package com.neqo.portafolio.application.proyect.port.output;

import com.neqo.portafolio.domain.proyect.entities.Proyect;

import java.util.List;

public interface IProyectRepository {
    Proyect get(String uuid);
    List<Proyect> getAll();
    Proyect create(Proyect proyect);
    Proyect update(Proyect proyect);
    Boolean delete(String uuid);

}
