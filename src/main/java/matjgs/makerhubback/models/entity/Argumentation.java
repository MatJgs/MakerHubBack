package matjgs.makerhubback.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;
import matjgs.makerhubback.models.entity.users.Utilisateur;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;


@Entity
@Getter @Setter
public class Argumentation {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="argumentation_id",nullable = false)
    private Long id;

    //quand la personne a argumenté
    @Column(nullable = false)
    private LocalDate dateCreation;

    //pour ou contre
    @Column(name = "avis",nullable = false)
    private boolean avis;

    @Column(name = "argument",nullable = false)
    private String argument;

    @ManyToOne
    @JoinColumn(name = "sujet_id", nullable = false)
    private Sujet sujet;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur argumentBy;
}
