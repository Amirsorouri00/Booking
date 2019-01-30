import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class TravelArticle implements TravelArticleDAO {
    private int id;
    private String title;
    private String Description;
    private List<String> picUrl;
    private Date createDate;

    private static final DateTimeFormatter dtf = DateTimeFormatter
            .ofPattern("yyyy/MM/dd HH:mm:ss");


    public TravelArticle(int id, String title, String description, List<String> picUrl, Date createDate) {
        this.id = id;
        this.title = title;
        Description = description;
        this.picUrl = picUrl;
        this.createDate = createDate;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setPicUrl(List<String> picUrl) {
        this.picUrl = picUrl;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return Description;
    }

    public List<String> getPicUrl() {
        return picUrl;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public static DateTimeFormatter getDtf() {
        return dtf;
    }

    private static TravelArticle extractUserFromResultSet(ResultSet rs) throws SQLException {
        TravelArticle article = new TravelArticle(rs.getInt("id"), rs.getString("title"), rs.getString("description"), null, rs.getDate("createDate"));
        return article;
    }

    @Override
    public TravelArticle getTravelArticle() {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM travel_article WHERE id=" + this.getId());
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
    public LinkedList<TravelArticle> getAllTravelArticles() {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM coordination");
            System.out.println("ResultSet=" + rs);
            LinkedList<TravelArticle> articles = null;
            while (rs.next())
            {
                articles.add(extractUserFromResultSet(rs));
            }
            return articles;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }


    @Override
    public boolean insertTravelArticle() {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO travel_article VALUES (0, ?, ?, ?, ?)");
            ps.setString(1, this.getTitle());
            ps.setString(2, this.getDescription());
            ps.setString(3, null);
            ps.setString(4, null);
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
    public boolean updateTravelArticle(TravelArticle article) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE travel_article SET name=?, pass=?, email=? WHERE id=?");
            ps.setString(1, this.getTitle());
            ps.setString(2, this.getDescription());
            ps.setString(3, null);
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
    public boolean deleteTravelArticle() {
        return false;
    }
}
