package StoryEditor;

import java.io.FileWriter;
import java.io.BufferedWriter;

/**
 * This class save's the story to a file.
 */
public class StoryWriter {
    //Returns true if the save was successful and false otherwise
    public static boolean saveStory(String story, String fileName){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write(story);
            return true;
        } catch(Exception e){
            return false;
        }
    }
}