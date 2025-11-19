public class Mob extends Entity {
    private int attackDamage;
    private String mobDescription;

    public Mob(String name, int maxHp,int defence, Room currentRoom, int attackDamage, String mobDescription)
    {
        super(name,maxHp,defence,currentRoom);
        this.attackDamage = attackDamage;
        this.mobDescription = mobDescription;
    }

    public int getAttackDamage()
    {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage)
    {
        this.attackDamage = attackDamage;
    }

    public String getMobDescription()
    {
        return mobDescription;
    }

    public void attack(Entity target)
    {
        int lowerBound = attackDamage - target.getDefence();
        int upperBound = attackDamage;
        int randomInt = (int) (Math.random() * (upperBound - lowerBound + 1) + lowerBound);
        int damageDealt = Math.max(0, randomInt);
        if (damageDealt > 10)
        {
            target.takeDamage(damageDealt);
            System.out.println(getName() + " attacks " + target.getName() + " for " + damageDealt + " critical damage!");
        }else {
            target.takeDamage(damageDealt);
            System.out.println(getName() + " attacks " + target.getName() + " for " + damageDealt + " damage!");
        }
    }
}
