public abstract class Weapon extends Item{
    private final int damage;
    private final double weight;

    public Weapon(String name, int quantity, String type, int damage, double weight)
    {
        super(name, quantity, type);
        this.damage = damage;
        this.weight = weight;
    }

    int getDamage()
    {
        return damage;
    }

    double getWeight()
    {
        return weight;
    }


    @Override
    public abstract void displayInfo();
}
