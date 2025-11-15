public class GeneralItem extends Item{

    private String itemDescription;

    public GeneralItem(String name, double quantity, String itemDescription)
    {
        super(name,quantity);
        this.itemDescription = itemDescription;
    }

    public String getItemDescription()
    {
        return itemDescription;
    }

    @Override
    public void displayInfo() {
        System.out.println("Name: " + getName() + " Quantity: " + getQuantity() + " Description: " + getItemDescription());
    }
}
