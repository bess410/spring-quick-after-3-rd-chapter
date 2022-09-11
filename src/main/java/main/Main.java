package main;

import config.ProjectConfiguration;
import model.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;

public class Main {
    public static void main(String[] args) {
        var c = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        var cs1 = c.getBean(CommentService.class);
        Comment comment1 = new Comment();
        comment1.setText("long text");
        comment1.setAuthor("Andrey");

        Comment comment2 = new Comment();
        comment2.setText("another long text");
        comment2.setAuthor("Andrey");

        cs1.sendComment(comment1);
        cs1.sendComment(comment2);
    }
}
