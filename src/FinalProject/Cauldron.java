package FinalProject;

import java.util.ArrayList;
import java.util.List;

public class Cauldron extends Container implements Interact {	// I tried reusing my container logic but I'm too tired to figure out why it doesn't work how I intend

    private List<Item> ingredients = new ArrayList<>();			// New list, I tried

    public Cauldron(String name, String takeDescription, String inspectDescription, KeyItem setKey) {
        super(name, takeDescription, inspectDescription, setKey = null);
        // TODO Auto-generated constructor stub
    }

    public void addIngredient(Item item) {
        ingredients.add(item);
        System.out.println("I mix the " + item.takeDescription + " into the cauldron.");
    }

    public boolean checkBrew() {

    	boolean hasBuckthorn = false;
        boolean hasMushroom = false;
        boolean hasGlowshroom = false;
        boolean hasNightshade = false;
        boolean hasMandrake = false;

        for (Item item : ingredients) {

            if (item.name.equals("yellowplant")) {
                hasBuckthorn = true;
            }
            
            if (item.name.equals("mushroom")) {
                hasMushroom = true;
            }
            
            if (item.name.equals("glowingmushroom")) {
                hasGlowshroom = true;
            }

            if (item.name.equals("nightshade")) {
                hasNightshade = true;
            }
            
            if (item.name.equals("mandrake")) {
                hasMandrake = true;
            }
        }
        
        // Make sure that if the player threw in any other garbage that the potion wont brew
        if (ingredients.size() == 5 && hasBuckthorn && hasMushroom && hasGlowshroom && hasNightshade && hasMandrake) {
            return true;
        }

        return false;
    }
	
}
