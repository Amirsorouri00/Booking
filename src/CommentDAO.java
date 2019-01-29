import java.util.LinkedList;

public interface CommentDAO {
    Comment getComment();
    LinkedList<Comment> getAllComments();
    //    User getUserByUserNameAndPassword(User user);
    boolean insertComment();
    boolean updateComment(Comment comm);
    boolean deleteComment();
}
