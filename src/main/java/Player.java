import java.util.Scanner;

public class Player {
    private String name;
    private int hp;
    private Inventory inventory;
    private Weapon currentWeapon;
    private Room currentRoom;


    public Player(Room startingRoom, String name)
    {
        this.currentRoom = startingRoom;
        this.inventory = new Inventory();
        this.hp = 100;
        this.name = name;
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
