package services;

import annotations.ToLog;
import lombok.extern.java.Log;
import model.Comment;
import org.springframework.stereotype.Service;

@Log
@Service
public class CommentService {

    @ToLog
    public String publishComment(Comment comment) {
        log.info("Publishing comment: " + comment.getText());
        return "SUCCESS";
    }

    public void deleteComment(Comment comment) {
        log.info("Deleting comment: " + comment.getText());
    }

    public void editComment(Comment comment) {
        log.info("Editing comment: " + comment.getText());
    }

}
