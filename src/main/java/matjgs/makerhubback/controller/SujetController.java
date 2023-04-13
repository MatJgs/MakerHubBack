package matjgs.makerhubback.controller;

import jakarta.validation.Valid;
import matjgs.makerhubback.models.dto.SujetDTO;
import matjgs.makerhubback.models.form.SujetForm;
import matjgs.makerhubback.services.SujetService;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class SujetController {

    private final SujetService sujetService;

    public SujetController(SujetService sujetService) {
        this.sujetService = sujetService;
    }

    @GetMapping("/sujets/{id}")
    public SujetDTO getOne(@PathVariable Long id) {
        return sujetService.getOne(id);
    }

    @GetMapping("/sujets")
    public List<SujetDTO> getAll(){
        return sujetService.getAll();
    }

    @PostMapping("/sujets/new")
    public void create(@RequestBody @Valid SujetForm form){
        sujetService.create(form);
    }

    @PostMapping("/sujets/cloture/{id}")
    public void cloture(@PathVariable Long id, @RequestBody String username) {sujetService.cloture(id, username);}

    @PostMapping("/sujets/cacher/{id}")
    public void cacher(@PathVariable Long id, @RequestBody String username) {sujetService.cacher(id, username);}

}
