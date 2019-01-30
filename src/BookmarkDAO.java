import java.util.LinkedList;

public interface BookmarkDAO {
        Bookmark getBookmark();
        LinkedList<Bookmark> getAllBookmarks();
        //    User getUserByUserNameAndPassword(User user);
        boolean insertBookmark();
        boolean updateBookmark(Bookmark article);
        boolean deleteBookmark();
}
