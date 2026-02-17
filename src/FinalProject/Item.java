package FinalProject;

// Realized after making Potion that the highest hierarchy in classes should probably be Item as then I can simply make
// a list of Items for player inventory

//Keeping comments mostly for myself to remind myself what stuff does - it's been a while
public abstract class Item implements Interact {

	// protected fields because eclipse yelled at me
	protected String name;
	// Descriptions for picking an item up, as not all will be obvious what they are e.g. a murky brown potion
	// and descriptions for actually inspecting an item e.g. a longer sentence describing anything important about the item
	protected String takeDescription;
	protected String inspectDescription;
	
	// Ty GPT - I need getters to access these variables from children now
	public String getName() {
	    return name.toString();
	}
	
	public String getTakeDescription() {
	    return takeDescription.toString();
	}

	public String getInspectDescription() {
	    return inspectDescription.toString();
	}

	
	// Constructor sets parameters safely
	public Item (String name, String takeDescription, String inspectDescription) {
		this.name = name;
		this.takeDescription = takeDescription;
		this.inspectDescription = inspectDescription;
	}
	
	@Override
	public void take() {
		System.out.println("You pick up " + takeDescription + ".");
	}
	
	@Override
	public void inspect() {
		System.out.println(inspectDescription);
	}
	
	// ty GPT - leaving certain methods 'blank' forces children to define their own behavior if they want to use this method
	// Makes sense as using a tool will be vastly different to using a potion
	@Override
	public abstract void use();
	
	@Override
	public abstract void read();

	@Override
	public abstract void mix();

}
