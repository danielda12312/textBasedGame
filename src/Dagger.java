public class Dagger extends Weapon {
    public Dagger(String name, int quantity, double weight , int damage, String type)
    {
        super(name, quantity, damage, weight, type);
    }

    @Override
    public void displayInfo() {
        System.out.println("Weapon: " + getName() + ", Quantity: " + getQuantity()
                + ", Type: " + getType() + ", Damage: " + getDamage() + ", Weight: " + getWeight() + "Kg");
    }
}
