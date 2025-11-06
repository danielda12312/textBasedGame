import java.util.Scanner;

public class Player {
    private String name;
    private int hp;
    private Inventory inventory;
    private Weapon currentWeapon;

    public Player(int hp)
    {
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

    public Weapon getCurrentWeapon()
    {
        return currentWeapon;
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

    public void playerSetup()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please choose a name for your Character: ");
        name = scanner.nextLine();
        setName(name);

        Dagger dagger = new Dagger("Dagger", 1, "dagger", 10, 0.6);
        setCurrentWeapon(dagger);
    }
}
