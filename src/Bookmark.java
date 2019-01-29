import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Bookmark {
    private int id;
    private String name;
    private Hotel_List hotel_list;
    private User user;

    public Bookmark(int id, String name,User user) {
        this.id = id;
        this.name = name;
        this.user = user;
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



}
