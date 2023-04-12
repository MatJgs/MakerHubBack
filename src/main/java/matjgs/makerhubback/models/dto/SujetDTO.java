package matjgs.makerhubback.models.dto;

import lombok.Data;
import matjgs.makerhubback.models.entity.Argumentation;
import matjgs.makerhubback.models.entity.Sujet;
import matjgs.makerhubback.models.entity.Utilisateur;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class SujetDTO implements Serializable {
    private final Long id;
    private final String titre;
    private final String description;
    private final UtilisateurDTO madeBy;
    private final LocalDate dateCreation;
    private final Set<ArgumentationDTO> argumentations;

    public static SujetDTO toDto(Sujet entity){
        if( entity == null )
            return null;

        return new SujetDTO(
                entity.getId(),
                entity.getTitre(),
                entity.getDescription(),

                UtilisateurDTO.toDto(entity.getSujetBy()),
                entity.getDateCreation(),
                entity.getArgumentations().stream()
                        .map(ArgumentationDTO::toDto)
                        .collect(Collectors.toSet())
        );
    }


    @Data
    public static class ArgumentationDTO {
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



}
