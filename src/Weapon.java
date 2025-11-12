public abstract class Weapon extends Item{
    private final int damage;
    private final double weight;
    private final String type;

    public Weapon(String name, int quantity,  int damage, double weight, String type)
    {
        super(name, quantity);
        this.damage = damage;
        this.weight = weight;
        this.type = type;
    }

    int getDamage()
    {
        return damage;
    }

    double getWeight()
    {
        return weight;
    }

    String getType()
    {
        return type;
    }


    @Override
    public abstract void displayInfo();
}
