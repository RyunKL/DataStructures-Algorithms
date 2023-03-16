import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static int menu_page(){
        int choice;
        Scanner input = new Scanner(System.in);
        System.out.println("\n------------Main Menu------------");
        System.out.println(" 1) Add new word");
        System.out.println(" 2) Delete word");
        System.out.println(" 3) Get meaning");
        System.out.println(" 4) Dictionary List");
        System.out.println(" 5) Spell check a text file");
        System.out.println(" 6) Exit");
        System.out.print("\nPlease enter an task (1 - 6): ");
        choice = Integer.parseInt(input.nextLine());
        return choice;
    }
    public static void main(String[] args) {
        int userChoice;
        Scanner input = new Scanner(System.in);
        Dictionary vol1 = new Dictionary(1500);
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/wordList.txt"));
            String line;
            while((line = br.readLine()) !=null){
                vol1.add(line, "Undefined word");
            }
            br.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        do{
            userChoice = menu_page();
            while (userChoice < 1 || userChoice > 6){
                System.out.println("Invalid input, please input a valid option (1 - 6)");
                userChoice = Integer.parseInt(input.nextLine());
            }
            switch (userChoice) {
                case 1 -> {
                    // add word
                    System.out.println("Please enter the word you wish to add to the dictionary: ");
                    String tempWord = input.nextLine();
                    System.out.println("Please enter the words definition");
                    String tempMeaning = input.nextLine();
                    vol1.add(tempWord, tempMeaning);
                    System.out.println("Success! " + tempWord + " has been added to the dictionary");
                }
                case 2 -> {
                    // delete word
                    System.out.println("Please enter the word you wish to delete: ");
                    String tempKeyword = input.nextLine();
                    vol1.delete(tempKeyword);
                    System.out.println("Success! " + tempKeyword + " has been deleted from the dictionary");
                }
                case 3 -> {
                    // get meaning
                    System.out.println("Please enter the word you wish to get the meaning of: ");
                    String tempWord = input.nextLine();
                    String tempMeaning = vol1.returnMeaning(tempWord);
                    System.out.println(tempMeaning);
                }
                case 4 -> {
                    // dictionary list
                    System.out.println(vol1.toString());
                }
                case 5 -> {
                    // spell check
                    System.out.println("Please enter the word you wish to check: ");
                    String userInput = input.nextLine();
                    String userFileName = "src\\" + userInput;
                    vol1.spellCheck(userFileName);
                }
                case 6 -> System.out.println("Exit");
                default -> {
                }
            }
        }while (userChoice != 6);
    }
}