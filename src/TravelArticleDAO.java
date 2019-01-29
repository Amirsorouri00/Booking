import java.util.LinkedList;

public interface TravelArticleDAO {
    TravelArticle getTravelArticle();
    LinkedList<TravelArticle> getAllTravelArticles();
    //    User getUserByUserNameAndPassword(User user);
    boolean insertTravelArticle();
    boolean updateTravelArticle(TravelArticle article);
    boolean deleteTravelArticle();
}
