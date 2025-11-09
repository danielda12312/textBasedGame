
import java.util.Scanner;

public class Main {

    private boolean running = true;

    public static void main(String[] args)
    {

        GameLogic.printHeader("THE FORGOTTEN CHAMBERS");
        GameLogic.anythingToContinue();
        GameLogic.clearConsole();
        Main game = new Main();

        game.startGame();
    }

    public void startGame()
    {
        //TODO: Maybe* add an input function inside GameLogic class to handle all inputs from user.
        Scanner scanner = new Scanner(System.in);
        Player player = new Player();


        player.playerSetup();
        System.out.println("\nWelcome " + player.getName());
        GameLogic.anythingToContinue();
        GameLogic.clearConsole();


        Room room1 = new Room("Room1", "An almost empty room with barely any light, only a desk" +
                " with a mirror attached to it and a note on the desk as well as an exit to the north.");
        player.setCurrentRoom(room1);
        System.out.print("You wake up in ");
        System.out.println(player.getCurrentRoom().getDescription());

        System.out.println("(For list of commands type \"commands\")");



        while(running)
        {
            String input = scanner.nextLine();


            Note note = new Note("note", 1, "paper", "The exit is to the north.");
            player.setNote(note);

            //TODO: finish how i can go between rooms.
            Room room2 = new Room("Room2", "Some room description.");
            room1.setExit(Direction.NORTH, room2);
            room2.setExit(Direction.SOUTH, room1);

            Room nextRoom = room1.getExit(Direction.NORTH);

            System.out.println("You enter: " + room2.getName());
            processInput(input, player);

        }
    }

    private void processInput(String input, Player player)
    {
        String command = input.toLowerCase().trim();


        switch (command)
        {
            case "look around":
                GameLogic.clearConsole();
                System.out.println("You carefully examine your surroundings and you see ");
                //Learn how to show each description based on players "Location".
                System.out.println("Room number: " + player.getCurrentRoom().getName());
                System.out.println(player.getCurrentRoom().getDescription());
                break;
            case "go north":
                GameLogic.clearConsole();
                System.out.println("You tried to move north but hit a wall.");
                // learn how to make movement smarter and more dynamic.
                break;
            case "commands":
                GameLogic.clearConsole();
                System.out.println("Commands: ");
                System.out.println(" 1. Look around\n 2. go north\n 3. commands\n 4. quit\n 5. name\n 6. weapon");
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
                }else
                {
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
                //TODO: Maybe add a case for "read note" here or just make an if else statement in game loop.
            case "pick up":
                GameLogic.clearConsole();
                player.pickUpItem(player.getNote());
                break;
            case "read note":
                GameLogic.clearConsole();
                player.getNote().displayContent();
                break;
            default:
                System.out.println("I don't understand your command.");
                break;
        }
    }
}
