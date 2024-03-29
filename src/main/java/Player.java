import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This program needs to... ask your name, your format (60/100 card deck), your deck's colors...
 *  then the calculations can begin: determine the deck's spell vs land balance.
 *  the high and low ranges of lands to play should be weighed against the deck's ramp
 *  then it's up to the user to count and input the mana symbols of each card
 *  for each color's total mana symbols, determine the amount of colored land needed
 *  let user separate lands in piles of colorless(utility), duals, other color combos...
 *  to determine just the remaining basic/mono colored lands to include in mana base.
 **/

public class Player {

    private String name;
    private List<Deck> decks;

    public Player(String name){
        this.name = name;
        this.decks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Deck> getDecks() {
        return decks;
    }

    public void addDeck(Deck deck){
        decks.add(deck);
    }


}
