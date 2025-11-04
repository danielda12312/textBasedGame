public class GreatSword extends Weapon{

    public GreatSword(String name, int quantity, String type, int damage, double weight)
    {
        super(name, quantity, type, damage, weight);
    }

    @Override
    public void displayInfo() {
        System.out.println("Weapon: " + getName() + ", Quantity: " + getQuantity()
                + ", Type: " + getType() + ", Damage: " + getDamage() + ", Weight: " + getWeight() + "Kg");
    }
}
