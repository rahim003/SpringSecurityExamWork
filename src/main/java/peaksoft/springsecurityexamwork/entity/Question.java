package peaksoft.springsecurityexamwork.entity;

import lombok.*;
import javax.persistence.*;
import java.util.List;
import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "question1")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @SequenceGenerator(name = "questions_sequence",
            sequenceName = "questions_seq",
            allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "questions_sequence")
    private Long id;
    private String questionName;

    public Question(String questionName) {
        this.questionName = questionName;
    }

    @ManyToOne(cascade = {DETACH,REFRESH,PERSIST,MERGE})
    @JoinColumn(name = "test_id")
    private Test test;
    @OneToMany(cascade = ALL,mappedBy = "question")
    private List<Variant>variants;




}
