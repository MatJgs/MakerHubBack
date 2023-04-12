package matjgs.makerhubback.models.dto;

import lombok.Data;
import matjgs.makerhubback.models.entity.Utilisateur;

import java.io.Serializable;

@Data
public class UtilisateurDTO implements Serializable {
    private final Long id;
    private final String role;
    private final String firstName;
    private final String lastName;
    private final String email;

    public static UtilisateurDTO toDto(Utilisateur entity){
        if(entity==null)
            return null;
        return new UtilisateurDTO(
                entity.getId(),
                entity.getRole(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getEmail()
        );
    }

}
