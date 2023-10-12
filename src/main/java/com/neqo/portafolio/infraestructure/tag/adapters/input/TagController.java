package com.neqo.portafolio.infraestructure.tag.adapters.input;


import com.neqo.portafolio.application.tag.port.input.ITagService;
import com.neqo.portafolio.domain.tag.entities.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${v1API}/tag")
public class TagController {

    private ITagService service;

    public TagController(ITagService service) {
        this.service = service;
    }

    /*
    * TODO:
    * CRUD TAG
    * SEARCH BY TAG(S)
    */
    @GetMapping()
    public Tag get_tag(@RequestParam String tag_name){
        return null;
    }


}
