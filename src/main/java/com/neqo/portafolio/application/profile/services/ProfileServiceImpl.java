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
        return null;
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
    public Boolean update(Profile user) {
        return null;
    }

    @Override
    public Boolean delete(String uuid) {
        return null;
    }
}