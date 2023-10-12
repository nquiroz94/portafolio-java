package com.neqo.portafolio.application.tag.port.input;

import com.neqo.portafolio.domain.tag.entities.Tag;

import java.util.List;

public interface ITagService {
    Tag get(String uuid);
    List<Tag> getAll();
    Tag create(Tag user);
    Boolean update(Tag user);
    Boolean delete(String uuid);
}
