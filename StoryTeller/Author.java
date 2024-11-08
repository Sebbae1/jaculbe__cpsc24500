package StoryTeller;

import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.Random;

/**
 * This class is responsible for generating each story.
 */
public class Author {
    //Used the Password Generator and the previous Employee Model classes to create
    //this Model class for Author.
    private LinkedHashMap<String, ArrayList<String>> words;
    private Random ran;
    private int adjFreq;
    private int advFreq;
    private int prepFreq;

    public int getAdjFreq() {
        return adjFreq;
    }

    public int getAdvFreq() {
        return advFreq;
    }

    public int getPrepFreq() {
        return prepFreq;
    }

    public void setAdjFreq(int adjFreq) {
        if (adjFreq > 10) {
            this.adjFreq = 10;
        } else if(adjFreq < 0) {
            this.adjFreq = 0;
        } else {
            this.adjFreq = adjFreq;
        }
    }

    public void setAdvFreq(int advFreq) {
        if (advFreq > 10) {
            this.advFreq = 10;
        } else if(advFreq < 0) {
            this.advFreq = 0;
        } else {
            this.advFreq = advFreq;
        }
    }

    public void setPrepFreq(int prepFreq) {
        if (advFreq > 10) {
            this.prepFreq = 10;
        } else if(prepFreq < 0) {
            this.prepFreq = 0;
        } else {
            this.prepFreq = prepFreq;
        }
    }

    public Author() {
        this(null);
    }

    public Author(LinkedHashMap<String, ArrayList<String>> words) {
        this.words = words;
        ran = new Random();
    }

    //Used the structure from one of the methods in the Password Generator
    //to help me model this method.
    public String chooseSpeech(String speech){
        ArrayList<String> list = words.get(speech);
        if(list != null && !list.isEmpty()){
            return list.get(ran.nextInt(list.size()));
        } else {
            return " ";
        }
    }


    public String generateSentence(){
        if (words == null){
            return null;
        }

        //Used ChatGPT to help generate and combine the parts of speech together.
        //Used the code from the Password Generator to help me model this method.
        StringBuilder sentence = new StringBuilder("The ");
        boolean hasPart = false; //From ChatGPT, helps check if an adjective, adverb, or preposition is needed
        int picker;
        picker = ran.nextInt(10);
        if(picker < adjFreq){
            sentence.append(chooseSpeech("adj")).append(" "); //Adds a space after adding each part of speech
            hasPart = true;
        }

        sentence.append(chooseSpeech("n")).append(" ");

        sentence.append(chooseSpeech("v"));

        if(picker < advFreq){
            sentence.append(" ").append(chooseSpeech("adv"));
            hasPart = true;
        }

        if (picker < prepFreq){
            sentence.append(" ").append(chooseSpeech("prep")).append(" the ");
            sentence.append(chooseSpeech("n"));
            hasPart = true;
        }

        sentence.append(".");
        return sentence.toString().trim();
    }

    //ChatGPT helped me add this method
    public ArrayList<String> generateStory(int sentenceCount){
        ArrayList<String> story = new ArrayList<>();
        for (int i = 0; i < sentenceCount; i++) {
            story.add(generateSentence());
        }
        return story;
    }
}