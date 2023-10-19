package com.neqo.portafolio.infraestructure.profile.adapters.output;

import com.neqo.portafolio.application.profile.port.output.IProfileRepository;
import com.neqo.portafolio.domain.profile.entities.Profile;
import com.neqo.portafolio.infraestructure.profile.crud.IProfileCrudRepository;
import com.neqo.portafolio.infraestructure.profile.mappers.ProfileMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ProfileRepositoryImpl implements IProfileRepository {
    private IProfileCrudRepository crud_repository;
    private ProfileMapper mapper;

    public ProfileRepositoryImpl(IProfileCrudRepository crud_repository, ProfileMapper mapper) {
        this.crud_repository = crud_repository;
        this.mapper = mapper;
    }

    @Override
    public Profile get(String uuid) {
        System.out.println(uuid);
        var profile_dao = this.crud_repository.findById(uuid);

        if(profile_dao.isEmpty())
            return null;
        System.out.println(profile_dao.get().toString());
        return this.mapper.dao_to_domain(profile_dao.get());
    }

    @Override
    public List<Profile> getAll() {
        var profile_dao_lst = this.crud_repository.findAll();

        return this.mapper.dao_lst_to_domain_lst(profile_dao_lst);
    }

    @Override
    public Profile create(Profile profile) {
        System.out.println(profile.toString());
        var prof = this.crud_repository.save(this.mapper.domain_to_dao(profile));
        System.out.println(prof.toString());
        return this.mapper.dao_to_domain(prof);
    }

    @Override
    public Profile update(Profile profile) {
        System.out.println(profile.toString());
        var prof_dao = this.crud_repository.findById(profile.getUuid());
        if(prof_dao.isEmpty())
            return null;
        System.out.println("continuando con el update");
        var updated_profile = this.mapper.update_profile_to_dao(prof_dao.get(), profile);
        System.out.println(updated_profile.toString());
        System.out.println("llamando save");
        var prof = this.crud_repository.save(updated_profile);
        System.out.println(prof.toString());
        return this.mapper.dao_to_domain(prof);
    }

    @Override
    public Boolean delete(String uuid) {
        var profile_dao_op = this.crud_repository.findById(uuid);
        if(profile_dao_op.isEmpty())
            return false;
        this.crud_repository.delete(profile_dao_op.get());
        return true;
    }
}

