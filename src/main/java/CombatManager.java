import java.util.Scanner;

public class CombatManager {
    private Player player;

    public CombatManager(Player player)
    {
        this.player = player;
    }


    //a function to handle a simple combat for an encounter with one mob.
    //TODO: Think of a way to make the combat more engaging and less repetitive.
    public void startCombat(Mob mob, Scanner scanner)
    {
        System.out.println("You encounter a " + mob.getName() + "!" );
        boolean combatRunning = true;


        while(combatRunning) {
            System.out.println("Enter a command (attack, run)");
            String input = scanner.nextLine().trim().toLowerCase();

            switch (input) {
                case "attack":
                    if(player.getCurrentWeapon() == null) {
                        System.out.println("You have no weapon in hands !");
                    } else {
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

                        if (!player.isAlive()) {
                            System.out.println("You died!");
                            combatRunning = false;
                        }
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
