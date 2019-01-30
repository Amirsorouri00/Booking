import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

public enum Currency implements CurrencyDAO{
    EURO, DOLLOR, RIAL, DEFAULT;


    public String toString() {
        System.out.println("inside currency enum\n");

        switch (this) {
            case EURO:
                return "Euro";
            case DOLLOR:
                return "Dollor";
            case RIAL:
                return "Rial";
            default:
                return "default";
        }
    }

    public static Currency toCurrency(int id) {

        switch (id) {
            case 1:
                return Currency.EURO;
            case 2:
                return Currency.DOLLOR;
            case 3:
                return Currency.RIAL;
            default:
                return Currency.DEFAULT;
        }
    }

    public Currency getCurrency() {

        switch (this) {
            case EURO:
                return Currency.EURO;
            case DOLLOR:
                return Currency.DOLLOR;
            case RIAL:
                return Currency.RIAL;
            default:
                return Currency.DEFAULT;
        }
    }

    private static Currency extractUserFromResultSet(ResultSet rs) throws SQLException {
        Currency curr = Currency.toCurrency(rs.getInt("id"));
        return curr;
    }

//    @Override
//    public Currency getCurrency() {
//        Connection connection = ConnectionFactory.getConnection();
//        try {
//            Statement stmt = connection.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM currency WHERE name=" + this.toString());
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

    @Override
    public boolean insertCurrency() {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO currency VALUES (0, ?)");
            ps.setString(1, this.toString());
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
    public boolean updateCurrency(Currency curr) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE currency SET name=? WHERE name=?");
            ps.setString(1, curr.toString());
            ps.setString(4, this.toString());
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
    public boolean deleteCurrency() {
        Connection connection = ConnectionFactory.getConnection();

        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM currency WHERE id=" + this.getCurrency());
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
