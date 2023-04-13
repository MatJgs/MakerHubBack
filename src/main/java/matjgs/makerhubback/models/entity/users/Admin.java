package matjgs.makerhubback.models.entity.users;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

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
