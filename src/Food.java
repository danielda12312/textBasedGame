public class Food extends Item{
    private int hpRestore;

    public Food(String name, int quantity, int hpRestore)
    {
        super(name,quantity);
        this.hpRestore = hpRestore;
    }

    @Override
    public void displayInfo()
    {
        System.out.println("Food: " + getName() + ", Quantity: " + getQuantity());
    }


}
