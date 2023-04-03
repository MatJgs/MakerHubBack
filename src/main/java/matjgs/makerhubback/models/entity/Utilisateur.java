package matjgs.makerhubback.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "\"user\"")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "role")
@Getter
@Setter
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "utilisateur_id")
    private Long id;

//    @Column(name = "role", nullable = false, insertable = false, updatable = false)
//    private String role;
    @Column(nullable = false, unique = true)
    private String login;
    @Column(nullable = false)
    private String password;
    private String firstName;
    private String lastName;

    private String email;
    private String phone;
}
