package com.neqo.portafolio.infraestructure.tag.adapters.output;

import com.neqo.portafolio.application.tag.port.output.ITagRepository;
import com.neqo.portafolio.domain.tag.entities.Tag;

import java.util.List;

public class TagRepositoryImpl implements ITagRepository {
    @Override
    public Tag get(String uuid) {
        return null;
    }

    @Override
    public List<Tag> getAll() {
        return null;
    }

    @Override
    public Tag create(Tag user) {
        return null;
    }

    @Override
    public Boolean update(Tag user) {
        return null;
    }

    @Override
    public Boolean delete(String uuid) {
        return null;
    }
}
