import java.util.LinkedList;

public class Bookmark_list {
    private int id;
    private LinkedList<Bookmark> bookmarkList;
    private static int count;
    private Hotel_List hotel_list;


    public Bookmark_list() {
        bookmarkList = new LinkedList<>();
        Bookmark_list.count++;
        this.id = count;
    }

    public Bookmark getBookmark(int commId) {
        for (Bookmark comm : bookmarkList) {
            if (comm.getId() == commId) {
                return comm;
            }
        }
        return null;
    }

    public void addBookmark(Bookmark bookmark) {
        bookmarkList.add(bookmark);
    }

    public void removeBookmark(int bookmarkId) {
        for (Bookmark comm : bookmarkList) {
            if (comm.getId() == bookmarkId) {
                bookmarkList.remove(comm);
            }
        }
    }

    public int getId() {
        return id;
    }

    public LinkedList<Bookmark> getBookmarkList() {
        return bookmarkList;
    }

}
