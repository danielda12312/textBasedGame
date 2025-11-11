import java.util.HashMap;
import java.util.Map;

public class Room {
    private String name;
    private String description;
    private Map<Direction, Room> exits = new HashMap<>();

    public Room(String name,String description)
    {
        this.description = description;
        this.name = name;
        this.exits = new HashMap<>();
    }

    public Room getExit(Direction dir)
    {
        return exits.get(dir);
    }

    public void setExit(Direction dir,Room room)
    {
        exits.put(dir, room);
    }

    public String getName()
    {
        return name;
    }

    public String getDescription() {
        return description;
    }


}
