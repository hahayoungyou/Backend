package monthsago.tarvel16.Repository;

import monthsago.tarvel16.Model.Board;
import monthsago.tarvel16.Model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.List;

public interface BoardRepository  extends JpaRepository<Board, Integer > {


    public final static String SELECT_BOARD_LIST_PAGED = ""
            + "SELECT *"
            + "FROM board "
            + "WHERE (title LIKE %?1%)"
            + "ORDER BY board.board_date DESC LIMIT ?2, ?3 ";
    @Query(value = SELECT_BOARD_LIST_PAGED, nativeQuery = true)
    List<Board> findFromTo(final String keyword,
            final Integer objectStartNum,
            final Integer objectEndNum);

    public final static String SELECT_BOARD_COUNT = ""
            + "SELECT COUNT(*)"
            + "FROM board "
            + "WHERE (title LIKE %?1% )";
    @Query(value = SELECT_BOARD_COUNT, nativeQuery = true)
    Integer findAllCount(final String keyword);


}
