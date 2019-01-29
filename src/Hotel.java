import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Hotel {
    private int id;
    private String name;
    private int stars;
    private Coordination hotelCoordination;
    private Price minPrice;
    private String Description;
    private String picUrl;
    private Boolean bookmarked;
    private String Rules;
    private Room_List room_list;
    private static int count;
    private Comment_List commentList;




    private static final DateTimeFormatter dtf = DateTimeFormatter
            .ofPattern("yyyy/MM/dd HH:mm:ss");

//    public Hotel(User author, String content) {
//        this.author = author;
//        this.content = content;
//        LocalDateTime now = LocalDateTime.now();
//        String date = dtf.format(now);
//        this.date = date;
//        Hotel.count++;
//        this.id = count;
//    }




    public Hotel( String name, int stars, Coordination hotelCoordination, Price minPrice, String description, String picUrl, Boolean bookmarked, String rules, Room_List room_list) {
        this.name = name;
        this.stars = stars;
        this.hotelCoordination = hotelCoordination;
        this.minPrice = minPrice;
        Description = description;
        this.picUrl = picUrl;
        this.bookmarked = bookmarked;
        Rules = rules;
        this.room_list = room_list;
        commentList = new Comment_List();
        Hotel.count++;
        this.id = count;
        System.out.println(toString());
    }

    public Comment_List getCommentList() {
        return commentList;
    }


    public Room_List getRoom_list() {
        return room_list;
    }

    public void setRoom_list(Room_List room_list) {
        this.room_list = room_list;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public void setHotelCoordination(Coordination hotelCoordination) {
        this.hotelCoordination = hotelCoordination;
    }

    public void setMinPrice(Price minPrice) {
        this.minPrice = minPrice;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public void setBookmarked(Boolean bookmarked) {
        this.bookmarked = bookmarked;
    }

    public void setRules(String rules) {
        Rules = rules;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStars() {
        return stars;
    }

    public Coordination getHotelCoordination() {
        return hotelCoordination;
    }

    public Price getMinPrice() {
        return minPrice;
    }

    public String getDescription() {
        return Description;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public Boolean getBookmarked() {
        return bookmarked;
    }

    public String getRules() {
        return Rules;
    }

    public static DateTimeFormatter getDtf() {
        return dtf;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stars=" + stars +
                ", hotelCoordination=" + hotelCoordination +
                ", minPrice=" + minPrice +
                ", Description='" + Description + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", bookmarked=" + bookmarked +
                ", Rules='" + Rules + '\'' +
                ", room_list=" + room_list +
                '}';
    }
}
