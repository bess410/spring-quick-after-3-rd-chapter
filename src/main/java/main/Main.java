package main;

import config.ProjectConfiguration;
import model.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;

public class Main {

    public static void main(String[] args) {
        var c = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        var service = c.getBean(CommentService.class);

        Comment comment = new Comment();
        comment.setText("ASDF");
        comment.setAuthor("Andrey");

        service.publishComment(comment);
        service.deleteComment(comment);
        service.editComment(comment);
    }
}
