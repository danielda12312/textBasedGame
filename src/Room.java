import java.util.HashMap;

public class Room {
    private final String name;
    private final String description;
    private final HashMap<Direction, Room> exits = new HashMap<>();

    public Room(String name,String description)
    {
        this.description = description;
        this.name = name;
    }

    public Room getExit(Direction dir)
    {
        return exits.get(dir);
    }

    public String getName()
    {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
