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
        var profile_dao = this.crud_repository.findById(uuid);
        return this.mapper.dao_to_domain(profile);
    }

    @Override
    public List<Profile> getAll() {
        return null;
    }

    @Override
    public Profile create(Profile user) {
        return null;
    }

    @Override
    public Profile update(Profile user) {
        return null;
    }

    @Override
    public Boolean delete(String uuid) {
        return null;
    }
}

