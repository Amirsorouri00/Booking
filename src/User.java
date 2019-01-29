import javax.lang.model.type.NullType;
import java.sql.*;
import java.util.LinkedList;
import java.util.Set;

public class User implements UserDao {
    public void setId(int id) {
        this.id = id;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        User.count = count;
    }

    private int id;
    private String username;
    private String password;
    private String email;
    private static int count;

    public User() {
    }

    public User(String userName, String passwd) {
        this.username = userName;
        this.password = passwd;
        User.count++;
        this.id = count;
        System.out.println("Inside User Constructor. User_ID is equal to: "+ getId() +".");
        System.out.println(toString());
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String print() {
        return toString();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username=" + username +
                ", email=" + email +
                '}';
    }

    private static User extractUserFromResultSet(ResultSet rs) throws SQLException {
        User user = new User(rs.getString("name"), rs.getString("password"));
        return user;
    }

    public User getUser(User user){
        Connection connection = ConnectionFactory.getConnection();
        id = 1;
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user WHERE id=" + user.getId());
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
    public LinkedList<User> getAllUsers() {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user");
            System.out.println("ResultSet=" + rs);
            LinkedList<User> users = null;
            while (rs.next())
            {
                users.add(extractUserFromResultSet(rs));
            }
            return users;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUserByUserNameAndPassword(User user) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM user WHERE user=? AND pass=?");
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();
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
    public boolean insertUser(User user) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO user VALUES (0, ?, ?, ?)");
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
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
    public boolean updateUser(User user) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE user SET name=?, pass=?, email=? WHERE id=?");
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
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
    public boolean deleteUser(User user) {
        Connection connection = ConnectionFactory.getConnection();

        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM user WHERE id=" + this.getId());
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

}
