package matjgs.makerhubback.repository;

import matjgs.makerhubback.models.entity.Sujet;
import matjgs.makerhubback.models.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
}
