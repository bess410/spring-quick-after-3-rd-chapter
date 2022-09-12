package services;

import model.Comment;
import model.CommentProcessor;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private ObjectFactory<CommentProcessor> factory;

    public void sendComment(Comment comment) {
        CommentProcessor processor = factory.getObject();
        processor.setComment(comment);
        processor.processComment();
        processor.validateComment();
        System.out.println(processor.getComment().getText());
    }

}
