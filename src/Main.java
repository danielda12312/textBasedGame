
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


        String[] greetText = {
        "Hello " + player.getName() + ", Welcome to my first game!\n",
        "-------------------------------------------------\n",
        "You wake up in a dimly lit room, you look around and see a door, window and a knife on the floor.",
        "You pick up the knife and a couple of apples laying on the desk next to the window.",
        "What's your next move? ( for list of commands write commands )"
        };

        int delayMilliseconds = 1000;

        for (String text : greetText)
        {
            System.out.println(text);
            try {
                Thread.sleep(delayMilliseconds);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread interrupted during slow print.");
            }
        }


        while(running)
        {

            String input = scanner.nextLine();

            Room room1 = new Room("Room1", "An almost empty room with barely any light, only a desk" +
                    " with a mirror attached to it and a note on the desk as well as an exit to the north.");
            player.setCurrentRoom(room1);

            Room room2 = new Room("Room2", "a bad that is covered in blood next to it you see a small shelf with one drawer" +
                    "and in the corner a shadowy figure with bright eyes, it seems like it is scared of you.");

            processInput(input, player);

            player.setCurrentRoom(room2);



        }
    }

    private void processInput(String input, Player player)
    {
        String command = input.toLowerCase().trim();
        Weapon weapon = player.getCurrentWeapon();

        switch (command)
        {
            case "look around":
                System.out.println("You carefully examine your surroundings and you see ");
                //Learn how to show each description based on players "Location".
                System.out.println("Room number: " + player.getCurrentRoom().getName());
                System.out.println(player.getCurrentRoom().getDescription());
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
