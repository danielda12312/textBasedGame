public class Fruit extends Item{
    private String type;

    public Fruit(String name, int quantity, String type)
    {
        super(name,quantity, type);
    }

    public void displayInfo()
    {
        System.out.println("Fruit: " + getName() + ", Quantity: " + getQuantity() + ", Type: " + getType());
    }


}
