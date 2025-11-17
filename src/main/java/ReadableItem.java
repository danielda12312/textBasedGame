public class ReadableItem extends Item {

    private String content;

    public ReadableItem(String name, String description, String content)
    {
        super(name, description);
        this.content = content;
    }

    @Override
    public void use(Player player) {
        System.out.println(content);
    }

    @Override
    public void displayInfo() {
        System.out.println("Item: " + getName());
    }
}
