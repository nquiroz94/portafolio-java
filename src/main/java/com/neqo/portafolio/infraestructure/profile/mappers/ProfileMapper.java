package com.neqo.portafolio.infraestructure.profile.mappers;

import com.neqo.portafolio.domain.profile.entities.Profile;
import com.neqo.portafolio.infraestructure.profile.models.ProfileDAO;
import com.neqo.portafolio.infraestructure.proyect.mappers.ProyectMapper;
import com.neqo.portafolio.infraestructure.tag.mappers.TagsMapper;
import org.springframework.stereotype.Component;

@Component
public class ProfileMapper {
    private ProyectMapper proyect_mapper;
    private TagsMapper tag_mapper;

    public ProfileMapper(ProyectMapper proyect_mapper, TagsMapper tag_mapper) {
        this.proyect_mapper = proyect_mapper;
        this.tag_mapper = tag_mapper;
    }


    // TODO: crear un endpoint para settear el valor de avatar_url.
    public ProfileDAO domain_to_dao(Profile profile){
        var profile_dao = new ProfileDAO();
        profile_dao.setAccount_uuid(profile.getAccount_id());
        profile_dao.setCellphone(profile.getCellphone());
        profile_dao.setProyects(this.proyect_mapper.domain_lst_to_dao_lst(profile.getProyects()));
        profile_dao.setName(profile.getNames());
        profile_dao.setLastname(profile.getLastnames());
        profile_dao.setRrss(String.join("|", profile.getRrss()));
        profile_dao.setTags(this.tag_mapper.domain_lst_to_dao_lst(profile.getProfile_tags()));
        return profile_dao;
    }
}
