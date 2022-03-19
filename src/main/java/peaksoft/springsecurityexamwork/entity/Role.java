package peaksoft.springsecurityexamwork.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class Role {
    @SequenceGenerator(name = "role_sequence",
            sequenceName = "role_seq",
            allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "role_sequence")
    private Long id;
    private String name;

    public Role(String name) {
        this.name = name;
    }
}
