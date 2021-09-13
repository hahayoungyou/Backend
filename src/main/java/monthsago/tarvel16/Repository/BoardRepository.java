package monthsago.tarvel16.Repository;

import monthsago.tarvel16.Model.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository  extends JpaRepository<Board, Integer> {
    public final static String SELECT_BOARD_LIST_PAGED = ""
            + "SELECT *"
            + "FROM board "
            + "ORDER BY board.board_date DESC LIMIT ?1, ?2 ";
    @Query(value = SELECT_BOARD_LIST_PAGED, nativeQuery = true)
    List<Board> findFromTo(
            final Integer objectStartNum,
            final Integer objectEndNum);

    public final static String SELECT_BOARD_COUNT = ""
            + "SELECT COUNT(*)"
            + "FROM board ";
    @Query(value = SELECT_BOARD_COUNT, nativeQuery = true)
    Integer findAllCount();
}
