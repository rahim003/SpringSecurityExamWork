package peaksoft.springsecurityexamwork.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "user1")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @SequenceGenerator(name = "user_sequence",
            sequenceName = "user_seq",
            allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "user_sequence")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    private String password;


    public User(String firstName, String lastName, String email, String password, List<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role>roles=new ArrayList<>();


    @ManyToOne(cascade = {DETACH, REFRESH, MERGE, PERSIST})
    @JoinColumn(name = "test_id")
    private Test test;


    public List<GrantedAuthority> getAuthories() {
        return getAuthories();
    }
}
