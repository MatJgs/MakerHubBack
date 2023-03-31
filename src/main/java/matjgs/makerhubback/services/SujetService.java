package matjgs.makerhubback.services;

import matjgs.makerhubback.models.dto.SujetDTO;
import matjgs.makerhubback.models.form.SujetForm;

public interface SujetService {

    SujetDTO getOne(Long id);

    void create(SujetForm form);

}
