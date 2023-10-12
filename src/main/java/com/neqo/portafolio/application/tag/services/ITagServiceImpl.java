package com.neqo.portafolio.application.tag.services;

import com.neqo.portafolio.application.tag.port.input.ITagService;
import com.neqo.portafolio.application.tag.port.output.ITagRepository;
import com.neqo.portafolio.domain.tag.entities.Tag;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ITagServiceImpl implements ITagService {
    private ITagRepository repository;

    public ITagServiceImpl(ITagRepository repository) {
        this.repository = repository;
    }

    @Override
    public Tag get(String uuid) {
        return null;
    }

    @Override
    public Tag getByTagName(String name) {
        return this.repository.getByTagName(name);
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
