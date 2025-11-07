import java.util.Scanner;

public class Main {

    private boolean running = true;

    public static void main(String[] args)
    {
        Main game = new Main();
        game.startGame();
    }

    public void startGame()
    {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player(100);

        player.playerSetup();



        System.out.println("Hello " + player.getName() + ", Welcome to my first game!\n");
        System.out.println("-------------------------------------------------\n");
        System.out.println("You wake up in a dimly lit room, you look around and see a door, window and a knife on the floor.");
        System.out.println("You pick up the knife and a couple of apples laying on the desk next to the window.");
        System.out.println("What's your next move? ( for list of commands write commands )");


        while(running)
        {
            String input = scanner.nextLine();

            processInput(input, player);
        }
    }

    private void processInput(String input, Player player)
    {
        String command = input.toLowerCase().trim();
        Weapon weapon = player.getCurrentWeapon();

        switch (command)
        {
            case "look around":
                System.out.println("You carefully examine your surroundings.");
                //Learn how to show each description based on players "Location".
                break;
            case "move north":
                System.out.println("You tried to move north but hit a wall.");
                // learn how to make movement smarter and more dynamic.
                break;
            case "commands":
                System.out.println("Commands: ");
                System.out.println("1. Look around\n 2. Move north\n 3. Look around\n 4. quit\n 5. name\n 6. weapon");
                break;
            case "quit":
                running = false;
                break;
            case "name":
                System.out.println("Your name is: " + player.getName());
                break;
            case "weapon":
                if (weapon != null) {
                    System.out.println("You have a " + weapon.getName() + " in your hands.");
                }else
                {
                    System.out.println("You don't have a weapon equipped.");
                }
                break;
            default:
                System.out.println("I don't understand your command.");
                break;
        }
    }
}
