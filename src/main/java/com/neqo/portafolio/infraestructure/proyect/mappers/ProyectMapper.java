package com.neqo.portafolio.infraestructure.proyect.mappers;

import com.neqo.portafolio.domain.proyect.entities.Proyect;
import com.neqo.portafolio.infraestructure.proyect.models.ProyectDAO;
import com.neqo.portafolio.infraestructure.tag.mappers.TagsMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProyectMapper {

    private TagsMapper tags_mapper;

    public ProyectMapper(TagsMapper tags_mapper) {
        this.tags_mapper = tags_mapper;
    }

    public Proyect dao_to_domain(ProyectDAO proyect_dao) {
        System.out.println("------------------");
        System.out.println(proyect_dao.toString());
        var proyect = new Proyect();
        proyect.setName(proyect_dao.getName());
        proyect.setTags(this.tags_mapper.dao_lst_to_domain_lst(proyect_dao.getTags()));
        proyect.setDescription(proyect_dao.getDescription());
        proyect.setUuid(proyect_dao.getUuid());
        proyect.setProfile_uuid(proyect_dao.getProfile_uuid());
        return proyect;
    }

    public ProyectDAO domain_to_dao(Proyect proyect){
        var proyect_dao = new ProyectDAO();
        proyect_dao.setUuid(proyect.getUuid());
        proyect_dao.setName(proyect.getName());
        proyect_dao.setDescription(proyect.getDescription());
        proyect_dao.setTags(this.tags_mapper.domain_lst_to_dao_lst(proyect.getTags()));
        proyect_dao.setProfile_uuid(proyect.getProfile_uuid());
        return proyect_dao;
    }
    public List<ProyectDAO> domain_lst_to_dao_lst(List<Proyect> proyects){
        var proyect_lst_dao = new ArrayList<ProyectDAO>();
        proyects.forEach(proyect -> {
            var proy_dao = new ProyectDAO();
            proy_dao.setUuid(proyect.getUuid());
            proy_dao.setName(proyect.getName());
            proy_dao.setTags(tags_mapper.domain_lst_to_dao_lst(proyect.getTags()));
            proy_dao.setDescription(proyect.getDescription());
            proy_dao.setProfile_uuid(proyect.getProfile_uuid());
            proyect_lst_dao.add(proy_dao);
        });
        return proyect_lst_dao;
    }

    public List<Proyect> dao_lst_to_domain_lst(List<ProyectDAO> proyects_dao) {
        var proyect_lst = new ArrayList<Proyect>();
        proyects_dao.forEach(proyect_dao -> {
            var proyect = new Proyect();
            proyect.setUuid(proyect_dao.getUuid());
            proyect.setName(proyect_dao.getName());
            proyect.setTags(this.tags_mapper.dao_lst_to_domain_lst(proyect_dao.getTags()));
            proyect.setDescription(proyect_dao.getDescription());
            proyect.setProfile_uuid(proyect_dao.getProfile_uuid());
            proyect_lst.add(proyect);
        });
        return proyect_lst;
    }
}
