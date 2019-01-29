import java.util.LinkedList;
import java.util.Set;

// User Data Access Object
public interface UserDao {
    User getUser(User user);
    LinkedList<User> getAllUsers();
    User getUserByUserNameAndPassword(User user);
    boolean insertUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(User user);
}