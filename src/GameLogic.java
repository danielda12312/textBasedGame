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
        Scanner scanner = new Scanner(System.in);
        scanner.next();
    }

    public static void setupWorld(Player player)
    {
        Room room1 = new Room("Room1", "An almost empty room with barely any light, only a desk" +
                " with a mirror attached to it and a note on the desk as well as an exit to the north.");
        player.setCurrentRoom(room1);
        System.out.print("You wake up in ");
        System.out.println(player.getCurrentRoom().getDescription());
        Dagger dagger = new Dagger("dagger", 1, "dagger", 5, 0.6);
        Food apple = new Food("apple", 1,"fruit", 10);
        room1.getRoomInventory().addItem(dagger);
        room1.getRoomInventory().addItem(apple);

        System.out.println("(For list of commands type \"commands\")");

        Room room2 = new Room("Room2", "Some room description.");
        Room room3 = new Room("Room3", "ADD DESCRIPTION");
        room1.setExit(Direction.NORTH, room2);
        room2.setExit(Direction.SOUTH, room1);
    }
}
