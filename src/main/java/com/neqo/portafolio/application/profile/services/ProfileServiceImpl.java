package com.neqo.portafolio.application.profile.services;

import com.neqo.portafolio.application.profile.port.input.IProfileService;
import com.neqo.portafolio.application.profile.port.output.IProfileRepository;
import com.neqo.portafolio.domain.profile.entities.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProfileServiceImpl implements IProfileService{

    private IProfileRepository repository;

    public ProfileServiceImpl(IProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public Profile get(String uuid) {
        return this.repository.get(uuid);
    }

    @Override
    public List<Profile> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Profile create(Profile profile) {
        return this.repository.create(profile);
    }

    @Override
    public Profile update(Profile profile) {
        System.out.println(profile.toString());
        return this.repository.update(profile);
    }

    @Override
    public Boolean delete(String uuid) {
        return this.repository.delete(uuid);
    }
}