package com.neqo.portafolio.infraestructure.proyect.adapters.input;

import com.neqo.portafolio.application.proyect.port.input.IProyectService;
import com.neqo.portafolio.domain.proyect.entities.Proyect;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${v1API}/proyect")
public class ProyectController {
    private IProyectService proyect_service;

    public ProyectController(IProyectService proyect_service) {
        this.proyect_service = proyect_service;
    }

    @GetMapping
    public Proyect get_by_uuid(@PathVariable String uuid){
        return this.proyect_service.get(uuid);
    }
    @GetMapping("/all")
    public List<Proyect> get_all(){
        return this.proyect_service.getAll();
    }
    @PostMapping
    public Proyect create(Proyect proyect){
        return this.proyect_service.create(proyect);
    }
    @PutMapping
    public Proyect update(Proyect proyect){
        return this.proyect_service.update((proyect));
    }
    @DeleteMapping
    public Boolean delete(String uuid){
        return this.proyect_service.delete(uuid);
    }
}
