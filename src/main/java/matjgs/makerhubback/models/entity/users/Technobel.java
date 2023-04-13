package matjgs.makerhubback.models.entity.users;

public class Technobel extends Utilisateur {

    @Override
    public void prePersist() {
        super.prePersist();
        this.setRole("TECHNOBEL");
    }

}

