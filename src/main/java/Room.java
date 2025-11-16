import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {
    private String name;
    private String description;
    private Map<Direction, Room> exits = new HashMap<>();
    private Inventory roomInventory;
    private List<Mob> mobs = new ArrayList<>();

    public Room(String name,String description)
    {
        this.description = description;
        this.name = name;
        this.exits = new HashMap<>();
        this.roomInventory = new Inventory();
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

    public Inventory getRoomInventory()
    {
        return roomInventory;
    }

    public void addMob(Mob mob)
    {
        mobs.add(mob);
    }

    public List<Mob> getMobs()
    {
        return mobs;
    }


}
