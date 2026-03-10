package FinalProject;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

	private Player player;

	// Need a getter and setter for player to use in initialization
    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }
	
	private Scanner scanner;
	private boolean gameInProgress;
	
	// Main loop of the game
	public void Run() {

	    scanner = new Scanner(System.in);
	    gameInProgress = true;

	    // TODO - message on loading the game for the first time
	    System.out.println("After a long time spent on the road, I've finally arrived at the little house hidden in the woods."
	    		+ " Well, actually, it's more like a shack.  But if my information is to be believed, I can acquire what I need from here...");
	    System.out.println();
	    player.getCurrentRoom().DescribeRoom();
	    
	    while(gameInProgress) {

	        System.out.print("> ");
	        String input = scanner.nextLine();

	        ReadInput(input);
	        
	        // TODO - player counter ++

	    }

	}
	
	// Giga-method to perform all game actions
	// Separates the command (first word) from the target (words after), casting as lower case.
	// Combines words after command with no spaces
	// e.g. 'Inspect Brown Potion' becomes [inspect] [brownpotion]
	private void ReadInput(String input) {

		Room currentRoom = player.getCurrentRoom();		
		
		String[] originalInput = input.split(" ");
	    String[] words = input.trim().toLowerCase().split(" ");
	    String command = words[0];
	    String originalSpecific = "";	// Original input to give back to the player if something goes wrong
	    String specific = "";			// Lowercase space-removed input for programmatic reference
	    
	    // Getting the unaltered noun
	    for (int i = 1; i < originalInput.length; i++) {
	    	originalSpecific += originalInput[i] + " ";
	    }
	    originalSpecific.trim();
	    
	    // Getting the lowercase no-spaced noun
	    for (int i = 1; i < words.length; i++) {
	    	specific += words[i];
	    }
	    
	    // Simple fix if player prefers to use one-letter directions
	    if (specific.equals("n")) {
	        specific = "north";
	    } else if (specific.equals("s")) {
	        specific = "south";
	    } else if (specific.equals("e")) {
	        specific = "east";
	    } else if (specific.equals("w")) {
	        specific = "west";
	    }
	    
	    
	    switch(command) {
	    
	    	//-------------------------------------
	        case "take": {
	        	
	        	Item specificItem = currentRoom.GetItemInRoom(specific);	// Check if the item exists in the current room
	        	
	        	// ty GPT for creating this unholy amalgamation for me
	            if (specificItem == null) {											// If not in room, check any open containers
	                for (Item roomItem : currentRoom.getRoomItems()) {				// items in open containers are always takable, just hidden during the room description
	                    if (roomItem instanceof Container) {						
	                    	Container container = (Container) roomItem;
	                        if (container.isLocked() == false) {
	                            for (Item innerItem : container.getContents()) {
	                                if (innerItem.getName().equalsIgnoreCase(specific)) {
	                                    specificItem = innerItem;
	                                    container.getContents().remove(innerItem);	// remove from container if found
	                                    break;
	                                }
	                            }
	                            if (specificItem != null) break;
	                        }
	                    }
	                }
	            }
	        	
	        	if (specificItem != null) {	
	        		specificItem.take(player, currentRoom, this);		// Call on the interface for actions related to items
	        		
	        	} else {
	        		System.out.println("I'm not sure what "+ originalSpecific + "is.");
	        	}
	            break;
	        }

	        //-------------------------------------
	        case "inspect": {

	            Item itemInRoom = currentRoom.GetItemInRoom(specific);
	            Item itemInInventory = player.getOneFromInventory(specific);	// Cases are in the same scope by default for some reason unless use curly brackets

	            if (itemInRoom != null) {
	                itemInRoom.inspect();
	                
	            } else if (itemInInventory != null) {
	                itemInInventory.inspect();
	                
	            } else {
	                System.out.println("I don't have a " + originalSpecific + "or see one around.");
	            }
	            break;
	        }
	        
	        //-------------------------------------
	        case "use": {
	            
	            Item itemInRoom = currentRoom.GetItemInRoom(specific);
	            Item itemInInventory = player.getOneFromInventory(specific);	// Find the item the player wants to use
	            Item usedItem = null;

	            if (itemInInventory != null) {
	            	usedItem = itemInInventory;
	            } else if (itemInRoom != null) {
	            	usedItem = itemInRoom;										// Assign it
	            } else {
	            	System.out.println("I don't have a " + originalSpecific + "or see one around.");
	                break;
	            }

	            // If the item is a KeyItem, enact unlocking logic
	            // big thanks to GPT for 90% of this code block
	            if (usedItem instanceof KeyItem) {
	                KeyItem key = (KeyItem) usedItem;

	                System.out.println("Use " + usedItem.takeDescription + " on what?");
	                String objectTarget = getFollowUpInput();					// Ask a follow-up -- what is the player trying to use the key on?
	                Item target = currentRoom.GetItemInRoom(objectTarget);		// If it's a container, cast the target as an item

	                if (target instanceof Container) {				
	                    ((Container) target).unlockContainer(key);	// Wacky GPT shenanigans, ultimately, call the unlock method in the targeted container
	                } else {
	                    Room roomToUnlock = null;					// Otherwise, check if the player is trying to unlock a room
	                    for (Room room : Initializer.allRooms) {
	                        if (room.getRoomName().equals(objectTarget)) {
	                            roomToUnlock = room;
	                            break;	// This stops the for loop, not the case - I didn't know that you could do that
	                        }
	                    }

	                    if (roomToUnlock != null) {
	                        roomToUnlock.unlockRoom(key);
	                    } else {
	                        System.out.println("I don't know what that is.");
	                    }
	                }
	            }

	            break;
	        }
	        
	        //-------------------------------------
	        case "read": {
	            
	        	Item specificItem = currentRoom.GetItemInRoom(specific);   		// first, look in the room
	            Item itemInInventory = player.getOneFromInventory(specific); 	// also check inventory (don't think I have any collectible readables but oh well)

	            // If not found directly, check inside unlocked containers in the room
	            // ty GPT for another unholy abomination
	            if (specificItem == null) {
	                for (Item roomItem : currentRoom.getRoomItems()) {
	                    if (roomItem instanceof Container) {
	                        Container container = (Container) roomItem;
	                        if (!container.isLocked()) { // only unlocked containers
	                            for (Item innerItem : container.getContents()) {
	                                if (innerItem.getName().equalsIgnoreCase(specific)) {
	                                    specificItem = innerItem;  // found it
	                                    break;
	                                }
	                            }
	                            if (specificItem != null) break;  // stop checking other containers
	                        }
	                    }
	                }
	            }

	            // Now actually read it
	            if (specificItem != null) {
	                specificItem.read(player);
	            } else if (itemInInventory != null) {
	                itemInInventory.read(player);
	            } else {
	                System.out.println("I don't have a " + originalSpecific + " or see one around.");
	            }

	            break;
	            
	        }
	            
	        //-------------------------------------
	        case "inventory":
	            
	        	ArrayList<Item> playerInventory = player.getInventory();
	        	
	        	if (playerInventory.isEmpty()) {
	        		System.out.println("I'm not carrying anything right now.");
	        	} else {
		        	System.out.println("Right now, I have:");
		        	for (Item item : playerInventory) {
		        		System.out.println(item.getTakeDescription());
		        	}	        	
		        }
	        	
	            break;
	            
	        //-------------------------------------
	        case "look":
	        	
	        	System.out.println(currentRoom.getRoomDescription());
	    	            
	            break;
	            	            
	        //-------------------------------------
	        case "move":
	            
	        	// Nested switch to deal with multiple directions
	        	switch(specific) {
	        		case "north":
	        			movePlayer(currentRoom.getNorth());
	        			break;
	        			
	        		case "south":
	        			movePlayer(currentRoom.getSouth());
	        			break;
	        			
	        		case "east":
	        			movePlayer(currentRoom.getEast());
	        			break;
	        			
	        		case "west":
	        			movePlayer(currentRoom.getWest());
	        			break;
	        			
	        			default:
	        				System.out.println("I don't know what direction " + originalSpecific + "is.");
	        	}
	        	
	            break;
	            
		        //-------------------------------------
	            // Adding ingredients to the cauldron specifically
		        case "mix": {
		        	
		            Item ingredient = player.getOneFromInventory(specific);

		            if (ingredient == null) {
		                System.out.println("I don't have that.");
		                break;
		            }
		            
		            // ty GPT
		            Item target = currentRoom.GetItemInRoom("cauldron");

		            if (target instanceof Cauldron) {

		                Cauldron cauldron = (Cauldron) target;

		                cauldron.addIngredient(ingredient);

		                player.removeItem(ingredient);

		            } else {
		                System.out.println("There's nothing here that I can use to mix a potion.");
		            }

		            break;
		        }
		            
			    //-------------------------------------
		        // The final check on a completed potion
		        case "brew": {
		        	
		        	// Make sure the cauldron is in the room
		        	Item target = currentRoom.GetItemInRoom("cauldron");

		            if (target instanceof Cauldron) {

		                Cauldron cauldron = (Cauldron) target;

		                if (cauldron.checkBrew()) {
		                    System.out.println("The potion bubbles and glows brilliantly!  I quickly collect some of the potion into my flask and beat a hasty retreat.");
		                    WINNER();
		                    System.out.println("I hurry back to the castle with my royal prize in hand.  "
		                    		+ "\nI quickly get past the guards, who know of my quest.  "
		                    		+ "\nI hurry to the throne room and burst through the doors.  "
		                    		+ "\nThe bewildered king's eye siddenly light up as he recognizes my excitement, holding the flask high in the air.  "
		                    		+ "\nI hand it to my liege and watch as he uncorks the flask and takes a good, long whiff.  "
		                    		+ "\n'That's the stuff,' he murmurs, before removing his crown.  "
		                    		+ "\nHe dabs some of the liquid on his bald head and beams with excitement.  "
		                    		+ "\nThe king is pleased!  I got his baldness potion first!  "
		                    		+ "\nMy family is richly rewarded for my perilous efforts - three shillings and a prize sow.  "
		                    		+ "\nWe'll be set for the whole winter!  "
		                    		+ "\nThis truly is the life.");
		                } else {
		                    System.out.println("The potion spews out caustic black smoke.  I can't breathe!");
		                    MURDER();
		                    System.out.println("I choke and die becuse I didn't brew the potion correctly.  Nice job.");
		                }

		            } else {
		                System.out.println("There's nothing here to brew.");
		            }

		            break;
		        }
	            
	        //-------------------------------------
	        case "help":
	        	
	        	System.out.println("I can do the following stuff:"
	        			+ "\nTake something"
	        			+ "\nInspect stuff"
	        			+ "\nUse keys on unlockable things"
	        			+ "\nRead something"
	        			+ "\nInventory the stuff im holding"
	        			+ "\nLook around"
	        			+ "\nMove somewhere (only north, south, east, and west, though)"
	        			+ "\nMix ingredients using a tool"
	        			+ "\nBrew a finished potion"
	        			+ "\nor Quit my quest."
	        			+ "\n\nHere's a free hint for the first door, you probably have to break something using something heavy...");
	            
	            break;
	            
	        //-------------------------------------
	        case "load":
	        	
	        	// TODO - figure out how to load ughhhhhhh
	        	// ALSO SAVE AAAAAA
	        	// I didn't 8(
	            
	            break;
	            
	        //-------------------------------------
	        case "quit":
	        	gameInProgress = false;
	            System.out.println("OK, just leave me here I guess.");
	            break;

	        default:
	            System.out.println("I'm not sure what that means.");
	    }
	}
		
	// Logic involving moving to a new room
	public void movePlayer(Room nextRoom) {
	    if (nextRoom == null) {		// Directions that do not have another room connected to them will be null
	        System.out.println("There's nothing important that way.");
	        return;
	    }

	    // If the Room is locked (has a key associated with it)
	    if (nextRoom.isLocked()) {
	        System.out.println("It's locked.  I'll need to find a key or look for another way in.");
	        return;
	    }

	    // Otherwise, Room is automatically unlocked and can be moved to freely
	    player.setCurrentRoom(nextRoom);									// Update the player object with the new room
	    System.out.println(player.getCurrentRoom().getRoomDescription());	// Give the new room's description
	}
	
	// Method to prompt the player for more information
	public String getFollowUpInput() {
	    System.out.print("> ");            
	    return scanner.nextLine().trim().toLowerCase();
	}
	
	// Method to MURDER THE PLAYER
	public void MURDER() {
		gameInProgress = false;
	}
	
	// Method to WIN THE PLAYER
	public void WINNER() {
		gameInProgress = false;
	}
}
