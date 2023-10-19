package com.neqo.portafolio.infraestructure.profile.models;

import com.neqo.portafolio.infraestructure.proyect.models.ProyectDAO;
import com.neqo.portafolio.infraestructure.tag.models.TagDAO;
import com.neqo.portafolio.infraestructure.user.models.AccountDAO;
import jakarta.persistence.*;

import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "PROFILES")
public class ProfileDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;
    private String name;
    private String lastname;
    private String cellphone;
    private String rrss;
    private String avatar_url;
    private boolean visible;
    @OneToOne()
    @JoinColumn(name = "account_uuid")
    private AccountDAO account;
    @OneToMany(targetEntity = TagDAO.class, fetch = FetchType.EAGER)
    private List<TagDAO> tags;
    @OneToMany(targetEntity = ProyectDAO.class, fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<ProyectDAO> proyects;

    public ProfileDAO(String uuid, String name, String lastname, String cellphone, String rrss, String avatar_url, boolean visible, AccountDAO account, List<TagDAO> tags, List<ProyectDAO> proyects) {
        this.uuid = uuid;
        this.name = name;
        this.lastname = lastname;
        this.cellphone = cellphone;
        this.rrss = rrss;
        this.avatar_url = avatar_url;
        this.visible = visible;
        this.account = account;
        this.tags = tags;
        this.proyects = proyects;
    }

    public boolean isvisible() {
        return visible;
    }

    public void setIs_visible(boolean is_visible) {
        this.visible = is_visible;
    }

    public AccountDAO getAccount() {
        return account;
    }

    public void setAccount(AccountDAO account) {
        this.account = account;
    }

    public ProfileDAO() {

    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    @Override
    public String toString() {
        return "ProfileDAO{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", rrss='" + rrss + '\'' +
                ", avatar_url='" + avatar_url + '\'' +
                ", tags=" + tags +
                ", proyects=" + proyects +
                '}';
    }
}
