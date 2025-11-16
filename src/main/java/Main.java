
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        GameLogic.printHeader("THE FORGOTTEN CHAMBERS");
        GameLogic.anythingToContinue();
        GameLogic.clearConsole();

        Main game = new Main();

        game.startGame();
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);

        //Create all rooms and a player object, set the player in the first room.
        World world = new WorldBuilder().build();

        GameLogic.printHeader("CHOOSE A NAME FOR YOUR CHARACTER");
        System.out.print(">> ");
        String name = scanner.nextLine();
        Player player = new Player(100, 10, world.getStartRoom(), name);
        GameLogic.clearConsole();

        System.out.println("\nWelcome " + player.getName() + " to THE FORGOTTEN CHAMBERS.");
        GameLogic.anythingToContinue();
        GameLogic.clearConsole();

        GameLogic.initialPrint();

        while (GameLogic.isRunning()) {
            System.out.print(">> ");
            String input = scanner.nextLine();


            GameLogic.processInput(input, player);

        }
    }


}
