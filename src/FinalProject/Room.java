package FinalProject;

import java.util.List;

// Rooms have items - items have properties

// Remove item from list when taken

// Doors are probably booleans that prohibit progress until a condition is met

public class Room {

	private String roomName;
	private String roomDescription;
	private List<Item> roomItems;
	private boolean isLocked;
    private KeyItem key;
	
	// Any connected rooms
	private Room north;
    private Room south;
    private Room east;
    private Room west;
	
	// Getters / Setters
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	
	public List<Item> getRoomItems() {
		return roomItems;
	}
	public void setRoomItem(List<Item> roomItem) {
		this.roomItems = roomItem;
	}
	
	public String getRoomDescription() {
		
		String description = roomDescription;	// Include room description and also the notable items contained therein
		
		if (roomItems.isEmpty() == false) {
			for(Item item : roomItems) {
	            description += "\nThere is " + item.getTakeDescription() + " here.";
	        }
		}
		
		return description;
	}
	
	public void setRoomDescription(String roomDescription) {
		this.roomDescription = roomDescription;
	}
	
    public boolean isLocked() {
        return isLocked;
    }
    
	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}
	
    public void setNorth(Room room) {
    	north = room;
    }

    public void setSouth(Room room) {
    	south = room;
    }

    public void setEast(Room room) {
    	east = room;
    }

    public void setWest(Room room) {
    	west = room;
    }

    public Room getNorth() {
    	return north;
    }
    
    public Room getSouth() {
    	return south;
    }
    
    public Room getEast() {
    	return east;
    }
    
    public Room getWest() {
    	return west;
    }
	
	// End getters / setters
	
	// Constructor
	public Room(String setRoomName, String setRoomDescription, List<Item> setRoomItem, KeyItem setKey) {
		this.roomName = setRoomName;
		this.roomDescription = setRoomDescription;
		this.roomItems = setRoomItem;
		this.key = setKey;
        this.isLocked = key != null; // Room is locked automatically if a key for it exists
	}
	
    // Method to check if a given key unlocks this container
    public void unlockRoom(KeyItem usedKey) {
        if (key != null && usedKey == key) {
            isLocked = false;
            System.out.println("I unlocked the " + this.roomName + ".");
        } else {
            System.out.println("This doesn't unlock the " + this.roomName + ".");
        }
    }
	
	// Get a specific item in a room if it exists
	// Then, call actions using that item's methods (inspect, use, etc.)
	public Item GetItemInRoom (String itemName) {
		
	    for(Item item : roomItems) {
	        if(item.getName().equalsIgnoreCase(itemName)) {
	            return item;
	        }
	    }
		
		return null;
	}
	
	// Remove an item from a room
	public void RemoveItemFromRoom (String itemName) {
		
		Item removeItem = null;
		
		for(Item item : roomItems) {
	        if(item.getName().equalsIgnoreCase(itemName)) {
	        	removeItem = item;
	        }
	    }
		
		if (removeItem != null) {
			roomItems.remove(removeItem);
		}
	}
	
	public void DescribeRoom() {
	    
	    System.out.println(roomDescription);
	    
	    for (Item item : roomItems) {
	        System.out.println();
	        System.out.println("There is " + item.takeDescription + ".");
	    }

	    System.out.println();
	}
}
