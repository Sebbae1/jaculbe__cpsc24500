package StoryEditor;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class chooses a random word from an ArrayList
 */
public class WordChooser {

    private Random ran;

    /**
     * Constructor to initialize the Random object
     */
    public WordChooser() {
        ran = new Random();
    }

    /**
     * This method chooses a random word from the ArrayList
     * @param words - An ArrayList of words
     * @return - A random word from the ArrayList
     */
    public String chooseWord(ArrayList<String> words){
        int index = ran.nextInt(words.size());
        return words.get(index); //Randomly select the word
    }
}