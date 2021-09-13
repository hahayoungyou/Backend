package monthsago.tarvel16.controller;

import monthsago.tarvel16.Model.Comment;
import monthsago.tarvel16.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class CommentController {
    @Autowired
    private CommentService commentService;

    //create comment
    @PostMapping("/board/comment")
    public Comment createComment(@RequestBody Comment comment) {
        return commentService.createComment(comment);
    }

    //get comment by board_no
    @GetMapping("/board/comment/{num}")
    public Optional<Comment> getCommentByNum(
            @PathVariable Integer num) {
        return commentService.getComment(num);
    }

    // delete comment
    @DeleteMapping("/board/comment/{no}")
    public void deleteCommentByNo(
            @PathVariable Integer no) {
        commentService.deleteComment(no);
    }



}