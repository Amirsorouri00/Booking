import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

public class Bookmark implements BookmarkDAO {
    private int id;
    private String name;
    private Hotel_List hotel_list;
    private User user;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Bookmark(int id, String name,User user) {
        this.id = id;
        this.name = name;
        this.user = user;
    }

    public Bookmark(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean addtoBookmark(Hotel hotel) {

        this.hotel_list.addHotel(hotel);


        return true;
    }

    public boolean removetoBookmark(Hotel hotel) {
        this.hotel_list.removeHotel(hotel.getId());
        return true;
    }

    public Hotel_List getUserBookmark(User user){
        return this.hotel_list;
    }

    private static Bookmark extractUserFromResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("user_id"));
        Bookmark bkmark = new Bookmark(rs.getInt("id"), rs.getString("name"), user);
        return bkmark;
    }

    @Override
    public Bookmark getBookmark() {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM bookmark WHERE id=" + this.getId());
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
    public LinkedList<Bookmark> getAllBookmarks() {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM comment");
            System.out.println("ResultSet=" + rs);
            LinkedList<Bookmark> bkmarks = null;
            while (rs.next())
            {
                bkmarks.add(extractUserFromResultSet(rs));
            }
            return bkmarks;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insertBookmark() {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO bookmark VALUES (0, ?, ?, ?)");
            ps.setString(1, this.getName());
            ps.setString(2, null);
            ps.setInt(3, this.getUser().getId());
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
    public boolean updateBookmark(Bookmark bkmark) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE bookmark SET name=?, user_id=? WHERE id=?");
            ps.setString(1, bkmark.getName());
            ps.setInt(2, bkmark.getUser().getId());
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
    public boolean deleteBookmark() {
        Connection connection = ConnectionFactory.getConnection();

        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM bookmark WHERE id=" + this.getId());
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
