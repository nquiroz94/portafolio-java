package com.neqo.portafolio.infraestructure.tag.crud;

import com.neqo.portafolio.infraestructure.tag.models.TagDAO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ITagCrudRepository extends CrudRepository<TagDAO, String> {
    @Query(value = "SELECT * FROM TAGS WHERE tag = ?1", nativeQuery = true)
    TagDAO findByTag(String tag);
}
