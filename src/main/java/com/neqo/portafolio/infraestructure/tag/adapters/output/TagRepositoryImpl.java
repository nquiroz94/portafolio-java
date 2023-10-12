package com.neqo.portafolio.infraestructure.tag.adapters.output;

import com.neqo.portafolio.application.tag.port.output.ITagRepository;
import com.neqo.portafolio.domain.tag.entities.Tag;
import com.neqo.portafolio.infraestructure.tag.crud.ITagCrudRepository;
import com.neqo.portafolio.infraestructure.tag.mappers.TagsMapper;

import java.util.List;

public class TagRepositoryImpl implements ITagRepository {
    private ITagCrudRepository crud;
    private TagsMapper mapper;

    public TagRepositoryImpl(ITagCrudRepository crud) {
        this.crud = crud;
    }

    @Override
    public Tag get(String uuid) {
        var dao = this.crud.findById(uuid);
        if(dao.isEmpty())
            return null;
        var tag_dao = dao.get();
        return this.mapper.dao_to_domain(tag_dao);
    }
    public Tag getByTagName(String name){
        return this.mapper.dao_to_domain(this.crud.findByTag(name));
    }

    @Override
    public List<Tag> getAll() {
        return this.mapper.dao_lst_to_domain_lst(this.crud.findAll());
    }

    @Override
    public Tag create(Tag tag) {
        var obj = this.crud.save(this.mapper.domain_to_dao(tag));
        return this.mapper.dao_to_domain(obj);
    }

    @Override
    public Tag update(Tag tag) {
        var obj = this.crud.save(this.mapper.domain_to_dao(tag));
        return this.mapper.dao_to_domain(obj);    }

    @Override
    public Boolean delete(String uuid) {
        var tag = this.get(uuid);
        if(tag == null)
            return false;

        this.crud.delete(this.mapper.domain_to_dao(tag));
        return true;

    }
}
