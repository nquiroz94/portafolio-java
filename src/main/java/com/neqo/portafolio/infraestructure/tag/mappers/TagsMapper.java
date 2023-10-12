package com.neqo.portafolio.infraestructure.tag.mappers;

import com.neqo.portafolio.domain.tag.entities.Tag;
import com.neqo.portafolio.infraestructure.tag.models.TagDAO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class TagsMapper {

    public List<Tag> dao_lst_to_domain_lst(Iterable<TagDAO> tags) {
        var tags_lst = new ArrayList<Tag>();
        tags.forEach(tag_dao -> {
            var d_tag = new Tag();
            d_tag.setUuid(tag_dao.getUuid());
            d_tag.setTag_description(tag_dao.getTag());
            tags_lst.add(d_tag);
        });
        return tags_lst;
    }

    public List<TagDAO> domain_lst_to_dao_lst(Iterable<Tag> tags){
        var tags_dao = new ArrayList<TagDAO>();
        tags.forEach(tag -> {
            var tag_dao = new TagDAO();
            tag_dao.setUuid(tag.getUuid());
            tag_dao.setTag(tag.getTag_description());
            tags_dao.add(tag_dao);
        });
        return tags_dao;
    }

    public Tag dao_to_domain(TagDAO tag_dao) {
        var tag = new Tag();
        tag.setUuid(tag_dao.getUuid());
        tag.setTag_description(tag_dao.getTag());
        return tag;
    }

    public TagDAO domain_to_dao(Tag tag) {
        var dao = new TagDAO();
        dao.setTag(tag.getTag_description());
        dao.setUuid(tag.getUuid());
        return dao;
    }
}
