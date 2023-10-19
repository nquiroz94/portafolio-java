package com.neqo.portafolio.domain.profile.entities;

import com.neqo.portafolio.domain.proyect.entities.Proyect;
import com.neqo.portafolio.domain.tag.entities.Tag;

import java.util.List;

public class Profile {
    private String uuid;
    private String account_id;
    private String names;
    private String lastnames;
    private String cellphone;
    private List<Proyect> proyects;
    private List<Tag> profile_tags;
    private List<String> rrss;
    private String avatar_url;

    public Profile(String uuid, String account_id, String names, String lastnames, String cellphone, List<Proyect> proyects, List<Tag> profile_tags, List<String> rrss, String avatar_url) {
        this.uuid = uuid;
        this.account_id = account_id;
        this.names = names;
        this.lastnames = lastnames;
        this.cellphone = cellphone;
        this.proyects = proyects;
        this.profile_tags = profile_tags;
        this.rrss = rrss;
        this.avatar_url = avatar_url;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public List<String> getRrss() {
        return rrss;
    }

    public void setRrss(List<String> rrss) {
        this.rrss = rrss;
    }

    public Profile() {
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLastnames() {
        return lastnames;
    }

    public void setLastnames(String lastnames) {
        this.lastnames = lastnames;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public List<Proyect> getProyects() {
        return proyects;
    }

    public void setProyects(List<Proyect> proyects) {
        this.proyects = proyects;
    }

    public List<Tag> getProfile_tags() {
        return profile_tags;
    }

    public void setProfile_tags(List<Tag> profile_tags) {
        this.profile_tags = profile_tags;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "uuid='" + uuid + '\'' +
                ", account_id='" + account_id + '\'' +
                ", names='" + names + '\'' +
                ", lastnames='" + lastnames + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", proyects=" + proyects +
                ", profile_tags=" + profile_tags +
                ", rrss=" + rrss +
                '}';
    }
}


