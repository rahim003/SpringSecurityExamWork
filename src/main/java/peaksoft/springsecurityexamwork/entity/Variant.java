package peaksoft.springsecurityexamwork.entity;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "variant1")
@Getter
@Data
@NoArgsConstructor
@Setter
@AllArgsConstructor
public class Variant {
    @SequenceGenerator(name = "variant_sequence",
            sequenceName = "variant_seq",
            allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "variant_sequence")
    private Long id;
    private String variantName;
    private boolean answer = false;

    public Variant(String variantName, boolean answer) {
        this.variantName = variantName;
        this.answer = answer;
    }

    @ManyToOne(cascade = {DETACH, MERGE, PERSIST, REFRESH})
    @JoinColumn(name = "question_id")
    private Question question;
}
