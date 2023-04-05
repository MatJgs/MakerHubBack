package matjgs.makerhubback.controller;

import jakarta.validation.Valid;
import matjgs.makerhubback.models.dto.ArgumentationDTO;
import matjgs.makerhubback.models.form.ArgumentationForm;
import matjgs.makerhubback.models.form.SujetForm;
import matjgs.makerhubback.services.ArgumentationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ArgumentationController {

    private final ArgumentationService argumentationService;

    public ArgumentationController(ArgumentationService argumentationService) {
        this.argumentationService = argumentationService;
    }

    @GetMapping("/arguments")
    public List<ArgumentationDTO> getAll(){
        return argumentationService.getAll();
    }

    @PostMapping("/sujets/arguments/new/{id}")
    public void create(@RequestBody @Valid ArgumentationForm form){
        argumentationService.create(form);
    }
}
