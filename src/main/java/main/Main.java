package main;

import config.ProjectConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repositories.CommentRepository;
import services.CommentService;
import services.UserService;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        var c = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
        var s1 = c.getBean(CommentService.class);
        var s2 = c.getBean(UserService.class);

        Thread thread1 = new Thread(() -> {
            CommentRepository commentRepository = s1.getCommentRepository();
            for (int i = 0; i < 1000; i++) {
                commentRepository.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            CommentRepository commentRepository = s2.getCommentRepository();
            for (int i = 0; i < 1000; i++) {
                commentRepository.decrement();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(s1.getCommentRepository().getCount());
    }
}
