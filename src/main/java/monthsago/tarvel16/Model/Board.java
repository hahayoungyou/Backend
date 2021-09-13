package monthsago.tarvel16.Model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "board")
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private int idx;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "board_date")
    private String board_date;

    @Column(name = "id")
    private String id;

    @Column(name = "views")
    private int views;
}
