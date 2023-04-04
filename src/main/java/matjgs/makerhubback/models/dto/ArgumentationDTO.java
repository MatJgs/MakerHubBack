package matjgs.makerhubback.models.dto;

import lombok.Data;
import matjgs.makerhubback.models.entity.Argumentation;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class ArgumentationDTO implements Serializable {
    private final Long id;
    private final LocalDate dateCreation;
    private final String argument;
    private final boolean avis;
    private final UtilisateurDTO madeBy;

    public static ArgumentationDTO toDto(Argumentation entity){
        if( entity == null )
            return null;

        return new ArgumentationDTO(
                entity.getId(),
                entity.getDateCreation(),
                entity.getArgument(),
                entity.isAvis(),
                UtilisateurDTO.toDto(entity.getArgumentBy())
        );

    }
}
