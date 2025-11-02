import java.util.ArrayList;

public class Inventory {

    //Declare a dynamic array called items.
    private ArrayList<Item> items;

    //Use a constructor to initialize items as an arrayList that serves as our inventory.
    public Inventory()
    {
        items = new ArrayList<>();
    }

    //A method to add items to the inventory.
    public void addItem(Item item)
    {
        items.add(item);
    }

    //A method to display what is inside our inventory.
    public void displayInventory() {
        for (Item item : items)
        {
            System.out.println("Item: " + item.getName() + ", Quantity: " + item.getQuantity());
        }
    }
}
