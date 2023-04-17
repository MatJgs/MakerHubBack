package matjgs.makerhubback.models.entity;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import matjgs.makerhubback.models.entity.users.Utilisateur;
import org.hibernate.validator.constraints.Length;

import java.util.HashSet;

import java.util.Set;

@Entity
@Getter @Setter
public class Sujet extends BaseEntity{
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="sujet_id",nullable = false)
    private Long id;

    @Column(name = "titre",nullable = false)
    @Length(min = 5,max = 50)
    private String titre;

    @Column(name = "description",nullable = false)
    @Length(min = 10,max = 300)
    private String description;


    @OneToMany(mappedBy = "sujet")
    private Set<Argumentation> argumentations = new HashSet<>();


    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur sujetBy;

    private boolean enabled;
    private boolean hidden;


}
