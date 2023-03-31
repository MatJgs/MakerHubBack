package matjgs.makerhubback.controller;

import matjgs.makerhubback.models.dto.SujetDTO;
import matjgs.makerhubback.services.SujetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SujetController {

    private final SujetService sujetService;

    public SujetController(SujetService sujetService) {
        this.sujetService = sujetService;
    }

    @GetMapping("/sujets/{id}")
    public SujetDTO getOne(@PathVariable Long id) {
        return sujetService.getOne(id);
    }

}
