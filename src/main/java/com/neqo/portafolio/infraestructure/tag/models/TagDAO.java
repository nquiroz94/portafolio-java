package com.neqo.portafolio.infraestructure.tag.models;

import com.neqo.portafolio.infraestructure.profile.models.ProfileDAO;
import com.neqo.portafolio.infraestructure.proyect.models.ProyectDAO;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TAGS")
public class TagDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;
    private String tag;
    @ManyToMany(targetEntity = ProfileDAO.class)
    private List<ProfileDAO> profiles;
    @ManyToMany(targetEntity = ProyectDAO.class)
    private List<ProyectDAO> proyects;

    public TagDAO(String uuid, String tag, List<ProfileDAO> profiles, List<ProyectDAO> proyects) {
        this.uuid = uuid;
        this.tag = tag;
        this.profiles = profiles;
        this.proyects = proyects;
    }

    public List<ProfileDAO> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<ProfileDAO> profiles) {
        this.profiles = profiles;
    }

    public List<ProyectDAO> getProyects() {
        return proyects;
    }

    public void setProyects(List<ProyectDAO> proyects) {
        this.proyects = proyects;
    }

    public TagDAO() {

    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
