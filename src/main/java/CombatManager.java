import java.util.Scanner;

public class CombatManager {
    private Player player;

    public CombatManager(Player player)
    {
        this.player = player;
    }

    public void startCombat(Mob mob, Scanner scanner)
    {
        System.out.println("You encounter a " + mob.getName() + "!" );
        boolean combatRunning = true;


        while(combatRunning) {
            System.out.println("Enter a command (attack, run)");
            String input = scanner.nextLine().trim().toLowerCase();

            switch (input) {
                case "attack":
                    int damage = player.getCurrentWeapon().getDamage() - mob.getDefence();
                    mob.takeDamage(damage);
                    System.out.println("You hit " + mob.getName() + " for " + damage + " damage.");

                    if (!mob.isAlive()) {
                        System.out.println("You defeated " + mob.getName() + "!");
                        combatRunning = false;
                        player.getCurrentRoom().removeMob(mob);
                        break;
                    }

                    mob.attack(player);

                    if(!player.isAlive())
                    {
                        System.out.println("You died!");
                        combatRunning = false;
                    }
                    break;

                case "run":
                    System.out.println("You flee from " + mob.getName() + "!");
                    combatRunning = false;
                    break;

                default:
                    System.out.println("Invalid command!");
            }
        }
    }
}
