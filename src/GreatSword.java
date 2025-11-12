public class GreatSword extends Weapon{

    public GreatSword(String name, int quantity, int damage, double weight, String type)
    {
        super(name, quantity, damage, weight, type);
    }

    @Override
    public void displayInfo() {
        System.out.println("Weapon: " + getName() + ", Quantity: " + getQuantity()
               + ", Damage: " + getDamage() + ", Weight: " + getWeight() + "Kg");
    }
}
