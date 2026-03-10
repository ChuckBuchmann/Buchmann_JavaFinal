package FinalProject;

// For objects I still want the player to interact with but are too big to carry around
public class StaticObject extends Item implements Interact {

	public StaticObject(String name, String takeDescription, String inspectDescription) {
		super(name, takeDescription, inspectDescription);
		// TODO Auto-generated constructor stub
	}

    @Override
    public void take(Player player, Room room, Game game) {
        System.out.println("That's way too heavy to carry.");	// Override take so nothing is added to inventory
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
