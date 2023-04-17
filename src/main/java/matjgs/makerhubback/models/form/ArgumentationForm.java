package matjgs.makerhubback.models.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import matjgs.makerhubback.models.entity.Argumentation;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Data
public class ArgumentationForm {
    @NotBlank
    @Length(min = 10,max = 300)
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
        argumentation.setCreatedAt(LocalDate.now().atStartOfDay());

        return argumentation;
    }
}
