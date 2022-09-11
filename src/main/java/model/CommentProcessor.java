package model;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import repositories.CommentRepository;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CommentProcessor {
    private Comment comment;

    private final CommentRepository commentRepository;

    public CommentProcessor(CommentRepository commentRepository) {
        System.out.println("CommentProcessor instance created");
        this.commentRepository = commentRepository;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Comment getComment() {
        return this.comment;
    }

    public void processComment() {
        String text = comment.getText().toUpperCase();
        System.out.println("Process comment " + text);
        comment.setText(text);
    }

    public void validateComment() {
        String substring = comment.getText().substring(comment.getText().length() / 2);
        System.out.println("Validate comment " + substring);
        comment.setText(substring);
    }
}
