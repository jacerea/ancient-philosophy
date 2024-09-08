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
        System.out.println("What Philosopher/Psycologist would you like to learn about? (Aristole, Seneca, Bloom)");
        String choice = scanner.nextLine().toLowerCase();
        List<String> historyArrayList = new ArrayList<>();
        List<String> quotesArrayList = new ArrayList<>();
        List<String> reactionsArrayList = new ArrayList<>();

        //reader.close()
        //Adds all the data from the txt files into their respective arraylists.
        //We need to figure out how to print the ASCIIs
        if(choice == "aristole"){
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
        }else if(choice == "seneca"){ 
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
        }else{
            try{
                Scanner reader = new Scanner(new File("philosophers.bloom.bloomhistory"));
                while(scanner.hasNextLine()){
                    historyArrayList.add(reader.nextLine());
                }
                reader = new Scanner(new File("philosophers.bloom.bloomquotes"));
                while(scanner.hasNextLine()){
                    quotesArrayList.add(reader.nextLine());
                }
                reader = new Scanner(new File("philosophers.bloom.bloomreactions"));
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
        System.out.println("Would you like to battle? 1 for yes 0 for no.");
        int yn = scanner.nextInt();
        if(yn == 1){
            System.out.println("Who would you like to fight?");
            String battleChoice = scanner.nextLine();
        }
        while(yn == 1){
            //random number 1-10 and the + 1 is just in case the math.random gives me 0.0.
            int choiceNumber = (int) (Math.random() * 10) + 1;
            int otherNumber = (int) (Math.random() * 10) + 1;
            if(choiceNumber > otherNumber){
                System.out.println(reactionsArrayList.get(0));
                yn = 0;
            } else if(choiceNumber == otherNumber){
                System.out.println("Twas' a tie. Rerolling...");
            } else {
                System.out.println(reactionsArrayList.get(1));
                yn = 0;
            }
        }
        System.out.println("You have reached the end of the TechX hackathon code! Press 1 to continue.");
        int next = scanner.nextInt();
        //lol if u dont enter 1 i get mad
        while(next != 1){
            System.out.println("Why do you have to be this way. Just press 1 already. >:( ");
            next = scanner.nextInt();
        }
        System.out.println("I appreciate you guys for going through the code and it was a pleasure to code this during the hackathon.");
        System.out.println("I believe the hints were alluding towards the value of education, learning, and time.");
        System.out.println("If you put your mind to something and really want to execute it, the passion of learning will guide you through it.");
        System.out.println("You just need to get out there and do it. :)");
    }    
}
