package FinalProject;

//import java.util.HashSet;
//import java.util.Set;
//import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    	Game game = new Game();
    	
    	Initializer.InitializeGame(game);
    	
    	game.Run();
    	
    	
    	
    	
    	/*
        DatabaseManager.createTables();
        
        Player you = new Player();
        DatabaseManager.savePlayer(you);
        
        you = DatabaseManager.loadPlayer();
        
        System.out.println("\n");
        
        // Create some dummy potions
        Potion HealingPotion = new Potion("Healing Potion", "a red vial", "Opaque red liquid");
        Potion ManaPotion = new Potion("Mana Potion", "a blue vial", "Bright blue liquid");
        
        // Put them in a set
        Set<Item> PotionSet = new HashSet<>();
        
        PotionSet.add(HealingPotion);
        PotionSet.add(ManaPotion);
        PotionSet.add(HealingPotion); // Try adding a duplicate (sets automatically ignore these)
        
        you.setPotionInventory(PotionSet);

        System.out.println("Set contains:");
        for (Item item : you.getPotionInventory()) {
            System.out.println(item.getName());
        }
        */
        
    }
}