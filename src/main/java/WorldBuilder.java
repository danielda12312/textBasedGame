import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WorldBuilder {


    //A function to load room descriptions for resources folder.
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

        //Initialize Room objects.
        Room firstCell = new Room("The First Cell", loadDescription("first_cell"));
        Room hallway1 = new Room("Hallway - first section", loadDescription("hallway"));
        Room hallway2 = new Room("Hallway - mid section", loadDescription("hallway"));
        Room hallway3 = new Room("Hallway - last section", loadDescription("hallway"));
        Room room3 = new Room("Room3", "ADD DESCRIPTION");

        //Add rooms to the world.
        world.addRoom("firstCell", firstCell);
        world.addRoom("Hallway1", hallway1);
        world.addRoom("Hallway2", hallway2);
        world.addRoom("Hallway3", hallway3);
        world.addRoom("Room3", room3);

        //Set exits for all the rooms.
        firstCell.setExit(Direction.NORTH, hallway1);
        hallway1.setExit(Direction.SOUTH, firstCell);
        hallway1.setExit(Direction.NORTH, hallway2);

        hallway2.setExit(Direction.SOUTH, hallway1);
        hallway2.setExit(Direction.NORTH, hallway3);

        hallway3.setExit(Direction.SOUTH, hallway2);
        hallway3.setExit(Direction.WEST, room3);

        room3.setExit(Direction.EAST, hallway3);

        //Put objects to pickup inside the rooms.
        Weapon dagger = new Weapon("Bronze Dagger", "Dagger", "A weak dagger made of bronze." , 10);
        Consumable potion = new Consumable("Potion","A potion that restores health.", 10);
        ReadableItem note = new ReadableItem("note","An old dusty note", "The exit is to the north, at the end of the hallway.");

        firstCell.getRoomInventory().addItem(potion);
        firstCell.getRoomInventory().addItem(dagger);
        firstCell.getRoomInventory().addItem(note);


        // --- Later: Add mobs ---
        Mob goblin = new Mob("Goblin", 10, 5, hallway2,15,
                "A sneaky little creature with pointy ears and green skin.");
        hallway2.addMob(goblin);



        world.setStartRoom(firstCell);

        return world;
    }
}
