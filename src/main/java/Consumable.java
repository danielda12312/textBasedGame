public class Consumable extends Item{

    private int healAmount;

    public Consumable(String name, String description, int healAmount)
    {
        super(name, description);
        this.healAmount = healAmount;
    }

    @Override
    public void displayInfo() {
        System.out.println("Item: " + getName() + " restores " + healAmount + " health.");
    }

    //A function that uses heal function inside player to heal.
    public void use(Player player)
    {
        player.heal(healAmount);
        System.out.println("You consume the " + getName() + " and restore " + healAmount + " HP.");
    }
}
