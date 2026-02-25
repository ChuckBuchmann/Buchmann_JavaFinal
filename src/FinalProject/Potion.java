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
    public void read() {
        System.out.println("The label reads: \"" + getName() + "\".");
    }
	
	// Maybe mixing would go here... could add some logic to ask for another potion and see if there are any effects
	// Sounds complicated, could be fun though
	@Override
	public void mix() {
		System.out.println("Mix this potion with what?");
	}	
}