
import java.util.Objects;
import java.util.Scanner;

public class Main {

    private boolean running = true;

    public static void main(String[] args) {

        GameLogic.printHeader("THE FORGOTTEN CHAMBERS");
        GameLogic.anythingToContinue();
        GameLogic.clearConsole();
        Main game = new Main();

        game.startGame();
    }

    public void startGame() {
        //TODO: Maybe* add an input function inside GameLogic class to handle all inputs from user.
        Scanner scanner = new Scanner(System.in);
        Player player = new Player();


        player.playerSetup();
        System.out.println("\nWelcome " + player.getName());
        GameLogic.anythingToContinue();
        GameLogic.clearConsole();


        GameLogic.setupWorld(player);


        while (running) {
            String input = scanner.nextLine();


            //TODO: finish how i can go between rooms.


            processInput(input, player);

        }
    }

    private void processInput(String input, Player player) {
        String command = input.toLowerCase().trim();


        switch (command) {
            case "look around":
                GameLogic.clearConsole();
                System.out.println("You carefully examine your surroundings and you see ");
                //Learn how to show each description based on players "Location".
                System.out.println("Room number: " + player.getCurrentRoom().getName());
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

                // learn how to make movement smarter and more dynamic.
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
            //TODO: Maybe add a case for "read note" here or just make an if else statement in game loop.
            case "pick up note":
                GameLogic.clearConsole();
                if(Objects.equals(player.getCurrentRoom().getName(), "Room1") && player.checkItem())
                {
                    player.pickUpItem(player.getNote());
                }else
                {
                    System.out.println("There is nothing to pick up");
                }
                break;
            case "read note":
                GameLogic.clearConsole();
                if(!player.checkItem()) {
                    player.getNote().displayContent();
                }else {
                    System.out.println("You dont have that item.");
                }

                break;
            default:
                System.out.println("I don't understand your command.");
                break;
        }
    }
}
