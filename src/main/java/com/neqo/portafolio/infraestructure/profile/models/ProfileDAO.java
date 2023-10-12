package com.neqo.portafolio.infraestructure.profile.models;

import com.neqo.portafolio.infraestructure.proyect.models.ProyectDAO;
import com.neqo.portafolio.infraestructure.tag.models.TagDAO;
import jakarta.persistence.*;

import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "PROFILES")
public class ProfileDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;
    private String account_uuid;
    private String name;
    private String lastname;
    private String cellphone;
    private String rrss; //las urls iran como un string separado por ";"
    private String avatar_url;
    @OneToMany(fetch = FetchType.LAZY, targetEntity = TagDAO.class)
    private List<TagDAO> tags;
    @OneToMany(fetch = FetchType.LAZY, targetEntity = ProyectDAO.class)
    private List<ProyectDAO> proyects;

    public ProfileDAO(String uuid, String account_uuid, String name, String lastname, String cellphone, List<TagDAO> tags, List<ProyectDAO> proyects) {
        this.uuid = uuid;
        this.account_uuid = account_uuid;
        this.name = name;
        this.lastname = lastname;
        this.cellphone = cellphone;
        this.tags = tags;
        this.proyects = proyects;
    }

    public ProfileDAO() {

    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAccount_uuid() {
        return account_uuid;
    }

    public void setAccount_uuid(String account_uuid) {
        this.account_uuid = account_uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public List<String> getRrss() {
        return Arrays.asList(rrss.split("\\|"));
    }

    public void setRrss(String rrss) {
        this.rrss = rrss;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public List<TagDAO> getTags() {
        return tags;
    }

    public void setTags(List<TagDAO> tags) {
        this.tags = tags;
    }

    public List<ProyectDAO> getProyects() {
        return proyects;
    }

    public void setProyects(List<ProyectDAO> proyects) {
        this.proyects = proyects;
    }
}
