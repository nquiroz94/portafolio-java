package com.neqo.portafolio.infraestructure.proyect.models;

import com.neqo.portafolio.infraestructure.tag.models.TagDAO;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "USER_PROYECTS")
public class ProyectDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "proyect_uuid")
    private String uuid;

    @Column(name = "proyect_name")
    private String name;
    @Column(name = "description")
    private String description;
    @ManyToMany(fetch = FetchType.EAGER, targetEntity = TagDAO.class)
    private List<TagDAO> tags;

    public ProyectDAO(String uuid, String name, String description, List<TagDAO> tags) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.tags = tags;
    }


    public ProyectDAO() {

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<TagDAO> getTags() {
        return tags;
    }

    public void setTags(List<TagDAO> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "ProyectDAO{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", tags=" + tags +
                '}';
    }
}