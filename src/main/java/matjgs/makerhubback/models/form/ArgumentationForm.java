package matjgs.makerhubback.models.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import matjgs.makerhubback.models.entity.Argumentation;
import matjgs.makerhubback.models.entity.Sujet;

import java.time.LocalDate;

@Data
public class ArgumentationForm {
    @NotBlank
    private String argument;

    @NotBlank
    private boolean avis;

    public Argumentation toEntity(){
        Argumentation argumentation = new Argumentation();
        argumentation.setArgument(this.argument);
        argumentation.setAvis(this.avis);
        argumentation.setDateCreation(LocalDate.now());

        return argumentation;
    }
}
