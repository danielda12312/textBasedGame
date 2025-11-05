public class Player {
    private String name;
    private int hp;
    private Inventory inventory;
    private Weapon currentWeapon;

    public Player(int hp)
    {
        this.name = name;
        this.hp = hp;
        this.inventory = new Inventory();
        this.currentWeapon = currentWeapon;
    }

    public int getHp()
    {
        return hp;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setCurrentWeapon(Weapon currentWeapon)
    {
        this.currentWeapon = currentWeapon;
    }

    public void pickUpItem(Item item)
    {
        System.out.println(name + " attempts to pickup " + item.getName());
        inventory.addItem(item);
    }

    public void removeItem(Item item)
    {
        System.out.println(name + " attempts to drop " + item.getName());
    }

    public void checkInventory()
    {
        System.out.println("\n" + name + "'s Inventory: ");
        inventory.displayInventory();
    }
}
