public class Main {
    public static void main(String[] args) {
        Player player = new Player("Daniel", 100);

        Food fruit = new Food("Apple", 4,"Fruit", 25);
        GreatSword greatSword = new GreatSword("Great Sword", 1, "Sword", 45, 3.4);
        GreatAxe greatAxe = new GreatAxe("Great Axe", 1, "Axe", 55, 4.4);

        player.pickUpItem(greatSword);
        player.pickUpItem(fruit);

        player.checkInventory();

    }
}
