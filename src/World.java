import java.util.HashMap;
import java.util.Map;

//This class's object will hold everything created within the WorldBuilder class with the build function
public class World {
    private Room startRoom;
    private Map<String, Room> rooms = new HashMap<>();

    public void addRoom(String id, Room room)
    {
        rooms.put(id, room);
    }

    public Room getRoom(String id)
    {
        return rooms.get(id);
    }

    public void setStartRoom(Room room)
    {
        this.startRoom = room;
    }

    public Room getStartRoom()
    {
        return startRoom;
    }
}
