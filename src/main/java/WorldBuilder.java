import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WorldBuilder {

    private String loadDescription(String fileName)
    {
        try {
            return Files.readString(Path.of( "src/main/resources/descriptions/" + fileName));
        } catch (IOException e) {
            return "No description available";
        }
    }

    //A builder function to help us build a world and put it inside a World object.
    public World build()
    {
        World world = new World();

        // TODO: Make a JSON file with all Rooms including Descriptions, names, items and exits.


        Room firstCell = new Room("The First Cell", loadDescription("first_cell"));
        Room hallway1 = new Room("Hallway - first section", loadDescription("hallway"));
        Room hallway2 = new Room("Hallway - mid section", loadDescription("hallway"));
        Room hallway3 = new Room("Hallway - last section", loadDescription("hallway"));
        Room room3 = new Room("Room3", "ADD DESCRIPTION");

        world.addRoom("firstCell", firstCell);
        world.addRoom("Hallway1", hallway1);
        world.addRoom("Hallway2", hallway2);
        world.addRoom("Hallway3", hallway3);
        world.addRoom("Room3", room3);

        firstCell.setExit(Direction.NORTH, hallway1);
        hallway1.setExit(Direction.SOUTH, firstCell);
        hallway1.setExit(Direction.NORTH, hallway2);

        hallway2.setExit(Direction.SOUTH, hallway1);
        hallway2.setExit(Direction.NORTH, hallway3);

        hallway3.setExit(Direction.SOUTH, hallway2);
        hallway3.setExit(Direction.WEST, room3);

        room3.setExit(Direction.EAST, hallway3);



        Weapon dagger = new Weapon("Bronze Dagger", "Dagger", 1 , 10);
        Food apple = new Food("apple", 1, 10);
        GeneralItem note = new GeneralItem("note", 1, "an old folded note");

        firstCell.getRoomInventory().addItem(dagger);
        firstCell.getRoomInventory().addItem(apple);
        firstCell.getRoomInventory().addItem(note);

        // --- Later: Add mobs ---
        world.setStartRoom(firstCell);

        return world;
    }
}
