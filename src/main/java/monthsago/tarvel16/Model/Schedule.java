package monthsago.tarvel16.Model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "schedules")
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "startdate")
    private String startdate;

    @Column(name = "enddate")
    private String enddate;

    @Column(name = "alldat")
    private String alldat;

}
