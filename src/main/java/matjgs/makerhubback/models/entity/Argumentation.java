package matjgs.makerhubback.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

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
