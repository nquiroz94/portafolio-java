package com.neqo.portafolio.domain.user.entities;

import com.neqo.portafolio.domain.profile.entities.Profile;
import com.neqo.portafolio.domain.proyect.entities.Proyect;
import com.neqo.portafolio.domain.tag.entities.Tag;

import java.util.List;

public class Account {
    private String uuid;
    private String email;
    private String username;
    private Profile profile;
    private List<Proyect> proyects;
    private List<Tag> tags;

    public Account(String uuid, String email, String username, Profile profile, List<Proyect> proyects, List<Tag> tags) {
        this.uuid = uuid;
        this.email = email;
        this.username = username;
        this.profile = profile;
        this.proyects = proyects;

        this.tags = tags;
    }

    public Account() {
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
