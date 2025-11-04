import java.util.ArrayList;

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
    public void addItem(Item item)
    {
        if(items.size() < maxSize) {
            items.add(item);
        }else {
            System.out.println("Cannot add " + item + " inventory is full.");
        }
    }

    //A method to display what is inside our inventory.
    public void displayInventory() {
        for (Item item : items)
        {
            item.displayInfo();
        }
    }
}
