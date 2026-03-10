package FinalProject;

public class Potion extends Item implements Interact {
	
	
	public Potion(String name, String takeDescription, String inspectDescription) {
		super(name, takeDescription, inspectDescription);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void use() {
		System.out.println("You use the " + getTakeDescription() + "!");
	}
	
    @Override
    public void read(Player player) {
        System.out.println("The label reads: \"" + getName() + "\".");
    }
}