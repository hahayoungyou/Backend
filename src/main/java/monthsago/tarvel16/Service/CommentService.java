package monthsago.tarvel16.Service;

import monthsago.tarvel16.Model.Comment;
import monthsago.tarvel16.Repository.CommentRepository;
import monthsago.tarvel16.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;


    public Optional<Comment> getComment(Integer num) {
        return commentRepository.findById(num);
    }

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public void deleteComment(Integer no) {
        Comment comment = commentRepository.findById(no).orElseThrow(() -> new ResourceNotFoundException("Not exist Board Data by no : [" + no + "]"));
        commentRepository.delete(comment);
    }


    public List<Comment> findCommentByBoardNo(Integer num){
        return commentRepository.findCommentByBoardNo(num);
    }


}