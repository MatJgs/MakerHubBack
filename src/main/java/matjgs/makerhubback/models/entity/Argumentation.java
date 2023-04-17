package matjgs.makerhubback.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import matjgs.makerhubback.models.entity.users.Utilisateur;
import org.hibernate.validator.constraints.Length;




@Entity
@Getter @Setter
public class Argumentation extends BaseEntity{
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="argumentation_id",nullable = false)
    private Long id;

    //pour ou contre
    @Column(name = "avis",nullable = false)
    private boolean avis;

    @Column(name = "argument",nullable = false)
    @Length(min = 10,max = 300)
    private String argument;

    @ManyToOne
    @JoinColumn(name = "sujet_id", nullable = false)
    private Sujet sujet;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur argumentBy;
}
