import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        //Check for error coding
        System.out.println("What Philosopher/Psycologist would you like to learn about? (Aristotle, Seneca, Bloom)");
        String choice = scanner.nextLine().toLowerCase();
        List<String> historyArrayList = new ArrayList<>(5);
        List<String> quotesArrayList = new ArrayList<>(10);
        List<String> reactionsArrayList = new ArrayList<>(2);

        //Adds all the data from the txt files into their respective arraylists.
        //We need to figure out how to print the ASCIIs
        if(choice.equals("aristotle")) {
            try{
                Scanner reader = new Scanner(new File("philosophers/aristotle/arihistory.txt"));
                while(reader.hasNextLine()){
                    historyArrayList.add(reader.nextLine());
                }
                reader.close();
                reader = new Scanner(new File("./philosophers/aristotle/ariquotes.txt"));
                while(reader.hasNextLine()){
                    quotesArrayList.add(reader.nextLine());
                }
                reader.close();
                reader = new Scanner(new File("./philosophers/aristotle/arireactions.txt"));
                while(reader.hasNextLine()){
                    reactionsArrayList.add(reader.nextLine());
                }
                reader.close();
                reader = new Scanner(new File("./philosophers/aristotle/ariascii.txt"));
                while(reader.hasNextLine()) {
                    System.out.println(reader.nextLine());
                }
                reader.close();
            }catch(FileNotFoundException exception){
                exception.printStackTrace();
            }
        }else if(choice.equals("seneca")){ 
            try{
                Scanner reader = new Scanner(new File("./philosophers/seneca/senhistory.txt"));
                while(reader.hasNextLine()){
                    historyArrayList.add(reader.nextLine());
                }
                reader.close();
                reader = new Scanner(new File("./philosophers/seneca/senquotes.txt"));
                while(reader.hasNextLine()){
                    quotesArrayList.add(reader.nextLine());
                }
                reader.close();
                reader = new Scanner(new File("./philosophers/seneca/senreactions.txt"));
                while(reader.hasNextLine()){
                    reactionsArrayList.add(reader.nextLine());
                }
                reader.close();
                reader = new Scanner(new File("./philosophers/seneca/senascii.txt"));
                while(reader.hasNextLine()) {
                    System.out.println(reader.nextLine());
                }
                reader.close();
            }catch(FileNotFoundException exception){
                exception.printStackTrace();
            }
        }else if(choice.equals("bloom")){
            try{
                Scanner reader = new Scanner(new File("./philosophers/bloom/bloomhistory.txt"));
                while(reader.hasNextLine()){
                    historyArrayList.add(reader.nextLine());
                }
                reader.close();
                reader = new Scanner(new File("./philosophers/bloom/bloomquotes.txt"));
                while(reader.hasNextLine()){
                    quotesArrayList.add(reader.nextLine());
                }
                reader.close();
                reader = new Scanner(new File("./philosophers/bloom/bloomreactions.txt"));
                while(reader.hasNextLine()){
                    reactionsArrayList.add(reader.nextLine());
                }
                reader.close();
                reader = new Scanner(new File("./philosophers/bloom/bloomascii.txt"));
                while(reader.hasNextLine()) {
                    System.out.println(reader.nextLine());
                }
                reader.close();
            }catch(FileNotFoundException exception){
                exception.printStackTrace();
            }
        }
        //if they choose noone
        else{
            System.out.print("not a choice");
        }
        //prints the full history of said philosopher from the arraylist
        for(int i = 0; i < historyArrayList.size(); i++){
            System.out.println(historyArrayList.get(i));
        }
        //Asks if they want to hear quotes from the philosopher
        System.out.println("This was the history of " + choice + ". \nEnter 1 for a random " + choice + " quote. Enter 0 if you would like to exit and see the battle between philosophers.");
        int quoteChoice = scanner.nextInt();
        //Debug/Check for errors
        //Printing all the quotes
        int size = quotesArrayList.size();
        int i = 0;
        while(quoteChoice == 1){
            System.out.println(quotesArrayList.get(i));
            size--;
            i++;
            System.out.println("Would you like another quote? There are " + size + " quotes remaining. Enter 1 if so.");
            quoteChoice = scanner.nextInt();
            if(size == 1){
                System.out.println("There are no more quotes remaining, time to battle.");
                quoteChoice = 0;
            }
        }

        //battle
        System.out.println("Who would you like to fight?");
        String battleChoice = scanner.next();
        while(battleChoice.toLowerCase().equals(choice)){
            System.out.println("Choose a different person.");
            battleChoice = scanner.next();
        }
        int x = 1;
        while(x == 1){
            //random number 1-10 and the + 1 is just in case the math.random gives me 0.0.
            int choiceNumber = (int) (Math.random() * 10) + 1;
            int otherNumber = (int) (Math.random() * 10) + 1;
            if(choiceNumber > otherNumber){
                System.out.println(choice + " beat " + battleChoice + " in an philosophical battle!");
                System.out.println(choice + " reflects on the victory. " + reactionsArrayList.get(0));
                x = 0;
            } else if(choiceNumber == otherNumber){
                System.out.println("Twas' a tie. Rerolling...");
            } else {
                System.out.println(battleChoice + " beat " + choice + " in an philosophical battle!");
                System.out.println(choice + " reflects on the loss. " + reactionsArrayList.get(1));
                x = 0;
            }
        }
        System.out.println("You have reached the end of the TechX hackathon code! Press 1 to continue.");
        int next = scanner.nextInt();
        //lol if u dont enter 1 i get mad
        while(next != 1){
            System.out.println("Why do you have to be this way. Just press 1 already. >:( ");
            next = scanner.nextInt();
        }
        //Explanation of the theme and outro
        System.out.println("I appreciate you guys for going through the code and it was a pleasure to code this during the hackathon.");
        System.out.println("I believe the hints were alluding towards the value of education, learning, and time.");
        System.out.println("If you put your mind to something and really want to execute it, the passion of learning will guide you through it.");
        System.out.println("You just need to get out there and do it.");
        scanner.close();
    }    
}