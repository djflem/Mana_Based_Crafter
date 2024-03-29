import java.util.ArrayList;
import java.util.List;

public class DeckBox {

    public static void main(String[] args) {

        List<Deck> deckBox = new ArrayList<>();

        Deck rakdos = new Deck("Rakdos","RB",40);

        deckBox.add(rakdos);

        //Player me = new Player("DJ", deckBox);

        System.out.println("Land Percentage: %" + rakdos.getLandPercent());
        System.out.println("Number of colors: " + rakdos.getNumberOfColors());

    }
}
