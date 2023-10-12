package com.neqo.portafolio.application.proyect.port.input;

import com.neqo.portafolio.domain.proyect.entities.Proyect;

import java.util.List;

public interface IProyectService {
    Proyect get(String uuid);
    List<Proyect> getAll();
    Proyect create(Proyect user);
    Proyect update(Proyect user);
    Boolean delete(String uuid);
}
