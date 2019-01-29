import java.util.LinkedList;

public class Room_List {
    private int id;
    private LinkedList<Room> room_list;
    private static int count;

    public Room_List() {
        room_list = new LinkedList<>();
        Room_List.count++;
        this.id = count;
    }

    public Room getRoom(int roomId) {
        for (Room room : room_list) {
            if (room.getId() == roomId) {
                return room;
            }
        }
        return null;
    }

    public void addRoom(Room room) {
        room_list.add(room);
        System.out.println("inside room list addRoom\n " + toString()+ " added");
    }

    public void removeRoom(int roomId) {
        for (Room room : room_list) {
            if (room.getId() == roomId) {
                room_list.remove(room);
            }
        }
    }

    public int getId() {
        return id;
    }

    public LinkedList<Room> getRoom_list() {
        return room_list;
    }

    @Override
    public String toString() {
        return "Room_List{" +
                "id=" + id +
                ", room_list=" + room_list +
                '}';
    }
}
