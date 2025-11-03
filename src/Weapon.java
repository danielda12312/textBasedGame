public class Weapon extends Item{
    private int damage;

    public Weapon(String name, int quantity, String type, int damage)
    {
        super(name, quantity, type);
        this.damage = damage;
    }

    int getDamage()
    {
        return damage;
    }

    @Override
    public void displayInfo()
    {
        System.out.println("Weapon: " + getName() + ", Quantity: " + getQuantity() + ", Type: " + getType() + ", Damage: " + damage);
    }
}
