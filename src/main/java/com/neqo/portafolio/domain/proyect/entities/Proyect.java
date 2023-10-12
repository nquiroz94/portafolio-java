package com.neqo.portafolio.domain.proyect.entities;

import com.neqo.portafolio.domain.tag.entities.Tag;

import java.util.List;

public class Proyect{
    private String name;
    private String description;
    private List<Tag> tags;

    public Proyect(String name, String description, List<Tag> tags) {
        this.name = name;
        this.description = description;
        this.tags = tags;
    }

    public Proyect() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}