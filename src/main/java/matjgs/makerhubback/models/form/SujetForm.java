package matjgs.makerhubback.models.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import matjgs.makerhubback.models.entity.Sujet;

import java.time.LocalDate;

import java.util.Set;

@Data
public class SujetForm {
    @NotBlank
    private String titre;

    @NotBlank
    private String description;

    private Set<Long> argumentsId;
    @NotBlank
    private String userLogin;

    public Sujet toEntity(){
        Sujet sujet = new Sujet();

        sujet.setTitre(this.titre);
        sujet.setDescription(this.description);
        sujet.setDateCreation(LocalDate.now());


        return sujet;
    }
}
