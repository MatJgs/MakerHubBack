package matjgs.makerhubback.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    @JoinColumn(name = "auteur_id", nullable = false)
    private Utilisateur auteurId;
}
