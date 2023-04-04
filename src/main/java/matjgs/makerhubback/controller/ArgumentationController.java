package matjgs.makerhubback.controller;

import matjgs.makerhubback.models.dto.ArgumentationDTO;
import matjgs.makerhubback.services.ArgumentationService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
