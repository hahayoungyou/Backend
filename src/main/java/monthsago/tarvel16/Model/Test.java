package monthsago.tarvel16.Model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "test")
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Test {
    @Id
    @Column(name = "number1")
    private int number1;

    @Column(name = "number2")
    private int number2;

}
