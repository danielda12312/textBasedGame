import java.util.Scanner;

public class GameLogic {
    private CombatManager combatManager;
    private GameState state = GameState.EXPLORATION;

    public GameLogic(CombatManager combatManager) {
        this.combatManager = combatManager;
    }
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

    public enum GameState {
        EXPLORATION,
        COMBAT
    }

    public void startCombat(Mob mob, Player player)
    {
        GameLogic.clearConsole();
        System.out.println("You encounter a " + mob.getName() + "!");
        System.out.println(mob.getMobDescription());

        System.out.println("Choose an action (attack, run):");

        combatManager = new CombatManager(player, mob);
        state = GameState.COMBAT;
    }

    public void handleExplorationInput(String input, Player player)
    {
        String command = input.toLowerCase().trim();
        String itemName;

        //Take input from player to pick up an item from current room
        if (input.startsWith("take ")) {
            itemName = input.substring(5).trim();
            Item itemToTake = player.getCurrentRoom().getRoomInventory().getItem(itemName);

            //TODO: add an if that takes weapon straight to hands if nothing is equipped else to inventory.

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
            itemName = input.substring(6).trim();
            Item itemToEquip = player.getInventory().getItem(itemName);

            if (itemToEquip != null) {
                player.equip(itemToEquip);
            } else {
                System.out.println("You don't have " + itemName + " in your inventory.");
            }
            return;
        }

        // Use item from consumable class (e.g. use potion -> heals the player.)
        if (input.startsWith("use "))
        {
            itemName = input.substring(4).trim();
            Item itemToUse = player.getInventory().getItem(itemName);

            if (itemToUse == null) {
                System.out.println("You don't have \"" + itemName + "\".");
                return;
            }

            if (itemToUse instanceof Consumable consumable){
                consumable.use(player);
                player.getInventory().removeItem(itemToUse);
            } else {
                System.out.println("You cant use " + itemName + ".");
            }
            return;
        }

        if (input.startsWith("read "))
        {
            itemName = input.substring(5).trim();
            Item itemToRead = player.getInventory().getItem(itemName);

            if (itemToRead == null) {
                System.out.println("You don't have \"" + itemName + "\".");
                return;
            }

            if (itemToRead instanceof ReadableItem readableItem) {
                readableItem.use(player);
            } else {
                System.out.println("You cant read " + itemName);
            }
            return;
        }

        //Check if the room the player currently is inside has a mob if yes, invoke startCombat function inside CombatManager.
        if (!player.getCurrentRoom().getMobs().isEmpty())
        {
            Mob mob = player.getCurrentRoom().getMobs().getFirst();
            startCombat(mob,player);
        }


        switch (command) {
            case "look around":
                GameLogic.clearConsole();
                System.out.println("You carefully examine your surroundings and you see ");
                System.out.println(player.getCurrentRoom().getDescription());
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
            case "go west":
                GameLogic.clearConsole();
                nextRoom = player.getCurrentRoom().getExit(Direction.WEST);
                if (player.getCurrentRoom().getExit(Direction.WEST) != null) {
                    player.setCurrentRoom(nextRoom);
                    System.out.println("You have entered: " + player.getCurrentRoom().getName());
                } else {
                    System.out.println("You cant go that way.");
                }
                break;
            case "go east":
                GameLogic.clearConsole();
                nextRoom = player.getCurrentRoom().getExit(Direction.EAST);
                if (player.getCurrentRoom().getExit(Direction.EAST) != null) {
                    player.setCurrentRoom(nextRoom);
                    System.out.println("You have entered: " + player.getCurrentRoom().getName());
                } else {
                    System.out.println("You cant go that way.");
                }
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
            case "quit":
                running = false;
                break;
            case "commands":
                GameLogic.clearConsole();
                System.out.println("Commands: ");
                System.out.println(" 1. Look around | go north/south/west/east |  commands | quit | name | weapon (in-hands) |");
                System.out.println(" 2. inventory | hp | take (item name) | equip (item name) |");
                break;
            default:
                System.out.println("Unknown command.");
                break;
        }
    }


    public void processInput(String input, Player player)
    {
        if (state == GameState.COMBAT) {
            combatManager.handleCombatInput(input);

            if (combatManager.isCombatFinished()) {
                state = GameState.EXPLORATION;
            }

            return;
        }

        // EXPLORATION MODE
        handleExplorationInput(input, player);
    }

}


