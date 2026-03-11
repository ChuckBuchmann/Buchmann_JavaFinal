package FinalProject;

public class DeadlyObject extends Item implements Interact {

	public DeadlyObject(String name, String takeDescription, String inspectDescription) {
		super(name, takeDescription, inspectDescription);
		// TODO Auto-generated constructor stub
	}
	
    @Override
    public void take(Player player, Room currentRoom, Game game) {
      	
        player.addItem(this);					// Default behavior - add item to player inventory
        currentRoom.RemoveItemFromRoom(name);	// Remove it from the room
        System.out.println("I picked up " + takeDescription + ".");	// And display the take message
        
    	if (player.getOneFromInventory("gloves") == null) {
    		game.MURDER();	// Observe, the entire reason I had to add the Game object to my take, my all important take(), breaking EVERYTHING at once
    		
    	System.out.println("I instantly die.  Nice job.");
    	}
    }

	@Override
	public void use() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read(Player player) {
		// TODO Auto-generated method stub
		
	}
}
