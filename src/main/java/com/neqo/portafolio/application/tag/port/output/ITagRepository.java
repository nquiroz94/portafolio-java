package com.neqo.portafolio.application.tag.port.output;

import com.neqo.portafolio.domain.tag.entities.Tag;

import java.util.List;

public interface ITagRepository {
    Tag get(String uuid);
    Tag getByTagName(String tag_name);
    List<Tag> getAll();
    Tag create(Tag tag);
    Tag update(Tag tag);
    Boolean delete(String uuid);
}
