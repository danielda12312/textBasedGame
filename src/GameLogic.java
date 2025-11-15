import java.util.Scanner;

public class GameLogic {

    private static boolean running = true;

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

    public static void initialPrint()
    {
        System.out.println("--------------------------------------------------");
        System.out.println("|                 THE FIRST CELL                  |");
        System.out.println("--------------------------------------------------\n");
        System.out.println("You awaken on a cold stone floor. The air is damp and heavy with the scent of dust and decay.\n" +
                "Dim light filters through a crack high in the wall, revealing rough stone and faint markings.\n");

        System.out.println("From the shadows, an old man steps forward. His robes are torn, his eyes wild yet filled with knowing.\n");

        System.out.println("\"Another one awakens,\" he whispers. \"The dungeon feeds on the lost... and it seems you've been chosen.\"");
        System.out.println("\"No one remembers how they arrived here. The walls shift, the torches die, and the whispers grow louder with each passing hour.\"");
        System.out.println("\"Demons guard the exits. Puzzles lock the way. And something far older watches from beneath.\"\n");

        System.out.println("He gestures toward the desk, his voice trembling:");
        System.out.println("\"Take what you can. Every choice matters in this place.\"");
        System.out.println("\"If confusion grips you, type 'commands' — it may remind you how to survive.\"");
        System.out.println("\"Now go... before it finds us.\"\n");
    }

    public static boolean isRunning() {
        return running;
    }

    public static void processInput(String input, Player player)
    {
        String command = input.toLowerCase().trim();

        //take input from player to pick up something from current room
        if (input.startsWith("take ")) {
            String itemName = input.substring(5).trim();
            Item itemToTake = player.getCurrentRoom().getRoomInventory().getItem(itemName);

            if (itemToTake != null)
            {
                player.getCurrentRoom().getRoomInventory().removeItem(itemToTake);
                player.getInventory().addItem(itemToTake);
                System.out.println("You picked up the " + itemToTake.getName() + ".");
            }else {
                System.out.println("There is no such item here.");
            }
            return;
        }

        //Equip Weapon from inventory.
        if (input.startsWith("equip ")) {
            String itemName = input.substring(6).trim();
            Item itemToEquip = player.getInventory().getItem(itemName);

            if (itemToEquip != null) {
                player.equip(itemToEquip);
            } else {
                System.out.println("You don't have " + itemName + " in your inventory.");
            }
            return;
        }

        //TODO: Do go <DIRECTION> commands dynamically instead of switch cases.
        //TODO: Set up first simple puzzle to go to he next room. first check if i do it in while loop or in the process input function,
        //TODO: specifically the go <DIRECTION> command

        switch (command) {
            case "look around":
                GameLogic.clearConsole();
                System.out.println("You carefully examine your surroundings and you see ");
                System.out.println(player.getCurrentRoom().getDescription());
                System.out.println("");
                break;
            case "go north":
                GameLogic.clearConsole();
                Room nextRoom = player.getCurrentRoom().getExit(Direction.NORTH);
                if (player.getCurrentRoom().getExit(Direction.NORTH) != null) {
                    player.setCurrentRoom(nextRoom);
                    System.out.println("You have entered: " + player.getCurrentRoom().getName());
                } else {
                    System.out.println("You tried to move north but hit a wall.");
                }

                break;
            case "go south":
                GameLogic.clearConsole();
                nextRoom = player.getCurrentRoom().getExit(Direction.SOUTH);
                if (player.getCurrentRoom().getExit(Direction.SOUTH) != null) {
                    player.setCurrentRoom(nextRoom);
                    System.out.println("You have entered: " + player.getCurrentRoom().getName());
                } else {
                    System.out.println("You cant go that way.");
                }
                break;
            case "commands":
                GameLogic.clearConsole();
                System.out.println("Commands: ");
                System.out.println(" 1. Look around | go north/south/west/east |  commands | quit | name | weapon |");
                System.out.println(" 2. inventory | hp | take (item name) | equip (item name) |");
                break;
            case "quit":
                running = false;
                break;
            case "name":
                GameLogic.clearConsole();
                System.out.println("Your name is: " + player.getName());
                break;
            case "weapon":
                GameLogic.clearConsole();
                if (player.getCurrentWeapon() != null) {
                    System.out.println("You have a " + player.getCurrentWeapon() + " in your hands.");
                } else {
                    System.out.println("You don't have a weapon equipped.");
                }
                break;
            case "inventory":
                GameLogic.clearConsole();
                player.checkInventory();
                break;
            case "hp":
                GameLogic.clearConsole();
                int hp = player.getHp();
                System.out.println("You have " + hp + " Health.");
                break;
            default:
                System.out.println("Unknown command.");
                break;
        }
    }

}


