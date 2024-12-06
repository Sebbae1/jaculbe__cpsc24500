package StoryEditor;

import java.util.Scanner;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.ArrayList;

/**
 * This class reads the file and uploads the file's contents into a LinkedHashMap
 */
public class WordFileReader {
    /**
     * This method reads the file and loads the contents in a LinkedHashMap
     * @param fileName - The file name
     * @return - The LinkedHashMap of words
     */
    public static LinkedHashMap<String,ArrayList<String>> fileReader(File fileName) {
        LinkedHashMap<String,ArrayList<String>> words = new LinkedHashMap<>();
        try (Scanner scan = new Scanner(fileName)){
            String line;
            while(scan.hasNextLine()){
                line = scan.nextLine().trim();
                String[] parts = line.split("\\s+");
                if (parts.length < 2) {
                    continue;
                }
                String word = parts[0].trim();
                String speech = parts[1].trim();
                words.computeIfAbsent(speech, k -> new ArrayList<>()).add(word);
            }
            scan.close();
            return words;
        } catch(Exception e){
            return null;
        }
    }
}