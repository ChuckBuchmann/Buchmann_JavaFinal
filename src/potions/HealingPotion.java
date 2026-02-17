package potions;

import FinalProject.Interact;
import FinalProject.Potion;

// Probably the main objective of the game
public class HealingPotion extends Potion implements Interact {

    public HealingPotion() {
        super("Healing Potion", "the red vial", "A bright red liquid swirls inside the glass.");
    }

    @Override
    public void use() {
        System.out.println("You are perfectly healthy, there is no reason to drink this.");
    }

}
