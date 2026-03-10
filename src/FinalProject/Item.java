package FinalProject;

public abstract class Item implements Interact, Comparable<Item> {

	protected String name;
	protected String takeDescription; 		// Descriptions for picking an item up, as not all will be obvious what they are e.g. you pick up a murky brown potion
	protected String inspectDescription;	// and descriptions for actually inspecting an item e.g. a longer sentence describing anything important about the item
	
	// getters to access protected data
	public String getName() {
	    return name.toString();
	}
	
	public String getTakeDescription() {
	    return takeDescription;
	}

	public String getInspectDescription() {
	    return inspectDescription;
	}

	
	// Item constructor (for children only?)
	public Item (String name, String takeDescription, String inspectDescription) {
		this.name = name;
		this.takeDescription = takeDescription;
		this.inspectDescription = inspectDescription;
	}
	
	
    @Override
    public void take(Player player, Room currentRoom, Game game) {
        player.addItem(this);					// Default behavior - add item to player inventory
        currentRoom.RemoveItemFromRoom(name);	// Remove it from the room
        System.out.println("I picked up " + takeDescription + ".");	// And display the take message
        System.out.println();
    }
	
    // Check in room and inventory for item
	@Override
	public void inspect() {
		System.out.println(inspectDescription);
	}
	
	// ty GPT - leaving certain methods 'blank' forces children to define their own behavior if they want to use this method
	// Makes sense as using a tool will be vastly different to using a potion or something
	@Override
	public abstract void use();
	
	@Override
	public void read(Player player) {
		System.out.println("I can't read this.");
	}
	
	// ty GPT - this override just sets the logic for sorting alphabetically
	@Override
	public int compareTo(Item other) {
	    return this.name.compareToIgnoreCase(other.name);
	}

}
