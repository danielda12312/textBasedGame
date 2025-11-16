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
}
