package FinalProject;

import java.util.HashMap;
import java.util.Map;

/*
 * My idea for implementing maps ties back into our work on keeping time that we worked with last week
 * I think keeping track of how long the player takes to do things will be an interesting way to add a small bit of spice to the game
 * To this end, I think that I could use map to keep track of events I want to fire after an amount of time has passed
 * e.g. after 10 player actions, something happens
 * Also if I sound weird or rambly in my comments it's cause its way past my bedtime
*/

public class MapDemo {
    public static void main(String[] args) {

        Map<Integer, String> events = new HashMap<>();

        // ask GPT to make some mock events
        events.put(6, "The sun shines through the lone window.");
        events.put(12, "A bell chimes noon.");
        events.put(18, "The candles flicker as evening falls.");
        events.put(21, "A ghostly whisper echoes over the tiles");

        // Now manually check the map
        // Ideally, this would be done with via a player action counter
        // TODO - Player action counter
        int currentHour = 12;
        if(events.containsKey(currentHour)) {
            System.out.println(events.get(currentHour));
        }
    }
}