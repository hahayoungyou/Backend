package monthsago.tarvel16.Model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "comment")
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private int idx;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "comment_date")
    private String board_date;

    @Column(name = "board_id")
    private String board_id;

    @Column(name = "comment_id")
    private String comment_id;

    @Column(name = "board_no")
    private int board_no;

    @Column(name = "views")
    private int views;
}
