package com.neqo.portafolio.infraestructure.profile.adapters.input;

import com.neqo.portafolio.application.profile.port.input.IProfileService;
import com.neqo.portafolio.domain.profile.entities.Profile;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${v1API}/profile")
public class ProfileController {
    private IProfileService profile_service;

    public ProfileController(IProfileService profile_service) {
        this.profile_service = profile_service;
    }

    @GetMapping
    public Profile get(String uuid){
        return this.profile_service.get(uuid);
    }
    @GetMapping("/all")
    public List<Profile> get_all(){
        return this.profile_service.getAll();
    }
    @PostMapping
    public Profile crete(Profile profile){
        return this.profile_service.create(profile);
    }
    @PutMapping
    public Profile update(Profile profile){
        return this.profile_service.update(profile);
    }
    @DeleteMapping
    public Boolean delete(String uuid){
        return this.profile_service.delete(uuid);
    }
}
