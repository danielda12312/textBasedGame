import java.util.Scanner;

public class GameLogic {

    public static void clearConsole()
    {
        for (int i = 0; i < 100; i++)
        {
            System.out.println();
        }
    }

    public static void printSeperator(int n)
    {
        for (int i = 0; i < n; i++)
        {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printHeader(String title)
    {
        printSeperator(30);
        System.out.println(title);
        printSeperator(30);

    }

    public static void anythingToContinue()
    {
        System.out.println("\nEnter anything to continue...");
        System.out.print(">> ");
        Scanner scanner = new Scanner(System.in);
        scanner.next();
    }

    public static void setupWorld(Player player)
    {
        String firstCellDescription;

        System.out.println("--------------------------------------------------");
        System.out.println("|                 THE FIRST CELL                  |");
        System.out.println("--------------------------------------------------\n");
        System.out.println("You awaken on a cold stone floor. The air is damp and heavy with the scent of dust and decay.\n" +
                "Dim light filters through a crack high in the wall, revealing rough stone and faint markings.\n");

        firstCellDescription =
                "A wooden desk sits in the corner, scattered with old parchments, rusted tools, and a few strange relics.\n" +
                "On its surface lie a small dagger, a half-rotten apple, and a folded note stained with time.\n" +
                "A single iron door stands to the north — locked, but not unbreakable.\n";

        Room room1 = new Room("The First Cell", firstCellDescription);
        player.setCurrentRoom(room1);
        System.out.println(player.getCurrentRoom().getDescription());

        Dagger dagger = new Dagger("dagger", 1,  0.6, 6, "dagger");
        Food apple = new Food("apple", 1, 10);
        GeneralItem note = new GeneralItem("note", 1, "an old folded note");

        room1.getRoomInventory().addItem(dagger);
        room1.getRoomInventory().addItem(apple);
        room1.getRoomInventory().addItem(note);

        //TODO: Finish the description for the next two rooms.
        //TODO: Give items to the second and third room.

        Room room2 = new Room("Room2", "Some room description.");
        Room room3 = new Room("Room3", "ADD DESCRIPTION");

        room1.setExit(Direction.NORTH, room2);
        room2.setExit(Direction.SOUTH, room1);
        room2.setExit(Direction.WEST, room3);
        room3.setExit(Direction.EAST, room2);
    }
}
