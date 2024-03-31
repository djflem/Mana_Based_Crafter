import java.io.*;
import java.util.Scanner;

public class FileReading {

    private static final String FILE_PATH = "C:\\Users\\Smeej\\Desktop\\Merit\\Mana_Based_Crafter\\Mana_Based_Crafter\\MBC_DATA.txt";

    public static void main(String[] args){
        readFileContents();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your age: ");
        String age = scanner.nextLine();

        if (nameExists(name)) {
            System.out.println("This name already exists in the file.");
        } else {
            writeUserData(name, age);
            System.out.println("User data saved successfully.");
        }
    }

    public static void readFileContents(){
        BufferedReader reader = null;

        try{
            reader = new BufferedReader(new FileReader(FILE_PATH));
            String currentLine;

            while((currentLine = reader.readLine()) != null){
                System.out.println(currentLine);
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(reader != null) reader.close();
            }catch (IOException ex){
                ex.printStackTrace();
            }
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

    private static void writeUserData(String name, String age) {
        try (FileWriter fw = new FileWriter(FILE_PATH, true);
            BufferedWriter writer = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(writer)) {
            out.println("Name: " + name + ", Age: " + age);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
