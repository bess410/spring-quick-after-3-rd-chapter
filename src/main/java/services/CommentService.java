package services;

import lombok.Data;
import model.Comment;
import proxies.CommentNotificationProxy;
import repositories.CommentRepository;

@Data
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;

    public void publishComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}
