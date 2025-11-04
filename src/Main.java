public class Main {
    public static void main(String[] args) {
       Inventory inventory = new Inventory();
       //Item item1 = new Item("Apple", 4);
        Food fruit = new Food("Apple", 4,"Fruit");
       //Item item2 = new Item("Black Sword", 2, "Sword");
        GreatSword greatSword = new GreatSword("Great Sword", 1, "Sword", 45, 3.4);

        GreatAxe greatAxe = new GreatAxe("Great Axe", 1, "Axe", 55, 4.4);

       inventory.addItem(greatSword);
       inventory.addItem(fruit);
       inventory.addItem(greatAxe);
       inventory.displayInventory();

    }
}
