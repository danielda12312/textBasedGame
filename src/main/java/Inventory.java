import java.util.ArrayList;
import java.util.Objects;

public class Inventory {

    //Declare a dynamic array called items.
    private static final int maxSize = 15;
    private ArrayList<Item> items;

    //Use a constructor to initialize items as an arrayList that serves as our inventory.
    //the constructor allows us to create an inventory OBJECT in Main and use its attributes and methods.
    public Inventory()
    {
        items = new ArrayList<>();
    }

    //A method to add items to the inventory.
    public boolean addItem(Item item)
    {
        if(items.size() < maxSize) {
            items.add(item);
            return true;
        }else {
            System.out.println("Cannot add " + item.getName() + " inventory is full.");
            return false;
        }
    }

    //A method used to help in the logic of picking up the item in the while loop game. a Look up method.
    public Item getItem(String itemName)
    {
        for (Item item : items)
        {
            if(item.getName().equalsIgnoreCase(itemName))
                return item;
        }
        return null;
    }

    public void removeItem(Item item)
    {
        items.remove(item);
    }

    //A method
    //TODO: Need to make it so when i drop an item it drops in the current room the player is in.
    public void dropItem(Item item)
    {
        if(items.remove(item))
        {
            System.out.println(item.getName() + " removed from the inventory.");

        }else {
            System.out.println(item.getName() + " not found in the inventory.");

        }
    }

    //A method to display what is inside our inventory.
    public void displayInventory() {
        if(items.isEmpty())
        {
            System.out.println("Inventory is empty.");
        }else {
            for (Item item : items) {
                item.displayInfo();
            }
        }
    }

}
