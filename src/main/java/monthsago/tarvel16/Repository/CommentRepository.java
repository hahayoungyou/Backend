package monthsago.tarvel16.Repository;

import monthsago.tarvel16.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    public final static String SELECT_COMMENT_BY_BOARD = ""
            + "SELECT DISTINCT * "
            + "FROM comment  "
            + "WHERE board_no = ?1 "
            +"ORDER BY comment.comment_date DESC  ";
    @Query(value = SELECT_COMMENT_BY_BOARD, nativeQuery = true)
    List<Comment> findCommentByBoardNo(final Integer num);

}