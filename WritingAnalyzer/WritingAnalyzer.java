package WritingAnalyzer;

import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * The program reads the file and returns the total number of words, the total number of unique words, and the
 * number of times each word is in the file.
 * The program also displays each word alphabetically and with the number of times it is in the file.
 */
public class WritingAnalyzer {
    /**
     * Displays the banner for the program
     */
    public static void banner(){
        //Function 1
        System.out.println("""
                **************************************************************
                \t\t\t\t\tWriting Analyzer V1.0
                **************************************************************
                """);
    }

    /**
     * Prints the menu for the user to input the file name.
     * @param sc - scans for the user's file name
     * @return - returns the user's file name
     */
    public static String menu(Scanner sc){
        //Function 2
        //Ask the user the name of the file to analyze
        //Tested the program with this absolute path:
        //"/Users/SebJaculbe/ObjectOrientedProgramming/OOP/src/main/java/tale_of_two_cities.txt"
        System.out.println("Enter the name of the file to analyze: ");
        return sc.nextLine();
    }

    /**
     * Asks the user for the file they want to be analyzed and the program returns back results.
     */
    public static void main(String[] args){
        //Function 3
        banner();
        //Initializing Variables
        Scanner scan = new Scanner(System.in);
        ArrayList<String> uniqueWords = new ArrayList<String>();
        LinkedHashMap<String, Integer> count = new LinkedHashMap<String, Integer>();
        int numOfWords = 0;
        int totalWordLength = 0;
        String fileName = menu(scan);

        /*
        The code is from ChatGPT.
        I learned the difference between File, FileWriter, BufferedWriter, and PrintWriter through the notes.
        I learned about BufferedReader and FileReader.
         */
        //Line 39 is the BufferedWriter but for reading contents of a file in chunks.
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    //Learned the regular expression from class
                    String[] words = line.toLowerCase().replaceAll("[,().]", "").split("\\s+");
                    for (String word : words) {
                        if (!word.isEmpty()) {
                            if (!uniqueWords.contains(word)) {
                                uniqueWords.add(word);
                            }
                        /*
                        Learned from ChatGPT the mechanics of getOrDefault is and what it does.
                        It is used with Map objects.
                        This appends the word into count and if the word isn't found in the map, then it returns 0+1.
                        put assigns the key with a value.
                        getOrDefault returns a number.
                        */
                            count.put(word, count.getOrDefault(word, 0) + 1);
                            numOfWords++;
                            totalWordLength += word.length();
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("An error occurred while reading the file.\n");
            }

        //Sorts the ArrayList
        Collections.sort(uniqueWords);

        //Displays the results of the file
        System.out.printf("Number of words: %d\n", numOfWords);
        System.out.printf("There are %d unique words in the text.\n", uniqueWords.size()); //ChatGPT
        for (String word:uniqueWords){
            System.out.printf("%-20s %10d\n",word,count.get(word));
        }
        System.out.printf("The average word length is %.2f.\n",(double)totalWordLength/numOfWords);
        System.out.println("Thank you for using this program.");
    }
}
