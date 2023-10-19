package com.neqo.portafolio.infraestructure.proyect.adapters.output;

import com.neqo.portafolio.application.profile.port.output.IProfileRepository;
import com.neqo.portafolio.application.proyect.port.output.IProyectRepository;
import com.neqo.portafolio.domain.proyect.entities.Proyect;
import com.neqo.portafolio.infraestructure.profile.mappers.ProfileMapper;
import com.neqo.portafolio.infraestructure.proyect.crud.IProyectCrudRepository;
import com.neqo.portafolio.infraestructure.proyect.mappers.ProyectMapper;
import com.neqo.portafolio.infraestructure.tag.mappers.TagsMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProyectRepositoryImpl implements IProyectRepository {
    private IProyectCrudRepository crud_repository;
    private IProfileRepository profile_repo;
    private ProyectMapper mapper;
    private TagsMapper tags_mapper;
    private ProfileMapper profile_mapper;

    public ProyectRepositoryImpl(IProyectCrudRepository crud_repository, IProfileRepository profile_repo, ProyectMapper mapper, TagsMapper tags_mapper, ProfileMapper profile_mapper) {
        this.crud_repository = crud_repository;
        this.profile_repo = profile_repo;
        this.mapper = mapper;
        this.tags_mapper = tags_mapper;
        this.profile_mapper = profile_mapper;
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
            proyect.setUuid(proyect_dao.getUuid());
            proyect.setProfile_uuid(proyect_dao.getProfile_uuid());
            proyect_lst.add(proyect);
        });

        return proyect_lst;
    }

    @Override
    public Proyect create(Proyect proyect) {
        var profile = this.profile_repo.get(proyect.getProfile_uuid());
        var proyect_dao = this.mapper.domain_to_dao(proyect);
        var proyect_db = this.crud_repository.save(proyect_dao);
        var domain_proyect = this.mapper.dao_to_domain(proyect_db);
        domain_proyect.setProfile_uuid(profile.getUuid());
        return domain_proyect;
    }

    @Override
    public Proyect update(Proyect proyect) {
        System.out.println(proyect);
        var proyect_dao = this.crud_repository.save(this.mapper.domain_to_dao(proyect));
        System.out.println(proyect_dao.toString());
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
