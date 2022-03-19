package peaksoft.springsecurityexamwork.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "test1")
public class Test {
    @SequenceGenerator(name = "test_sequence",
            sequenceName = "test_seq",
            allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "test_sequence")
    private Long id;
    @Column(name ="name_test")
    private String title;
    private String duration;

    public Test( String title, String duration) {
        this.title = title;
        this.duration = duration;
    }

    @OneToMany(cascade = {MERGE,DETACH,PERSIST,REFRESH},mappedBy = "test")
     private List<User>users;
    @OneToMany(cascade = ALL,mappedBy = "test")
    private List<Question>questions;


}
