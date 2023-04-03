package matjgs.makerhubback.controller;

import jakarta.validation.Valid;
import matjgs.makerhubback.models.dto.SujetDTO;
import matjgs.makerhubback.models.form.SujetForm;
import matjgs.makerhubback.services.SujetService;
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



}
