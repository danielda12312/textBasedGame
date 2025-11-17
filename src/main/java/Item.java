public abstract class Item {
    private final String name;
    private String description;



    //The constructor allows us to create an Item object in Main so we can use its attributes and methods.
    public Item(String name, String description)
    {
        this.name = name;
        this.description = description;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }


    public abstract void displayInfo();

    public abstract void use(Player player);

    public String toString() {
        return name;
    }


}
