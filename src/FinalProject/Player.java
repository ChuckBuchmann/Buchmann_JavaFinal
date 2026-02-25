package FinalProject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* 
 * For this assignment, I thought the most logical reason this project would need to access a database is to create save states 
 * To that end, I need to make data that can be saved
 * Player will handle and track all important aspects of the player's progression, which will also make it easy to write to a DB later
 * Keys and Key-like items will be handled with simple booleans that allow a player to pass when a requirement is met (like picking up a key)
 * I'll certainly add more to this once I have a better idea of how I want to create the game, but these are some fields that I'll definitely be using in the meantime
*/

public class Player {

	private ArrayList<Item> inventory;
	
    // ****** SET ****** Dunno if I'll keep this but it could be an interesting idea to keep track of potions specifically
    private Set<Item> potionInventory;
	
	// TODO - Create a Room class...
	private String /*Room*/ currentRoom;
	
	private boolean frontDoorKey;
	private boolean ingredientCupboardKey;
	private boolean gloves;
	private boolean objectiveComplete;
	private boolean consumeDeathCap;
	
	// Long list of getters and setters for above fields
	public ArrayList<Item> getInventory() {
		return inventory;
	}
	
	public void setInventory(ArrayList<Item> inv) {
		inventory = inv;
	}
	
	// ty GPT - helper function to quickly add items to the inventory
    public void addItem(Item item) {
        inventory.add(item);
    }
	
	public String getCurrentRoom() {
		return currentRoom;
	}
	// TODO - figure out how to move rooms.  Maybe using this?
	public void setCurrentRoom(String currentRoom) {
		this.currentRoom = currentRoom;
	}		

	public boolean hasFrontDoorKey() {
		return frontDoorKey;
	}

	public void setFrontDoorKey(boolean frontDoorKey) {
		this.frontDoorKey = frontDoorKey;
	}

	public boolean hasIngredientCupboardKey() {
		return ingredientCupboardKey;
	}

	public void setIngredientCupboardKey(boolean ingredientCupboardKey) {
		this.ingredientCupboardKey = ingredientCupboardKey;
	}

	public boolean hasGloves() {
		return gloves;
	}

	public void setGloves(boolean gloves) {
		this.gloves = gloves;
	}

	public boolean hasObjectiveComplete() {
		return objectiveComplete;
	}

	public void setObjectiveComplete(boolean objectiveComplete) {
		this.objectiveComplete = objectiveComplete;
	}

	public boolean hasDeathCap() {
		return consumeDeathCap;
	}

	public void setDeathCap(boolean deathCap) {
		this.consumeDeathCap = deathCap;
	}
	// End Getters / Setters

	// Player constructor for a fresh player
    public Player() {
        this.inventory = new ArrayList<>();
        this.setPotionInventory(new HashSet<>());
        this.frontDoorKey = false;
        this.ingredientCupboardKey = false;
        this.gloves = false;
        this.objectiveComplete = false;
        this.consumeDeathCap = false;
        this.currentRoom = "Outside";
    }

    
	public Set<Item> getPotionInventory() {
		return potionInventory;
	}

	public void setPotionInventory(Set<Item> potionInventory) {
		this.potionInventory = potionInventory;
	}
	
}
