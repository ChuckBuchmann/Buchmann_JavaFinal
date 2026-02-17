package FinalProject;

// I relied on GPT heavily here
// I thought that the best way to include this part of the assignment would be a time counter that increments
// whenever the player does an action
// In my mind, the player breaks into a wizard's laboratory, so it's not unreasonable to think that the owner could return
// Many game flags and logic could be configured using this counter, making it very useful

public class ActionCounter {

	// This will ensure only one instance of this object exists at a time
    private static ActionCounter instance;
    
    // How many actions the player has performed
    private int actions;
    
    // Private constructor prevents outside classes from creating new counters
    private ActionCounter() {
        actions = 0;
    }
    
    // ty GPT - public method to get the instance
    public static ActionCounter getInstance() {
        if (instance == null) {
            instance = new ActionCounter();
        }
        return instance;
    }
    
    // Dunno how I'm going to actually record this but that's a problem for future me
    public void recordAction() {
        actions++;
        
        // Example flag that could trigger
        if (actions == 50) {
            System.out.println("You hear heavy steps beyond the door...");
        }
    }

    // Get current number of actions in case another method wants to use it (brewing potions???????)
    // Maybe renaming this to time would be more accurate
    public int getActions() {
        return actions;
    }
    
    // As far as performance goes, I'm not too sure.
    // My amateur intuition tells me that having this counter tick up every time an action is performed shouldn't affect performance
    // too much, even if this game were rather complicated
    // Modern games record thousands if not tens of thousands of variables at a time, so I think my dinky single int counter
    // will be alright, even though it will fire every time the player does something.
    
    
}
