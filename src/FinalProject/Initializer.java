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
    		    "The liquid inside the vial smokes slightly and it gives off an acrid stench.  Maybe it's corrosive.\n");
    	
    	KeyItem bookshelfKey = new KeyItem(
    		    "smallkey",		// TODO - Guide the player to this object's name
    		    "a small key",
    		    "A key that was hidden inside the pages of a book.");
    	
    	KeyItem statue = new KeyItem(
    			"statue",
    			"a heavy statue",
    			"It's an ugly little statue of some evil-looking creature with a red cap and a nasty grin.  It looks to be made of porcelain and is quite heavy.  I hate it.\n");
    	
    	
    	//-------------------------------------
    	// NORMAL INGREDIENTS / READABLES
    	//-------------------------------------
    	
    	NormalObject buckthorn = new NormalObject(
    			"yellowplant",
    			"a tall yellow plant",
    			"I've seen this plant before.  I dont know the name but it normally grows in the wild.  Now it's here being grown intentionally in a planter.\n");
    	
    	NormalObject mandrakeRoot = new NormalObject(
    		    "root",
    		    "a gnarled root",
    		    "The root vaguely resembles a screaming face.\n");

    	NormalObject glowingMushroom = new NormalObject(
    		    "glowingmushroom",
    		    "a glowing mushroom",
    		    "The mushroom glows with a faint blue light.\n");
    	
		Readable sword = new Readable(
			    "sword",
			    "a book entitled 'sword'",
			    "The yellow book looks pretty dusty.  There's a dominating depiction of excalibur on the front\n",
			    "'Chapter 1: On holding a sword...'  A beginner's manual?  Lame -- I wanted to learn some cool moves.\n");
		
		Readable goblins = new Readable(
			    "goblins",
			    "a book entitled 'goblins'",
			    "The green book gives no indication of its contents save for a gigantic bolded GOLBINS on the front and spine.\n",
			    "Flipping through it, its about some wackjob warlock who lived with a goblin tribe for a couple months.  Who reads this crap?\n");
		
		TrickBook redBook = new TrickBook(
			    "redbook",
			    "a red book with no title",
			    "It's a simple red book with no outwardly discernable features.  It doesn't have cover art or even a title anywhere on it\n",
			    "The pages are blank.",
			    bookshelfKey);

    	
    	//-------------------------------------
    	// DEADLY INGREDIENTS / OBJECTS
    	//-------------------------------------
    	
    	DeadlyObject nightshade = new DeadlyObject(
    		"nightshade",
    		"nightshade",
        	"Deadly nightshade berries.  Everyone is taught not to mess with this plant as children - better not touch it with my bare hands.\n");
    	
    	DeadlyObject spottedMushroom = new DeadlyObject(
    		"mushroom",
    		"a small mushroom with brown spots",
    		"This mushroom is stubby but short, and looks very appetizing.  I almost want to eat it.\n");
    	
    	DeadlyObject spider = new DeadlyObject(
    		"spider",
    		"a large spider",
    		"It's hard to make out in the gloom of the cellar, but does that spider have a skull on its abdomen?  A sudden urge to leave takes over me, but I fight it back.  Creepy ass spider.\n");
    			
    	//-------------------------------------
    	// STATIC OBJECTS
    	//-------------------------------------

		Cauldron cauldron = new Cauldron(
		    "cauldron",
		    "a massive iron cauldron",
		    "A black iron cauldron large enough to mix ingredients in.  It looks like it already has some water inside.  Once I've I'm happy with the mixture, I can brew the result to complete it.\n",
		    null);
		
		Readable alchemyTome = new Readable(
		    "tome",
		    "a massive leather-bound tome",
		    "The book on the table is huge and imposing.  It is covered in ink blotches and has an unsettling sigil on its cover.\n",
		    
		    // Readable passage
		    "I heasitantly open the gigantic book and begin rifling through its pages..."
		    + "\nI found it!  This passage details a potion with the effects that I need!\n"
		    + "\nHmm... I need to mix buckthorn, deathcap, glowing wyrm tongue, mandrake root, and nightshade."
		    + "\nJeez, where am I gonna find all that crap?\n"
		    + "\nIt says buckthorn is a tall plant with yellow seeds.  I saw that in the garden outside."
		    + "\nDeathcap is an unassuming spotted brown mushroom -- it says, 'WARNING, DO NOT TOUCH WITH BARE HANDS.'"
		    + "\nGlowing wyrm tongue apparently grows in the deepest recesses of our world."
		    + "\nI already know what nightshade is."
		    + "\nA mandrake is a twisted root with a face frozen in pain on it.  Creepy.");
		
		//-------------------------------------
		// CONTAINERS
		//-------------------------------------

		Container ingredientCupboard = new Container(
		    "cupboard",
		    "a dark cupboard",
		    "A dark wooden cupboard with a tiny keyhole on one side.  It has a rich scent of herbs and something tangy.\n",
		    bookshelfKey);

		Container gloveChest = new Container(
		    "chest",
		    "a small wooden chest",
		    "A small chest sitting beside the desk.  The padlock is almost completely destroyed.\n",
		    acidVial);

		Container bookshelf = new Container(
		    "bookshelf",
		    "a tall wooden bookshelf",
		    "Three books sit on the shelf next to one another."
		    + "\nThe left is yellow and simply titled 'Sword,' the middle is a green book entitled 'Golbins,' and the third is a red book with no visible title on the spine.\n",
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
		        "These are a pair of heavy leather gloves that can protect my hands from all sorts of nasties.\n"));

		bookshelf.getContents().add(sword);
		bookshelf.getContents().add(goblins);
		bookshelf.getContents().add(redBook);
		bookshelf.setLocked(false);	// Just making damn well sure this isn't locked cause its not cooperating with me
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
			    "I'm standing outside the structure.\n"
			    + "The setting sun drawns long shadows against the gnarled wood.\n"
			    + "An imposing door stands to my east, with a prominent and large circular window flanking it.\n"
			    + "To the south, there is a path that leads around the corner of the house.\n"
			    + "Some mushrooms grow at the foot of the door.\n",
			    frontDoorItems,
			    null);

		Room sideGarden = new Room(
			    "sidegarden",
			    "I follow the path to a surprisingly calm garden located at the side of the building.  "
			    + "\nThere is an unkempt bush bordering the house with a big window above it, too high to reach.  "
			    + "\nThere is a large planter with several different kinds of flowers, most prominently featuring a tall and stalky plant with yellow berries.  "
			    + "\nAt the foot of the planter rests an ugly statue of some creature.  "
			    + "\nThe path I came from wraps back around the house to the north.\n",
			    sideGardenItems,
			    null);
		
		Room window = new Room(
			    "window",
			    "As I enter the structure, I am overwhelmed by the aromas wafting in the stagnant air.  "
			    + "\nAll manner of natural scents can be detected combined with disturbing traces of death.  "
			    + "\nA large cauldron dominates the space in the middle of the room, bubbling over a fire with what appears to be water.  "
			    + "\nThere is a bookshelf on my left wall with only three books on it.  "
			    + "\nOn the far left side is a desk with a small vial and a gigantic tome on it.  "
			    + "\nTo the right of the desk rests a small chest.  on the right wall is a long cupboard made of dark wood.  "
			    + "\nThere is a ground hatch on the far eastern side and the window I entered is behind me to the west.\n",
			    shackItems,
			    statue);

		Room cellar = new Room(
			    "cellar",
			    "I descend the rickety stairs to a damp cellar beneath the shack. The air smells of mold.  "
			    + "\nI can see some glowing mushrooms in the far corner.  "
			    + "\nA spider the size of a dinnerplate rests menancingly in the corner adjacent to that.  "
			    + "\nThe only exit is the staircase to the west.\n",
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
