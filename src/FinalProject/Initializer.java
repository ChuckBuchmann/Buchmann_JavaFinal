package FinalProject;

import java.util.ArrayList;
import java.util.List;

public class Initializer {
	
	public static List<Room> allRooms = new ArrayList<>();	// List of all rooms to compare against for unlocking rooms
	
    public static void InitializeGame(Game game) {
    	
    	//-------------------------------------
    	// KEYS
    	//-------------------------------------
    	
    	KeyItem acidVial = new KeyItem(
    		    "vial",
    		    "a small vial of murky brown liquid",
    		    "The liquid inside the vial smokes slightly and it gives off an acrid stench.  Maybe it's corrosive.");
    	
    	KeyItem bookshelfKey = new KeyItem(
    		    "smallkey",		// TODO - Guide the player to this object's name
    		    "a small key",
    		    "A key that was hidden inside the pages of a book.");
    	
    	KeyItem statue = new KeyItem(
    			"statue",
    			"a heavy statue",
    			"It's an ugly little statue of some evil-looking creature with a red cap and a nasty grin.  It looks to be made of porcelain and is quite heavy.  I hate it.");
    	
    	
    	//-------------------------------------
    	// NORMAL INGREDIENTS / READABLES
    	//-------------------------------------
    	
    	NormalObject buckthorn = new NormalObject(
    			"yellowplant",
    			"a tall plant with yellow seeds",
    			"I've seen this plant before.  It normally grows in the wild, but it's here being grown intentionally in a planter.");
    	
    	NormalObject mandrakeRoot = new NormalObject(
    		    "mandrake",
    		    "a twisted mandrake root",
    		    "The root vaguely resembles a screaming face.");

    	NormalObject glowingMushroom = new NormalObject(
    		    "glowingmushroom",
    		    "a glowing cave mushroom",
    		    "The mushroom glows with a faint blue light.");
    	
		Readable sword = new Readable(
			    "sword",
			    "",
			    "The yellow book looks pretty dusty.  There's a dominating depiction of excalibur on the front",
			    "'Chapter 1: On holding a sword...'  A beginner's manual?  Lame.  I wanted to learn some cool moves.");
		
		Readable goblins = new Readable(
			    "goblins",
			    "",
			    "The green book gives no indication of its contents save for a gigantic bolded GOLBINS on the front and spine.",
			    "Flipping through it, its about some wackjob warlock who lived with a goblin tribe for a couple months.  Who reads this crap?");
		
		TrickBook redBook = new TrickBook(
			    "redbook",
			    "",
			    "It's a simple red book with no outwardly discernable features.  It doesn't have a title on the spine or cover",
			    "The pages are blank.",
			    bookshelfKey);

    	
    	//-------------------------------------
    	// DEADLY INGREDIENTS / OBJECTS
    	// TODO - make player DIE if they touch these without gloves
    	// Except spider.  Don't touch the spider
    	// TODO - make the spider deadly no matter what
    	//-------------------------------------
    	
    	DeadlyObject nightshade = new DeadlyObject(
    		"nightshade",
    		"a cluster of dark purple berries",
        	"Deadly nightshade berries.  Everyone is taught not to mess with this plant as children - better not touch it with my bare hands.");
    	
    	DeadlyObject spottedMushroom = new DeadlyObject(
    		"mushroom",
    		"a small mushroom with brown spots",
    		"This mushroom is stubby but short, and looks very appetizing.  I almost want to eat it.");
    	
    	DeadlyObject spider = new DeadlyObject(
    		"spider",
    		"a large spider",
    		"It's hard to make out in the gloom of the cellar, but does that spider have a skull on its abdomen?  A sudden urge to leave takes over me, but I fight it back.  Creepy ass spider.");
    			
    	//-------------------------------------
    	// STATIC OBJECTS
    	//-------------------------------------

		Cauldron cauldron = new Cauldron(
		    "cauldron",
		    "a massive iron cauldron",
		    "A black iron cauldron large enough to mix potions in.  It looks like it already has some water inside.  Once I've I'm happy with the mixture, I can brew the result into my flask.",
		    null);
		
		Readable alchemyTome = new Readable(
		    "tome",
		    "a massive leather-bound tome",
		    "The book on the table is huge and imposing.  It is covered in ink blotches and has an unsettling sigil on its cover.",
		    
		    // Readable passage
		    " I heasitantly open the gigantic book and begin rifling through its pages..."
		    + " I found it!  This passage details a potion with the effects that I need!"
		    + " Hmm... I need to mix buckthorn, deathcap, glowing wyrm tongue, mandrake root, and nightshade."
		    + " Jeez, where am I gonna find all that crap?"
		    + " It says buckthorn is a tall plant with yellow seeds.  I saw that in the garden outside."
		    + " Deathcap is an unassuming spotted brown mushroom - WARNING DO NOT TOUCH, it says."
		    + " Glowing wyrm tongue apparently grows in the deepest recesses of our world."
		    + " I already know what nightshade is."
		    + " It doesn't mention mandrake root.  I hope its around here somewhere.");
		
		//-------------------------------------
		// CONTAINERS
		//-------------------------------------

		Container ingredientCupboard = new Container(
		    "cupboard",
		    "a dark cupboard",
		    "A dark wooden cupboard with a tiny keyhole on one side.  It has a rich scent of herbs and something tangy.",
		    bookshelfKey);

		Container gloveChest = new Container(
		    "chest",
		    "a small wooden chest",
		    "A small chest sitting beside the desk.  It's locked with a large rusty padlock.  It looks like it could fall apart at any moment, maybe if I had something...",
		    acidVial);

		Container bookshelf = new Container(
		    "bookshelf",
		    "a tall wooden bookshelf",
		    "Three books sit on the shelf next to on another.  the left is yellow and simply titled 'Sword,' the middle is a green book titled 'Golbins,' and the third book is red with no visible title on the spine.",
		    null);
		
		//-------------------------------------
		// CONTAINER CONTENTS
		//-------------------------------------

		ingredientCupboard.getContents().add(mandrakeRoot);
		ingredientCupboard.getContents().add(nightshade);

		gloveChest.getContents().add(
		    new NormalObject(
		        "gloves",
		        "a pair of thick leather gloves",
		        "These are a pair of heavy leather gloves that can protect my hands from all sorts of nasties."));

		bookshelf.getContents().add(sword);
		bookshelf.getContents().add(goblins);
		bookshelf.getContents().add(redBook);
		// TODO - add the other books - also name the books appropriately
	
		//-------------------------------------
		// OUTSIDE FRONT DOOR ITEMS
		//-------------------------------------

		List<Item> frontDoorItems = new ArrayList<Item>();	// An empty list so I can add stuff to it without too much trouble

		frontDoorItems.add(spottedMushroom);
		
		//-------------------------------------
		// SIDE GARDEN ITEMS
		//-------------------------------------

		List<Item> sideGardenItems = new ArrayList<Item>();
		sideGardenItems.add(buckthorn);
		sideGardenItems.add(statue);
		
        
		//-------------------------------------
		// SHACK INTERIOR ITEMS
		//-------------------------------------

		List<Item> shackItems = new ArrayList<>();

		shackItems.add(cauldron);
		shackItems.add(alchemyTome);
		shackItems.add(ingredientCupboard);
		shackItems.add(bookshelf);
		shackItems.add(gloveChest);
		shackItems.add(acidVial);
		
		//-------------------------------------
		// CELLAR ITEMS
		//-------------------------------------

		List<Item> cellarItems = new ArrayList<>();

		cellarItems.add(glowingMushroom);
		cellarItems.add(spider);
		
		//-------------------------------------
		// ROOM ASSIGNMENTS
		//-------------------------------------
		
		Room frontDoor = new Room(
			    "frontdoor",
			    "I'm standing outside the structure."
			    + "  The setting sun drawns long shadows against the gnarled wood."
			    + "  An imposing door stands to my east, with a prominent and large circular window flanking it."
			    + "  To the south, there is a path that leads around the corner of the house."
			    + "  Some mushrooms grow at the foot of the door.",
			    frontDoorItems,
			    null);

		Room sideGarden = new Room(
			    "sidegarden",
			    "I follow the path to a surprisingly calm garden located at the side of the building.  "
			    + "There is an unkempt bush bordering the house with a big window above it, too high to reach.  "
			    + "There is a large planter with several different kinds of flowers, most prominently featuring a tall and stalky plant with yellow berries.  "
			    + "At the foot of the planter rests an ugly statue of some creature.  "
			    + "The path I came from wraps back around the house to the north.",
			    sideGardenItems,
			    null);
		
		Room window = new Room(
			    "window",
			    "As i enter the structure, I am overwhelmed by the aromas wafting in the stagnant air.  "
			    + "All manner of natural scents can be detected combined with disturbing traces of death.  "
			    + "A large cauldron dominates the space in the middle of the room, bubbling over a fire with what appears to be water.  "
			    + "There is a bookshelf on my left wall with only three books on it.  "
			    + "On the far left side is a desk with a small vial and a gigantic tome on it.  "
			    + "To the right of the desk rests a small chest.  on the right wall is a long cupboard made of dark wood.  "
			    + "There is a ground hatch on the far eastern side of the abode and the window I entered is behind me to the west.",
			    shackItems,
			    statue);

		Room cellar = new Room(
			    "cellar",
			    "I escend the rickety stairs to a damp cellar beneath the shack. The air smells of mold.  "
			    + "I can see some glowing mushrooms in the far corner.  "
			    + "A spider the size of a dinnerplate rests menancingly in the corner adjacent to that.  "
			    + "The only exit is the staircase to the west.",
			    cellarItems,
			    null);
		
		//-------------------------------------
		// ROOM CONNECTIONS / ROOMS TO LIST
		//-------------------------------------
		
		frontDoor.setSouth(sideGarden);	// Front Door South -> Side Garden
		frontDoor.setEast(window);		// FD East -> Interior Shack
		sideGarden.setNorth(frontDoor); // Side Garden North -> Front Door
		window.setWest(frontDoor);		// Main Shack to Front Door
		window.setEast(cellar);			// Main Shack to Cellar
		cellar.setWest(window);			// Cellar back to Main Shack
		
		allRooms.add(frontDoor);		// For checking rooms against unlocking behavior
		allRooms.add(sideGarden);
		allRooms.add(window);
		allRooms.add(cellar);
		
        game.setPlayer(new Player(frontDoor));	// Dump the player on the frontDoor - have fun with my crappy game, loser
        										// Actually insane how much work goes into even something this simple.  Can't even imagine something AAA
    }
}
