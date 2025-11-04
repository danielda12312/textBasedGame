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

        System.out.println("Welcome to my first game!");

        while(running)
        {
            System.out.println("You wake up in a dimly lit room, you see a window and a door.");

            System.out.println("What's your next move? ( for list of commands write commands )");
            String input = scanner.nextLine();

            processInput(input);

        }
    }

    private void processInput(String input)
    {
        String command = input.toLowerCase().trim();

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
                System.out.println("1. Look around\n 2. Move north\n 3. Look around\n 4. quit");
                break;
            case "quit":
                running = false;
                break;
            default:
                System.out.println("I don't your command.");
                break;
        }
    }
}
