package matjgs.makerhubback.models.entity.users;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("FORMATEUR")
public class Formateur extends Utilisateur {

    @Override
    public void prePersist() {
        super.prePersist();
        this.setRole("FORMATEUR");
    }

}
