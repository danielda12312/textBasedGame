public class Food extends Item{
    private int hpRestore;

    public Food(String name, int quantity, String type, int hpRestore)
    {
        super(name,quantity, type);
        this.hpRestore = hpRestore;
    }

    @Override
    public void displayInfo()
    {
        System.out.println("Food: " + getName() + ", Quantity: " + getQuantity() + ", Type: " + getType());
    }


}
