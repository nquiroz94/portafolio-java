package com.neqo.portafolio.infraestructure.profile.mappers;

import com.neqo.portafolio.domain.profile.entities.Profile;
import com.neqo.portafolio.domain.proyect.entities.Proyect;
import com.neqo.portafolio.domain.tag.entities.Tag;
import com.neqo.portafolio.infraestructure.profile.models.ProfileDAO;
import com.neqo.portafolio.infraestructure.proyect.mappers.ProyectMapper;
import com.neqo.portafolio.infraestructure.proyect.models.ProyectDAO;
import com.neqo.portafolio.infraestructure.tag.mappers.TagsMapper;
import com.neqo.portafolio.infraestructure.tag.models.TagDAO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
        profile_dao.setAvatar_url(profile.getAvatar_url());
        profile_dao.setCellphone(profile.getCellphone());
        if(profile.getProyects() != null)
            profile_dao.setProyects(this.proyect_mapper.domain_lst_to_dao_lst(profile.getProyects()));
        else
            profile_dao.setProyects(new ArrayList<ProyectDAO>());
        profile_dao.setName(profile.getNames());
        profile_dao.setLastname(profile.getLastnames());
        if(profile.getRrss() != null)
            profile_dao.setRrss(String.join("|", profile.getRrss()));
        else
            profile_dao.setRrss("");
        if(profile.getProfile_tags() != null)
            profile_dao.setTags(this.tag_mapper.domain_lst_to_dao_lst(profile.getProfile_tags()));
        else
            profile_dao.setTags(new ArrayList<TagDAO>());
        return profile_dao;
    }
    public Profile dao_to_domain(ProfileDAO profile_dao){
        var profile = new Profile();
        profile.setAccount_id(profile_dao.getAccount().getUuid());
        profile.setAvatar_url(profile_dao.getAvatar_url());
        profile.setCellphone(profile_dao.getCellphone());
        if(profile_dao.getProyects() != null)
            profile.setProyects(this.proyect_mapper.dao_lst_to_domain_lst(profile_dao.getProyects()));
        else
            profile.setProyects(new ArrayList<Proyect>());

        profile.setRrss(profile_dao.getRrss());

        if(profile_dao.getTags() != null)
            profile.setProfile_tags(this.tag_mapper.dao_lst_to_domain_lst(profile_dao.getTags()));
        else
            profile.setProfile_tags(new ArrayList<Tag>());
        profile.setNames(profile_dao.getName());
        profile.setLastnames(profile_dao.getLastname());
        profile.setUuid(profile_dao.getUuid());
        return profile;
    }

    public List<Profile> dao_lst_to_domain_lst(Iterable<ProfileDAO> profile_dao_lst) {
        var profile_lst = new ArrayList<Profile>();
        profile_dao_lst.forEach(profile_dao -> {
            var profile = new Profile();
            profile.setAvatar_url(profile_dao.getAvatar_url());
            profile.setCellphone(profile_dao.getCellphone());
            profile.setProyects(this.proyect_mapper.dao_lst_to_domain_lst(profile_dao.getProyects()));
            profile.setRrss(profile_dao.getRrss());
            profile.setProfile_tags(this.tag_mapper.dao_lst_to_domain_lst(profile_dao.getTags()));
            profile.setNames(profile_dao.getName());
            profile.setLastnames(profile.getLastnames());
            profile.setUuid(profile.getUuid());
            profile_lst.add(profile);
        });
        return profile_lst;
    }


    public ProfileDAO update_profile_to_dao(ProfileDAO profile_dao, Profile profile){

        profile_dao.setRrss(String.join("|", profile.getRrss()));
        profile_dao.setTags(this.tag_mapper.domain_lst_to_dao_lst(profile.getProfile_tags()));
        profile_dao.setProyects(this.proyect_mapper.domain_lst_to_dao_lst(profile.getProyects()));
        profile_dao.setLastname(profile.getLastnames());
        profile_dao.setName(profile.getNames());
        profile_dao.setCellphone(profile.getCellphone());
        profile_dao.setAvatar_url(profile.getAvatar_url());
        return profile_dao;
    }
}
