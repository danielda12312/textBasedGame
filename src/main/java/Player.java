import java.util.Scanner;

public class Player extends Entity{
    private Inventory inventory;
    private Weapon currentWeapon;


    public Player(int maxHp, int defence, Room startingRoom, String name)
    {
        super(name, maxHp, defence, startingRoom );
        this.inventory = new Inventory();
    }

    public Weapon getCurrentWeapon()
    {
        return currentWeapon;
    }

    public Inventory getInventory()
    {
        return inventory;
    }

    public void setCurrentWeapon(Weapon currentWeapon)
    {
        this.currentWeapon = currentWeapon;
    }


    public void checkInventory()
    {
        System.out.println("\n" + getName() + "'s Inventory: ");
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
