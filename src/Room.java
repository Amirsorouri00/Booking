import java.time.format.DateTimeFormatter;
import java.util.List;

public class Room {
    private int id;
    private String name;
    private RoomType roomType;
    private RoomStatus roomStatus;
    private int Capacity;
    private Price price;
    private String Description;
    private String picUrl;
    private String Rules;
    private static int count;




    private static final DateTimeFormatter dtf = DateTimeFormatter
            .ofPattern("yyyy/MM/dd HH:mm:ss");

    public Room(String name, RoomType roomType, RoomStatus roomStatus, int capacity, Price price, String description, String picUrl, String rules) {
        this.name = name;
        this.roomType = roomType;
        this.roomStatus = roomStatus;
        Capacity = capacity;
        this.price = price;
        Description = description;
        this.picUrl = picUrl;
        Rules = rules;
        Room.count++;
        this.id = count;
        System.out.println(toString());
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    public void setCapacity(int capacity) {
        Capacity = capacity;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
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

    public RoomType getRoomType() {
        return roomType;
    }

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public int getCapacity() {
        return Capacity;
    }

    public Price getPrice() {
        return price;
    }

    public String getDescription() {
        return Description;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public String getRules() {
        return Rules;
    }

    public static DateTimeFormatter getDtf() {
        return dtf;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", roomType=" + roomType +
                ", roomStatus=" + roomStatus +
                ", Capacity=" + Capacity +
                ", price=" + price +
                ", Description='" + Description + '\'' +
                ", picUrl=" + picUrl +
                ", Rules='" + Rules + '\'' +
                '}';
    }
}
