public class Player {
    private String name;
    private int hp;
    private Inventory inventory;

    public Player(String name, int hp)
    {
        this.name = name;
        this.hp = hp;
        this.inventory = new Inventory();
    }

    public int getHp()
    {
        return hp;
    }

    public String getName()
    {
        return name;
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
