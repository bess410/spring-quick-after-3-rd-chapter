package services;

import model.Comment;
import model.CommentProcessor;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private CommentProcessor processor;

    @Lookup
    public CommentProcessor getProcessor() {
        return this.processor;
    }

    public void sendComment(Comment comment) {
        CommentProcessor processor = getProcessor();
        processor.setComment(comment);
        processor.processComment();
        processor.validateComment();
        System.out.println(processor.getComment().getText());
    }

}
