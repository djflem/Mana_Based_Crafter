import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;

public class ThinkTank {


    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String,Player> players = new HashMap<>();


    public static void main(String[] args) {

        while(true) {
            System.out.println("Are you a new player? (yes/no)");
            String isNewPlayer = scanner.nextLine().trim().toLowerCase();

            if ("yes".equals(isNewPlayer)) {
                createPlayer();
            } else if ("no".equals(isNewPlayer)) {
                selectExistingPlayer();
            } else {
                System.out.println("Invalid input. Do you want to continue? (yes/no)");
                String continueOption = scanner.nextLine().trim().toLowerCase();
                if (!"yes".equals(continueOption)) {
                    System.out.println("Closing program.");
                    break;
                }
                continue;
            }
            for (Player player : players.values()) {
                System.out.println("Player: " + player.getName() + ", Deck(s):");
                for (Deck deck : player.getDecks()) {
                    System.out.println(deck.getName());
                }
            }

            System.out.println("Welcome to the main menu. Choose an option.");
            String menu = scanner.nextLine();

            switch (menu){
                case "Create Deck":
                    createDeck();
                    break;
                case "Change Deck":
                    changeDeck();
                    break;
                case "Show Deck Data":
                    showData();
                    break;
                case "Modify Land Count":
                    modifyLands();
                    break;
                case "Add Custom Category":
                    newCategory();
                    break;


            }
        }
        scanner.close();
    }

    private static void createDeck() {
        System.out.println("Creating a new deck...");
        System.out.println("Enter deck name:");
        String deckName = scanner.nextLine().trim();
        System.out.println("Enter deck colors: (Example: RW,RU,WGB)");
        String deckColors = scanner.nextLine().trim();
        System.out.println("Enter how many lands your deck has:");
        int deckLands = scanner.nextInt();

        Deck deck = new Deck(deckName, deckColors, deckLands);
        player.addDeck(deck);
    }

    private static void changeDeck(){

    }

    private static void createPlayer(){
        System.out.println("Creating new player. Enter your name:");
        String name = scanner.nextLine().trim();
        Player player = new Player(name);
        players.put(name,player);
    }

    private static void showData(){

    }

    private static void modifyLands(){

    }

    private static void newCategory(){

    }

    private static void selectExistingPlayer() {
        System.out.println("Welcome back. Enter your name:");
        String name = scanner.nextLine().trim();
        Player player = players.get(name);

        if (player == null) {
            System.out.println("Not found.");
            createPlayer();
        }
        System.out.println("Happy brewing!");
    }

}
