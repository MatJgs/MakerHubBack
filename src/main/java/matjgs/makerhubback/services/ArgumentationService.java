package matjgs.makerhubback.services;

import matjgs.makerhubback.models.dto.ArgumentationDTO;
import matjgs.makerhubback.models.form.ArgumentationForm;


import java.util.List;


public interface ArgumentationService {
    List<ArgumentationDTO> getAll();
    void create(ArgumentationForm form);
}
