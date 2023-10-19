package com.neqo.portafolio.application.proyect.services;

import com.neqo.portafolio.application.profile.port.output.IProfileRepository;
import com.neqo.portafolio.application.proyect.port.input.IProyectService;
import com.neqo.portafolio.application.proyect.port.output.IProyectRepository;
import com.neqo.portafolio.application.tag.port.output.ITagRepository;
import com.neqo.portafolio.domain.proyect.entities.Proyect;
import com.neqo.portafolio.domain.tag.entities.Tag;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProyectServiceImpl implements IProyectService {
    private IProyectRepository proyect_repository;
    private IProfileRepository profile_repository;
    private ITagRepository tag_repository;

    public ProyectServiceImpl(IProyectRepository repository, IProfileRepository profile_repository, ITagRepository tag_repository) {
        this.proyect_repository = repository;
        this.profile_repository = profile_repository;
        this.tag_repository = tag_repository;
    }

    @Override
    public Proyect get(String uuid) {
        return this.proyect_repository.get(uuid);
    }

    @Override
    public List<Proyect> getAll() {
        return this.proyect_repository.getAll();
    }

    @Override
    public Proyect create(Proyect proyect) {
        System.out.println(proyect.toString());
        var profile = this.profile_repository.get(proyect.getProfile_uuid());

        System.out.println(profile.toString());
        if(profile == null)
            return null;
        var tags = new ArrayList<Tag>();
        proyect.getTags().forEach(tag -> {
            var db_tag = this.tag_repository.getByTagName(tag.getTag_description());
            if(db_tag == null)
                db_tag = this.tag_repository.create(tag);

            tags.add(db_tag);
        });

        proyect.setTags(tags);

        var proyect_db = this.proyect_repository.create(proyect);

        var db_proyect = this.proyect_repository.create(proyect);
        var proyects = profile.getProyects();
        proyects.add(proyect);
        profile.setProyects(proyects);

        this.profile_repository.update(profile);
        return db_proyect;
    }

    @Override
    public Proyect update(Proyect proyect) {
        return this.proyect_repository.update(proyect);
    }

    @Override
    public Boolean delete(String uuid) {
        return this.proyect_repository.delete(uuid);
    }
}
