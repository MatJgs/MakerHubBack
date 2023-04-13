package matjgs.makerhubback.models.entity.users;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("STUDENT")
public class Student extends Utilisateur {

    @Override
    public void prePersist() {
        super.prePersist();
        this.setRole("STUDENT");
    }

}
