package StoryTeller;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class contains the main function that runs the program.
 */
public class App {
    /**
     * This is the banner method that displays the banner of the program.
     * It returns nothing.
     */
    public static void banner(){
        System.out.println("""
                *************************************************
                \t\t\t\tSTORYTELLER V1.0
                *************************************************
                
                Welcome to StoryTeller, a sophisticated electronic
                author. This program reads from a list of words of
                various parts of speech and creates a story from
                them. You can tune the richness of the writing by
                changing how frequently adjectives, adverbs, and
                prepositions should be included.\n
                """);
    }

    /**
     * This method prints out sentences in the ArrayList being passed.
     * @param sentences - ArrayList<String> is passed to be iterated in a for loop
     */
    public static void printSentences(ArrayList<String> sentences){
        for(String sentence: sentences){
            System.out.println(sentence);
        }
    }

    /**
     * This is the main function that runs the whole program.
     * It doesn't return anything.
     */
    public static void main(String[] args){
        banner();
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the name of the word file: ");
        String fileName = scan.nextLine();
        //Create the LinkedHashMap
        LinkedHashMap<String,ArrayList<String>> words = WordFileReader.readFile(fileName);
        //Checks to see if words is null
        if(words == null){
            System.out.println("Error occurred.");
            return;
        }
        //Calls the Author Model class, and it takes words as the parameter.
        Author author = new Author(words);
        int howMany, adjs, advs, preps;
        ArrayList<String> sentences;
        String response;
        //The do while asks the user a series of questions and continues generating stories until the user stops.
        do {
            System.out.println("How many sentence would you like in your story? ");
            howMany = scan.nextInt();
            System.out.println("On a scale of 0 to 10...");
            System.out.println("\tHow frequently should adjectives be used? ");
            adjs = scan.nextInt();
            System.out.println("\tHow frequently should adverbs be used? ");
            advs = scan.nextInt();
            System.out.println("\tHow frequently should prepositions be used? ");
            preps = scan.nextInt();
            //The frequencies are added to the Author class
            author.setAdjFreq(adjs);
            author.setAdvFreq(advs);
            author.setPrepFreq(preps);
            //This ArrayList is set to be equal to the Author's generateStory method
            sentences = author.generateStory(howMany);
            System.out.println("Here it is: ");
            printSentences(sentences); //Calls the method located in this class to print the ArrayList
            System.out.println();
            System.out.println("Would you like another story (y or n)? ");
            scan.nextLine();
            response = scan.nextLine();
            System.out.println();
        } while (response.equalsIgnoreCase("y"));
        //End of program
        System.out.println("Thank you for using StoryTeller!");
    }
}