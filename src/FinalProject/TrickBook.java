package FinalProject;

public class TrickBook extends Readable implements Interact {

	// ty GPT for help implementing this - passing in the hidden key as a parameter was not something I considered
    private KeyItem hiddenKey;
    private boolean keyTaken = false;

    public TrickBook(String name, String takeDescription, String inspectDescription, String setText, KeyItem hiddenKey) {
        super(name, takeDescription, inspectDescription, setText);
        this.hiddenKey = hiddenKey;
    }

    @Override
    public void read(Player player) {
        System.out.println(this.getReadText());		// show the normal reading text

        if (!keyTaken && hiddenKey != null) {		// But give the key if the player doesn't have it already
            System.out.println("Just what the hell is this book?  As I rapidly flip through the pages, something clinks on the floor.  Its a key!  It was hiding in the recess of the spine.  Clever.  I pick up the small key and replace the book on the shelf.");
            player.addItem(hiddenKey);
            keyTaken = true;
        }
    }
}