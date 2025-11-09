import java.util.Scanner;

public class Player {
    private String name;
    private int hp;
    private Inventory inventory;
    private Weapon currentWeapon;
    private Room currentRoom;
    private Note note;

    public Player()
    {
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

    public Room getCurrentRoom()
    {
        return currentRoom;
    }

    public Note getNote()
    {
        return note;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setCurrentWeapon(Weapon currentWeapon)
    {
        this.currentWeapon = currentWeapon;
    }

    public void setCurrentRoom(Room currentRoom)
    {
        this.currentRoom = currentRoom;
    }

    public void setHp(int hp)
    {
        this.hp = hp;
    }

    public void setNote(Note note)
    {
        this.note = note;
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
        GameLogic.printHeader("CHOOSE A NAME FOR YOUR CHARACTER");
        name = scanner.nextLine();
        setName(name);
        setHp(100);

        Dagger dagger = new Dagger("Dagger", 1, "dagger", 10, 0.6);
        setCurrentWeapon(dagger);
        Food apple = new Food("Apple", 2, "fuji", 10);
        inventory.addItem(apple);
    }

    public void readContent()
    {

    }
}
