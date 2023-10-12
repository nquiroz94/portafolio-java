package com.neqo.portafolio.infraestructure.tag.models;

import jakarta.persistence.*;

@Entity
@Table(name = "TAGS")
public class TagDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;
    private String tag;

    public TagDAO(String uuid, String tag) {
        this.uuid = uuid;
        this.tag = tag;
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
