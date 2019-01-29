import com.mysql.jdbc.Driver;

import java.sql.*;

/**
 * Connect to Database
 * @author hany.said
 */
public class ConnectionFactory {
    public static final String URL = "jdbc:mysql://localhost:3306/test_db";
    public static final String USER = "root";
    public static final String PASS = "123456";
    /**
     * Get a connection to database
     * @return Connection object
     */
    public static Connection getConnection()
    {
        try {
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }
    /**
     * Test Connection
     */

//    private static User extractUserFromResultSet(ResultSet rs) throws SQLException {
//        User user = new User(rs.getString("name"), rs.getString("password"));
//        return user;
//    }
//
//
//    public static User getUser(int id) {
//        Connection connection = ConnectionFactory.getConnection();
//        try {
//            Statement stmt = connection.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE id=" + id);
//            System.out.println("ResultSet=" + rs);
//            if(rs.next())
//            {
//                return extractUserFromResultSet(rs);
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return null;
//    }


    public static void main(String[] args) {
//        Connection connection = ConnectionFactory.getConnection();
//        User user = (User) ConnectionFactory.getUser(1);
//        System.out.println(user);
          System.out.println("Connection Factory already tested.");

    }
}