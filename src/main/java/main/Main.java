package main;

import config.ProjectConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;
import services.UserService;

public class Main {
    public static void main(String[] args) {
        var c = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
        var s1 = c.getBean(CommentService.class);
        var s2 = c.getBean(UserService.class);
        System.out.println(s1.getCommentRepository() == s2.getCommentRepository());
    }
}
