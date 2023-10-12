package com.neqo.portafolio.infraestructure.tag.adapters.input;


import com.neqo.portafolio.application.tag.port.input.ITagService;
import com.neqo.portafolio.domain.tag.entities.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${v1API}/tag")
public class TagController {

    private ITagService service;

    public TagController(ITagService service) {
        this.service = service;
    }
    @GetMapping()
    public Tag get_tag(@RequestParam String tag_name){
        return this.service.getByTagName(tag_name);
    }
    @GetMapping("/all")
    public List<Tag> get_all(){
        return this.service.getAll();
    }

    @PostMapping
    public Tag create(@RequestBody Tag tag){
        return this.service.create(tag);
    }
    @PutMapping
    public Tag update(@RequestBody Tag tag){
        return this.service.update(tag);
    }
    @DeleteMapping
    public Boolean delete(@RequestBody String uuid){
        return this.service.delete(uuid);
    }


}
