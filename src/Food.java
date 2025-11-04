public class Food extends Item{
    private String type;

    public Food(String name, int quantity, String type)
    {
        super(name,quantity, type);
    }

    @Override
    public void displayInfo()
    {
        System.out.println("Food: " + getName() + ", Quantity: " + getQuantity() + ", Type: " + getType());
    }


}
