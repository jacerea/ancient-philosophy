import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        //Check for error coding
        System.out.println("What Greek Philosopher would you like to learn about? (Aristole or Seneca)");
        String choice = scanner.nextLine();
        List<String> historyArrayList = new ArrayList<>();
        List<String> quotesArrayList = new ArrayList<>();
        List<String> reactionsArrayList = new ArrayList<>();

        //reader.close()
        //Adds all the data from the txt files into their respective arraylists.
        if(choice == "Aristole"){
            try{
                Scanner reader = new Scanner(new File("philosophers.aristotle.arihistory"));
                while(scanner.hasNextLine()){
                    historyArrayList.add(reader.nextLine());
                }
                reader = new Scanner(new File("philosophers.aristotle.ariquotes"));
                while(scanner.hasNextLine()){
                    quotesArrayList.add(reader.nextLine());
                }
                reader = new Scanner(new File("philosophers.aristotle.arireactions"));
                while(scanner.hasNextLine()){
                    reactionsArrayList.add(reader.nextLine());
                }
            }catch(FileNotFoundException exception){
                exception.printStackTrace();
            }
        }else{ 
            try{
                Scanner reader = new Scanner(new File("philosophers.seneca.senhistory"));
                while(scanner.hasNextLine()){
                    historyArrayList.add(reader.nextLine());
                }
                reader = new Scanner(new File("philosophers.seneca.senquotes"));
                while(scanner.hasNextLine()){
                    quotesArrayList.add(reader.nextLine());
                }
                reader = new Scanner(new File("philosophers.seneca.senreactions"));
                while(scanner.hasNextLine()){
                    reactionsArrayList.add(reader.nextLine());
                }
            }catch(FileNotFoundException exception){
                exception.printStackTrace();
            }
        }
        //prints the full history of said philosopher from the arraylist
        for(int i = 0; i < historyArrayList.size(); i++){
            System.out.println(historyArrayList.get(i));
        }
        //Asks if they want to hear quotes from the philosopher
        System.out.println("This was the history of " + choice + ". Enter 1 for a random " + choice + " quote. Enter 0 if you would like to exit and see the battle between philosophers.");
        int quoteChoice = scanner.nextInt();
        //Debug/Check for errors
        //Printing all the quotes
        while(quoteChoice == 1){
            int size = quotesArrayList.size();
            int i = 0;
            System.out.println(quotesArrayList.get(i));
            size--;
            i++;
            System.out.println("Would you like another quote? There are " + size + " quotes remaining. Enter 1 if so.");
            quoteChoice = scanner.nextInt();
            if(size == 0){
                System.out.println("There are no more quotes remaining, time to battle.");
                quoteChoice = 0;
            }
        }

        //battle
        
    }    
}
