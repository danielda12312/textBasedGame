import java.util.Scanner;

public class CombatManager {
    private Player player;
    private Mob mob;
    private boolean finished = false;

    public CombatManager(Player player, Mob mob)
    {
        this.player = player;
        this.mob = mob;
    }

    public void handleCombatInput(String input)
    {
        if (finished) return;

        System.out.println();

        System.out.println();

        switch (input) {

            case "attack" -> {

                try {
                    int damage = player.getCurrentWeapon().getDamage() - mob.getDefence();
                    mob.takeDamage(damage);
                    System.out.println("You have dealt " + damage + " to " + mob.getName());
                    System.out.println(mob.getName() + "'s health: " + mob.getHp());
                    System.out.println();
                    GameLogic.printSeperator(30);
                } catch (NullPointerException e)
                {
                    System.out.println("You have no weapon in hands !");
                    return;
                }

                if (!mob.isAlive()) {
                    System.out.println();
                    System.out.println("You defeated " + mob.getName() + "!");
                    finished = true;
                    player.getCurrentRoom().removeMob(mob);
                    break;
                }

                System.out.println(mob.getName() + "'s turn");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                System.out.println();
                mob.attack(player);
                System.out.println(player.getName() + "'s health: " + player.getHp());

                if (!player.isAlive()) {
                    System.out.println("You died!");
                    finished = true;
                }
            }

            case "run" -> {
                System.out.println("You flee from " + mob.getName() + "!");
                finished = true;
            }

            default -> System.out.println("Invalid command!");
        }
    }

    public boolean isCombatFinished() {
        return finished;
    }

    //a function to handle a simple combat for an encounter with one mob.
    //TODO: Think of a way to make the combat more engaging and less repetitive.

}
