package matjgs.makerhubback.models.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import matjgs.makerhubback.models.entity.Argumentation;

import java.time.LocalDate;

@Data
public class ArgumentationForm {
    @NotBlank
    private String argument;

    @NotNull
    private Boolean avis;

    @NotBlank
    private String userLogin;

    @NotNull
    private Long sujetId;

    public Argumentation toEntity(){
        Argumentation argumentation = new Argumentation();
        argumentation.setArgument(this.argument);
        argumentation.setAvis(this.avis);
        argumentation.setDateCreation(LocalDate.now());

        return argumentation;
    }
}
