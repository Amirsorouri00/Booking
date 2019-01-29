import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

public class Comment implements CommentDAO {
    private int id;
    private User author;
    private String content;
    private String date;
    private static int count;
    private static final DateTimeFormatter dtf = DateTimeFormatter
            .ofPattern("yyyy/MM/dd HH:mm:ss");

    public Comment(User author, String content) {
        this.author = author;
        this.content = content;
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now);
        this.date = date;
        Comment.count++;
        this.id = count;
    }

    public Comment(Integer id, User author, String content, String date) {
        this.id = id;
        this.author = author;
        this.content = content;
//        LocalDateTime now = LocalDateTime.now();
//        date = dtf.format(now);
        this.date = date;
        Comment.count++;
//        this.id = count;
    }

    public int getId() {
        return id;
    }

    public User getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }

    private static Comment extractUserFromResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("user_id"));
        user = user.getUser(user);
        Comment comm = new Comment(rs.getInt("id"), user, rs.getString("content"), rs.getString("date"));
        return comm;
    }

    @Override
    public Comment getComment() {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM comment WHERE id=" + this.getId());
            System.out.println("ResultSet=" + rs);
            if(rs.next())
            {
                return extractUserFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public LinkedList<Comment> getAllComments() {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM comment");
            System.out.println("ResultSet=" + rs);
            LinkedList<Comment> comms = null;
            while (rs.next())
            {
                comms.add(extractUserFromResultSet(rs));
            }
            return comms;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insertComment() {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO comment VALUES (0, ?, ?, ?)");
            ps.setInt(1, this.getAuthor().getId());
            ps.setString(2, this.getContent());
            LocalDateTime now = LocalDateTime.now();
            ps.setDate(3, null);
            int i = ps.executeUpdate();
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateComment(Comment comm) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE comment SET user_id=?, content=?, date=? WHERE id=?");
            ps.setInt(1, comm.getAuthor().getId());
            ps.setString(2, comm.getContent());
            ps.setDate(3, null);
            ps.setInt(4, this.getId());
            int i = ps.executeUpdate();
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteComment() {
        Connection connection = ConnectionFactory.getConnection();

        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM comment WHERE id=" + this.getId());
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
