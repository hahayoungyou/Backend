package monthsago.tarvel16.Service;

import monthsago.tarvel16.Model.Board;
import monthsago.tarvel16.Repository.BoardRepository;
import monthsago.tarvel16.exception.ResourceNotFoundException;
import monthsago.tarvel16.util.PagingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public Board createBoard(Board board) {
        return boardRepository.save(board);
    }

    public ResponseEntity<Map> getPagingBoard(Integer p_num) {
        Map result = null;

        PagingUtil pu = new PagingUtil( p_num, 5, 10); // ($1:표시할 현재 페이지, $2:한페이지에 표시할 글 수, $3:한 페이지에 표시할 페이지 버튼의 수 )
        List<Board> list = boardRepository.findFromTo(pu.getObjectStartNum(), pu.getObjectCountPerPage());

        pu.setObjectCountTotal(boardRepository.findAllCount());//findAllCount()=전체 글 수


        pu.setCalcForPaging();

        if (list == null || list.size() == 0) {
            return null;
        }

        result = new HashMap<>();
        result.put("pagingData", pu);
        result.put("list", list);
        return ResponseEntity.ok(result);
    }

    public void updateBoard(
            Integer no, Board updatedBoard) {
        Board board = boardRepository.findById(no)
                .orElseThrow(() -> new ResourceNotFoundException("Not exist Board Data by no : [" + no + "]"));
        board.setTitle(updatedBoard.getTitle());
        board.setContent(updatedBoard.getContent());

        boardRepository.save(board);
        //return ResponseEntity.ok(endUpdatedBoard);
    }

    public void deleteBoard(Integer no) {
        Board board = boardRepository.findById(no).orElseThrow(() -> new ResourceNotFoundException("Not exist Board Data by no : [" + no + "]"));

        boardRepository.delete(board);
        // Map<String, Boolean> response = new HashMap<>();
        // response.put("Deleted Board Data by id : [" + no + "]", Boolean.TRUE);

    }


    public Optional<Board> getBoard(Integer num) {
        return boardRepository.findById(num);
    }
}
