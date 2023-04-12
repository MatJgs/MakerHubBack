package matjgs.makerhubback.models.entity.users;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import matjgs.makerhubback.models.entity.Utilisateur;

@Entity
@DiscriminatorValue("ADMIN")
@Getter
@Setter
public class Admin extends Utilisateur {
    @Override
    public void prePersist() {
        super.prePersist();
        this.setRole("ADMIN");
    }
}
