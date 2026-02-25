package FinalProject;

/*
 * Whipped out the documentation for this one
 * Comparable and Comparator are both used to sort objects in Java
 * The difference is that comparable defines the natural sorting of objects while comparator defines custom sorting logic, described programmatically
 * In this case, I'm using a comparable to sort my list of Item objects (player inventory) alphabetically
 * Actually, I've learned that you do need to set the sorting logic for a comparable, just that logic lives inside the class it's defined in
 * A comparator uses a separate class to decide how to sort objects
 * Not gonna pretend to know what that means exactly but I was confused on why I needed to add logic in this class to sort despite what I read
*/
public abstract class Item implements Interact, Comparable<Item> {

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
	
	// ty GPT - this override just sets the logic for sorting alphabetically
	@Override
	public int compareTo(Item other) {
	    return this.name.compareToIgnoreCase(other.name);
	}

}
