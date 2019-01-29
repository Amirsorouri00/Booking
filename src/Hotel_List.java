import java.util.LinkedList;

public class Hotel_List {
    private int id;
    private LinkedList<Hotel> hotelList;
    private static int count;

    public Hotel_List() {
        hotelList = new LinkedList<>();
        Hotel_List.count++;
        this.id = count;
    }

    public Hotel getHotel(int hotelId) {
        for (Hotel hotel : hotelList) {
            if (hotel.getId() == hotelId) {
                return hotel;
            }
        }
        return null;
    }

    public void addHotel(Hotel hotel) {
        hotelList.add(hotel);
    }

    public void removeHotel(int hotelId) {
        for (Hotel hotel : hotelList) {
            if (hotel.getId() == hotelId) {
                hotelList.remove(hotel);
            }
        }
    }

    public int getId() {
        return id;
    }

    public LinkedList<Hotel> getHotelList() {
        return hotelList;
    }

}
