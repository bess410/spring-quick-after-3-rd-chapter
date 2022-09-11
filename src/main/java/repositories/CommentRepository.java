package repositories;

import org.springframework.stereotype.Repository;

@Repository
public class CommentRepository {

    private int count = 0;

    public void increment() {
        count++;
    }

    public void decrement() {
        count--;
    }

    public int getCount() {
        return count;
    }
}
