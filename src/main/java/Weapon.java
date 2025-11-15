public class Weapon extends Item{

    // TODO: Maybe remove other subclasses and make all weapons from Weapon class, keep it simple no different skills for each weapon.

    private final int damage;
    private final String type;

    public Weapon(String name,  String type, int quantity,  int damage)
    {
        super(name, quantity);
        this.damage = damage;
        this.type = type;
    }

    int getDamage()
    {
        return damage;
    }

    String getType()
    {
        return type;
    }

    @Override
    public void displayInfo() {
        System.out.println("Weapon: " + getName() + " | Type: " + getType() + " | Damage: " + getDamage());
    }
}
