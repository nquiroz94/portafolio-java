package com.neqo.portafolio.application.tag.services;

import com.neqo.portafolio.application.tag.port.input.ITagService;
import com.neqo.portafolio.application.tag.port.output.ITagRepository;
import com.neqo.portafolio.domain.tag.entities.Tag;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TagServiceImpl implements ITagService {
    private ITagRepository repository;

    public TagServiceImpl(ITagRepository repository) {
        this.repository = repository;
    }

    @Override
    public Tag get(String uuid) {
        return this.repository.get(uuid);
    }

    @Override
    public Tag getByTagName(String name) {
        return this.repository.getByTagName(name);
    }

    @Override
    public List<Tag> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Tag create(Tag tag) {
        return this.repository.create(tag);
    }

    @Override
    public Tag update(Tag tag) {

        return this.repository.update(tag);
    }

    @Override
    public Boolean delete(String uuid) {
        return this.repository.delete(uuid);
    }
}
