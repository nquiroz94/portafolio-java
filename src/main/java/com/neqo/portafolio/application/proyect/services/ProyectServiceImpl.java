package com.neqo.portafolio.application.proyect.services;

import com.neqo.portafolio.application.proyect.port.input.IProyectService;
import com.neqo.portafolio.application.proyect.port.output.IProyectRepository;
import com.neqo.portafolio.domain.proyect.entities.Proyect;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProyectServiceImpl implements IProyectService {
    private IProyectRepository repository;

    public ProyectServiceImpl(IProyectRepository repository) {
        this.repository = repository;
    }


    @Override
    public Proyect get(String uuid) {
        return this.repository.get(uuid);
    }

    @Override
    public List<Proyect> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Proyect create(Proyect user) {
        return this.repository.create(user);
    }

    @Override
    public Proyect update(Proyect proyect) {
        return this.repository.update(proyect);
    }

    @Override
    public Boolean delete(String uuid) {
        return this.repository.delete(uuid);
    }
}
