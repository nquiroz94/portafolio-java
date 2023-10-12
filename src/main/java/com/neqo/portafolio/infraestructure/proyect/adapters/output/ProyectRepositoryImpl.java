package com.neqo.portafolio.infraestructure.proyect.adapters.output;

import com.neqo.portafolio.application.proyect.port.output.IProyectRepository;
import com.neqo.portafolio.domain.proyect.entities.Proyect;
import com.neqo.portafolio.infraestructure.proyect.crud.IProyectCrudRepository;
import com.neqo.portafolio.infraestructure.proyect.mappers.ProyectMapper;
import com.neqo.portafolio.infraestructure.tag.mappers.TagsMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProyectRepositoryImpl implements IProyectRepository {
    private IProyectCrudRepository crud_repository;
    private ProyectMapper mapper;
    private TagsMapper tags_mapper;

    public ProyectRepositoryImpl(IProyectCrudRepository crud_repository, ProyectMapper mapper, TagsMapper tags_mapper) {
        this.crud_repository = crud_repository;
        this.mapper = mapper;
        this.tags_mapper = tags_mapper;
    }

    @Override
    public Proyect get(String uuid) {
        var _proyect = this.crud_repository.findById(uuid);
        if(_proyect.isEmpty())
            return null;
        var proyect_dao = _proyect.get();
        var proyect = this.mapper.dao_to_domain(proyect_dao);
        return proyect;
    }

    @Override
    public List<Proyect> getAll() {
        var proyect_dao_lst = this.crud_repository.findAll();
        var proyect_lst = new ArrayList<Proyect>();
        proyect_dao_lst.forEach(proyect_dao -> {
            var proyect = new Proyect();
            proyect.setName(proyect_dao.getName());
            proyect.setDescription(proyect_dao.getDescription());
            proyect.setTags(this.tags_mapper.dao_lst_to_domain_lst(proyect_dao.getTags()));
            proyect_lst.add(proyect);
        });

        return proyect_lst;
    }

    @Override
    public Proyect create(Proyect proyect) {
        var proyect_dao = this.crud_repository.save(this.mapper.domain_to_dao(proyect));
        return this.mapper.dao_to_domain(proyect_dao);
    }

    @Override
    public Proyect update(Proyect proyect) {
        var proyect_dao = this.crud_repository.save(this.mapper.domain_to_dao(proyect));
        return this.mapper.dao_to_domain(proyect_dao);
    }

    @Override
    public Boolean delete(String uuid) {
        var proyect_dao = this.crud_repository.findById(uuid);
        if(proyect_dao.isEmpty())
            return false;
        this.crud_repository.delete(proyect_dao.get());
        return true;
    }
}
