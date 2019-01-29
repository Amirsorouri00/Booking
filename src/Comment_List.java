import java.util.LinkedList;

public class Comment_List {
    private int id;
    private LinkedList<Comment> commentList;
    private static int count;

    public Comment_List() {
        commentList = new LinkedList<>();
        Comment_List.count++;
        this.id = count;
    }

    public Comment getComment(int commId) {
        for (Comment comm : commentList) {
            if (comm.getId() == commId) {
                return comm;
            }
        }
        return null;
    }

    public void addComment(Comment comment) {
        commentList.add(comment);
    }

    public void removeComment(int commentId) {
        for (Comment comm : commentList) {
            if (comm.getId() == commentId) {
                commentList.remove(comm);
            }
        }
    }

    public int getId() {
        return id;
    }

    public LinkedList<Comment> getCommentList() {
        return commentList;
    }

}
