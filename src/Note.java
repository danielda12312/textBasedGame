public class Note extends Item{
    private String content;

    public Note(String name, int quantity, String type, String content)
    {
        super(name,quantity,type);
        this.content = content;
    }

    public String getContent()
    {
        return content;
    }

    @Override
    public void displayInfo()
    {
        System.out.println("Item: " + getName() + ", Quantity: " + getQuantity() + ", Type: " + getType());
    }

    public void displayContent()
    {
        System.out.println(content);
    }
}
