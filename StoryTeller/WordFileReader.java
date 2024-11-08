package StoryTeller;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class reads the words for a file into memory.
 */
public class WordFileReader {
    public static LinkedHashMap<String, ArrayList<String>> readFile(String fileName) {
        //Used the Token Reader to help model the basis of this code.
        LinkedHashMap<String, ArrayList<String>> words = new LinkedHashMap<String, ArrayList<String>>();
        try {
            Scanner scan = new Scanner(new File(fileName));
            String line, word, speech;
            String[] parts;
            while(scan.hasNextLine()) {
                line = scan.nextLine().trim(); //Trim to detect empty lines and remove spaces
                if (line.isEmpty()) {
                    continue;
                }

                parts = line.split("\\s+"); //Instead of \t, \\s+
                if(parts.length != 2) {
                    continue;
                }
                word = parts[0];
                speech = parts[1];

                //Used ChatGPT to help me figure out a major issue with appending words and part of speeches
                words.computeIfAbsent(speech, k -> new ArrayList<String>()).add(word);
            }
            scan.close();
        } catch(Exception ex){
            return null;
        }
        return words;
    }
}