package matjgs.makerhubback.models.entity.users;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import matjgs.makerhubback.models.entity.Argumentation;
import matjgs.makerhubback.models.entity.BaseEntity;
import matjgs.makerhubback.models.entity.Sujet;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "\"user\"")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role")
@Getter
@Setter
public class Utilisateur extends BaseEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "utilisateur_id")
    private Long id;

    @Column(name = "role", nullable = false, insertable = false, updatable = false)
    private String role;
    @Column(nullable = false, unique = true)
    private String login;
    @Column(nullable = false)
    private String password;
    private String firstName;
    private String lastName;

    private String email;
    private String phone;

    private boolean enabled = true;


    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_"+role));
    }

    @Override
    public String getUsername() {
        return this.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @OneToMany(mappedBy = "sujetBy")
    private Set<Sujet> sujets = new HashSet<>();

    @OneToMany(mappedBy = "argumentBy")
    private Set<Argumentation> arguments = new HashSet<>();





}
