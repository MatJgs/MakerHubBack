package matjgs.makerhubback.models.dto;

import lombok.Data;
import matjgs.makerhubback.models.entity.Sujet;

import java.io.Serializable;
@Data
public class SujetDTO implements Serializable {
    private final Long id;
    private final String titre;
    private final String description;

    public static SujetDTO toDto(Sujet entity){
        if( entity == null )
            return null;

        return new SujetDTO(entity.getId(), entity.getTitre(), entity.getDescription());
    }

}
