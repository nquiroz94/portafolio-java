package com.neqo.portafolio.infraestructure.tag.adapters.input;


import com.neqo.portafolio.application.tag.port.input.ITagService;
import com.neqo.portafolio.domain.tag.entities.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${v1API}/tag")
public class TagController {

    /**
     * TODO:
     * revisar update: pareciera que actualiza pero no lo hace:
     * ver que hacer con el caso C# en tags.
     * */
    private ITagService service;

    public TagController(ITagService service) {
        this.service = service;
    }
    @GetMapping("/id")
    public Tag get_tag_by_id(@RequestParam String uuid){
        return this.service.get(uuid);
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
    public Boolean delete(@RequestBody Tag tag){
        return this.service.delete(tag.getUuid());
    }


}
