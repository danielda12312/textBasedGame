import java.util.Scanner;

public class Player {
    private String name;
    private int hp;
    private Inventory inventory;
    private Weapon currentWeapon;
    private Room currentRoom;


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



    public Inventory getInventory()
    {
        return inventory;
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


    public void checkInventory()
    {
        System.out.println("\n" + name + "'s Inventory: ");
        inventory.displayInventory();
    }

    //A function to set up the player when first starting the game. ( set HP and choose name )
    public void playerSetup()
    {
        Scanner scanner = new Scanner(System.in);
        GameLogic.printHeader("CHOOSE A NAME FOR YOUR CHARACTER");
        System.out.print(">> ");
        name = scanner.nextLine();
        setName(name);
        setHp(100);
    }

    // a function that allows the user to equip weapons from inventory.
    //Maybe add later unequip the current weapon and equip the one in the room instead.
    public void equip(Item item) {
        if (item instanceof Weapon) {
            currentWeapon = (Weapon) item;
            inventory.removeItem(currentWeapon);
            System.out.println("You have equipped " + currentWeapon + ".");
        } else {
            System.out.println("You can't equip " + item.getName() + ".");
        }
    }



}
