import java.util.LinkedList;

public interface CoordinationDAO {
    Coordination getCoordination();
    LinkedList<Coordination> getAllCoordinations();
//    User getUserByUserNameAndPassword(User user);
    boolean insertCoordination();
    boolean updateCoordination(Coordination crdin);
    boolean deleteCoordination();
}
