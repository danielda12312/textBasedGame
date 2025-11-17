public abstract class Entity {
    private String name;
    private int maxHp;
    private int hp;
    private int defence;
    private Room currentRoom;

    public Entity(String name, int maxHp, int defence, Room startingRoom)
    {
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.defence = defence;
        this.currentRoom = startingRoom;
    }

    public void takeDamage(int amount)
    {
        hp = Math.max(0, hp - amount);
    }

    public boolean isAlive()
    {
        return hp > 0;
    }

    public String getName()
    {
        return name;
    }

    public int getHp()
    {
        return hp;
    }

    public int getMaxHp()
    {
        return maxHp;
    }

    public int getDefence()
    {
        return defence;
    }

    public Room getCurrentRoom()
    {
        return currentRoom;
    }

    public void setHp(int hp)
    {
        this.hp = hp;
    }

    public void setCurrentRoom(Room room)
    {
        this.currentRoom = room;
    }

}
