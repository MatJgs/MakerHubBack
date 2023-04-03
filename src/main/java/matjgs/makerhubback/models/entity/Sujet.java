package matjgs.makerhubback.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter @Setter
public class Sujet {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="sujet_id",nullable = false)
    private Long id;

    @Column(nullable = false)
    private LocalDate dateCreation;

    @Column(name = "titre",nullable = false)
    private String titre;

    @Column(name = "description",nullable = false)
    private String description;


    @OneToMany
    private Set<Argumentation> argumentations = new HashSet<>();

//    @ManyToOne
//    @JoinColumn(name = "made_by_id", nullable = false)
//    private Utilisateur madeBy;
}
