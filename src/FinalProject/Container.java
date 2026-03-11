package FinalProject;

import java.util.ArrayList;
import java.util.List;

// Ingredient cupboard, but maybe also a bookshelf, or even a book...
public class Container extends StaticObject implements Interact {
	
    private List<Item> contents;
    private boolean isLocked;
    private KeyItem key;
    
	public List<Item> getContents() {
		return contents;
	}
	public void setContents(List<Item> contents) {
		this.contents = contents;
	}
    
	public boolean isLocked() {
		return isLocked;
	}
	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}
	
	public KeyItem getKey() {
		return key;
	}
	public void setKey(KeyItem key) {
		this.key = key;
	}
	 
	
	public Container(String name, String takeDescription, String inspectDescription, KeyItem setKey) {
    	super(name, takeDescription, inspectDescription);
        this.setContents(new ArrayList<>());
        this.key = setKey;
        this.isLocked = key != null; // ty GPT - if a key is associated with this container, it is automatically locked so that key may open it
    }
	
    public void addItemToContainer(Item item) {
        contents.add(item);
    }
    
    public List<Item> getContainerContents() {
        return contents;
    }
    
    public void describeContainer() {
    	
    	System.out.println("Inside" + this.name + ", I see:");
    	for (Item item : contents) {
    		System.out.println(item);
    	}
    }

    // Method to check if a given key unlocks this container
    public void unlockContainer(KeyItem usedKey) {
        if (key != null && usedKey == key) {
            isLocked = false;
            System.out.println("I unlocked the " + this.takeDescription + ".");
        } else {
            System.out.println("This doesn't unlock the " + this.takeDescription + ".");
        }
    }
    
    @Override
    public void take(Player player, Room room, Game game) {
        System.out.println("There's no need to lug that around.");
    }
    
    // Show the contents of the container if its unlocked upon player inspection
	@Override
	public void inspect() {
		System.out.println(inspectDescription);
		
		if (this.isLocked() == false) {
		    System.out.println("Inside you see:");
	
		    for (Item item : contents) {
		        System.out.println(item.takeDescription);
		    }
		}
	}
    
}
