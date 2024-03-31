import java.io.*;
import java.util.Scanner;

public class ThinkTank {
    private static final String FILE_PATH = "C:\\Users\\Smeej\\Desktop\\Merit\\Mana_Based_Crafter\\Mana_Based_Crafter\\MBC_DATA.txt";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            mainMenu();
            scanner.close();
        }
    }

    private static void mainMenu() {
        System.out.println("Main menu... Input a number.");
        System.out.println("1. Create new deck");
        System.out.println("2. Load existing deck");

        try {
            int menu = scanner.nextInt();
            switch (menu) {
                case 1: //create new deck
                    createDeck();
                    break;
                case 2: //load existing deck
                    displayDecks();
                    //loadDeck();
                    break;
                case 3: //future option
                    break;
            }

            System.out.println("Invalid input... Input a number.");
            System.out.println("1. Main menu");
            System.out.println("2. Exit");

            int continueOption = scanner.nextInt();
            if (continueOption == 1) {
                mainMenu();
            } else {
                System.out.println("Closing program...");
            }
        } catch(Exception e) {
            e.printStackTrace();
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

    public static void displayDecks(){
        BufferedReader reader = null;
        int deckCounter = 0;

        try{
            reader = new BufferedReader(new FileReader(FILE_PATH));
            String currentLine;
            System.out.println("List of existing decks... Input a number.");

            while((currentLine = reader.readLine()) != null){
                System.out.println((deckCounter += 1) + ". " + currentLine);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        finally{
            try{
                if(reader != null) reader.close();
            }
            catch (IOException ex){
                ex.printStackTrace();
            }
        }
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

