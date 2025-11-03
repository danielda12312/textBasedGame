public class Main {
    public static void main(String[] args) {
       Inventory inventory = new Inventory();
       //Item item1 = new Item("Apple", 4);
        Fruit fruit = new Fruit("Apple", 4,"Fuji");
       //Item item2 = new Item("Black Sword", 2, "Sword");
        Weapon weapon = new Weapon("Black Sword", 2, "Sword", 25);

       inventory.addItem(weapon);
       inventory.addItem(fruit);
       inventory.displayInventory();

    }
}
