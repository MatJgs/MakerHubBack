package matjgs.makerhubback.services;

import matjgs.makerhubback.models.dto.SujetDTO;
import matjgs.makerhubback.models.form.SujetForm;

import java.util.List;

public interface SujetService {

    SujetDTO getOne(Long id);

    void create(SujetForm form);

    List<SujetDTO> getAll();

    void cloture(Long id, String username);
    void cacher(Long id,String username);


}
