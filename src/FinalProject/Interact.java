package FinalProject;


// Big thanks to GPT for explaining interfaces in a way that I could easily understand
// Essentially, an interface is a collection of instructions that can be executed by different types of objects.
// A great example that helped me understand would be that, in my game specifically, I want the player to be able
// to pick up different kinds of objects.
// I could implement a take() method in every object I want the player to be able to collect, or I can use an interface
// to wrap that behavior all in one place - a perfect example of polymorphism.

// Supposedly, modern Java does allow logic in interfaces, but the standard way of using these is to declare what can be done, not how
// Logic is handled in the objects using overrides
// That feels weird, though.  Why even make the interface in the first place then?  I think I'll make some basic logic for my game
// Today, I'll just use overrides, though

public interface Interact {

	void take();
	void inspect();
	void use();
	void read();
	
	// Not sure if mixing would be an interface method yet, but I'll put it here for now
	void mix();
	
}
