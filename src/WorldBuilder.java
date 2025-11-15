public class WorldBuilder {

    //A builder function to help us build a world and put it inside a World object.
    public World build()
    {
        World world = new World();

        String firstCellDescription =
                "A wooden desk sits in the corner, scattered with old parchments, rusted tools, and a few strange relics.\n" +
                        "On its surface lie a small dagger, a half-rotten apple, and a folded note stained with time.\n" +
                        "A single iron door stands to the north — locked, but not unbreakable.\n";

        Room room1 = new Room("The First Cell", firstCellDescription);
        Room room2 = new Room("Room2", "Some room description.");
        Room room3 = new Room("Room3", "ADD DESCRIPTION");

        world.addRoom("First cell", room1);
        world.addRoom("Room2", room2);
        world.addRoom("Room3", room3);

        room1.setExit(Direction.NORTH, room2);
        room2.setExit(Direction.SOUTH, room1);
        room2.setExit(Direction.WEST, room3);
        room3.setExit(Direction.EAST, room2);

        Dagger dagger = new Dagger("dagger", 1,  0.6, 6, "dagger");
        Food apple = new Food("apple", 1, 10);
        GeneralItem note = new GeneralItem("note", 1, "an old folded note");

        room1.getRoomInventory().addItem(dagger);
        room1.getRoomInventory().addItem(apple);
        room1.getRoomInventory().addItem(note);

        // --- Later: Add mobs ---
        world.setStartRoom(room1);

        return world;
    }
}
