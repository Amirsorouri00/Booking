import java.sql.*;
import java.util.LinkedList;

public class Coordination implements CoordinationDAO{
    private  Integer id;
    private   double latitude;
    private   double longitude;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Coordination(double lat, double lon) {
        latitude = lat;
        longitude = lon;
        System.out.println(toString());
    }

    public Coordination(Integer id, double lat, double lon, String name) {
        latitude = lat;
        longitude = lon;
        this.id = id;
        this.name = name;
        System.out.println(toString());
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "Coordination{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    private static Coordination extractUserFromResultSet(ResultSet rs) throws SQLException {
        Coordination crdin = new Coordination(rs.getInt("id"), rs.getDouble("latitude"), rs.getDouble("longitude"), rs.getString("name"));
        return crdin;
    }

    @Override
    public Coordination getCoordination() {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM coordination WHERE id=" + this.getId());
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
    public LinkedList<Coordination> getAllCoordinations() {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM coordination");
            System.out.println("ResultSet=" + rs);
            LinkedList<Coordination> crdins = null;
            while (rs.next())
            {
                crdins.add(extractUserFromResultSet(rs));
            }
            return crdins;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insertCoordination() {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO coordination VALUES (0, ?, ?, ?)");
            ps.setDouble(1, this.getLatitude());
            ps.setDouble(2, this.getLongitude());
            ps.setString(3, this.getName());
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
    public boolean updateCoordination(Coordination crdin) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE coordination SET name=?, pass=?, email=? WHERE id=?");
            ps.setDouble(1, crdin.getLatitude());
            ps.setDouble(2, crdin.getLongitude());
            ps.setString(3, crdin.getName());
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
    public boolean deleteCoordination() {
        Connection connection = ConnectionFactory.getConnection();

        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM coordination WHERE id=" + this.getId());
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}

