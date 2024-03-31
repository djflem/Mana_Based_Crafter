import java.io.*;
import java.util.Scanner;

public class ThinkTank {
    private static final String FILE_PATH = "C:\\Users\\Smeej\\Desktop\\Merit\\Mana_Based_Crafter\\Mana_Based_Crafter\\MBC_DATA.txt";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mainMenu();
    }

    private static void mainMenu() {
        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println("\nMain menu... Input a number.");
            System.out.println("1. Create new deck");
            System.out.println("2. Load existing deck");
            System.out.println("3. Exit");

            String input = scanner.nextLine();
            int menu = 0;
            try {
                menu = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            switch (menu) {
                case 1:
                    createDeck();
                    break;
                case 2:
                    displayDecks();
                    loadDeck();
                    break;
                case 3:
                    System.out.println("Closing program...");
                    keepRunning = false;
                    break;
                default:
                    System.out.println("Invalid input... Please try again.");
            }
        }
    }

    private static void createDeck() {
        //System.out.println("...");
        System.out.println("Creating a new deck...");
        System.out.println("Give the deck a name:");
        String deckName = scanner.nextLine().trim();
        System.out.println("Enter deck colors: (Example: RW,RU,WGB)");
        String deckColors = scanner.nextLine().trim();
        System.out.println("Enter how many lands your deck has:");
        int deckLands = scanner.nextInt();

        //Deck deck = new Deck(deckName, deckColors, deckLands);
        writeUserData(deckName, deckColors, deckLands);
    }

    private static void showData(){

    }

    private static void modifyLands(){

    }

    public static void displayDecks() {
        int deckCounter = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            System.out.println("Choose existing deck... Input a number.");
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                System.out.println(++deckCounter + ". " + currentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadDeck(){



    }

    private static void writeUserData(String name, String colors, int lands) {
        try (FileWriter fw = new FileWriter(FILE_PATH, true);
            BufferedWriter writer = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(writer)) {
            out.println("Name: " + name + ", Colors: " + colors + ", Land Count: " + lands);

        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    private static boolean nameExists(String name){
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                // Parsing the line to extract the name
                String[] parts = currentLine.split(",");
                String namePart = parts[0]; // "Name: John Doe"
                String recordedName = namePart.split(":")[1].trim();
                if (recordedName.equalsIgnoreCase(name)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}

