public abstract class Item {
    private String name;
    private int quantity;
    private String type;


    //The constructor allows us to create an Item object in Main so we can use its attributes and methods.
    public Item(String name, int quantity, String type)
    {
        this.name = name;
        this.quantity = quantity;
        this.type = type;
    }

    public String getName()
    {
        return name;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public String getType(){
        return type;
    }

    public abstract void displayInfo();


}
