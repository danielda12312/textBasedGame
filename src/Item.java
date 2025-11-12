public abstract class Item {
    private final String name;
    private double quantity;



    //The constructor allows us to create an Item object in Main so we can use its attributes and methods.
    public Item(String name, double quantity)
    {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName()
    {
        return name;
    }

    public double getQuantity()
    {
        return quantity;
    }


    public abstract void displayInfo();

    public String toString() {
        return name;
    }


}
