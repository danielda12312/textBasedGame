public class GreatAxe extends Weapon{

    public GreatAxe(String name, int quantity, String type, int damage, double weight)
    {
        super(name, quantity, damage, weight, type);
    }


    @Override
    public void displayInfo() {
        System.out.println("Weapon: " + getName() + ", Quantity: " + getQuantity()
                + ", Type: " + getType() + ", Damage: " + getDamage() + ", Weight: " + getWeight() + "Kg");
    }
}
