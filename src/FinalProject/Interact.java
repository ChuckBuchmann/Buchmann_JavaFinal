package FinalProject;

// Define basic actions I want the player to be able to take in regard to the items in the game
public interface Interact {

	void take(Player player, Room currentRoom, Game game);
	void inspect();
	void use();
	void read(Player player);	
}
