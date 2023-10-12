package com.neqo.portafolio.infraestructure.tag.crud;

import com.neqo.portafolio.infraestructure.tag.models.TagDAO;
import org.springframework.data.repository.CrudRepository;

public interface ITagCrudRepository extends CrudRepository<TagDAO, String> {
    TagDAO findByTag(String name);
}
