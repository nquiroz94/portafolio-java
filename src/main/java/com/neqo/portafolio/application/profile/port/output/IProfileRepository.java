package com.neqo.portafolio.application.profile.port.output;

import com.neqo.portafolio.domain.profile.entities.Profile;

import java.util.List;

public interface IProfileRepository {
    Profile get(String uuid);
    List<Profile> getAll();
    Profile create(Profile profile);
    Profile update(Profile profile);
    Boolean delete(String uuid);
}
