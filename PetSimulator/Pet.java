package PetSimulator;

import java.util.ArrayList;
import java.util.Random;

/**
 * Abstract class of Pet. Dog, Cat, and Fish classes extend Pet.
 */
public abstract class Pet {
    private String petName;
    private Random brain;
    private int needFood, needSleep, needLove;

    /**
     * Default Constructor
     */
    public Pet(){
        this.petName = "Pet";
        this.brain = new Random();
        this.needFood = 0;
        this.needSleep = 0;
        this.needLove = 0;
    }

    /**
     * Pet Constructor with Parameter
     * @param petName - takes the name of a pet.
     */
    public Pet(String petName){
        this.petName = petName;
        this.brain = new Random();
        this.needFood = 0;
        this.needSleep = 0;
        this.needLove = 0;
    }

    //Abstract methods
    public abstract void initializeCutoffs();
    public abstract String getType();

    public Random getBrain() {
        return brain;
    }

    public String getPetName() {
        return petName;
    }

    public String getFood(){
        return "ate";
    }

    public String getSleep(){
        return "sleep";
    }

    public String getLove(){
        return "love";
    }

    public void setNeedFood(int needFood) {
        this.needFood = needFood;
    }

    public void setNeedSleep(int needSleep) {
        this.needSleep = needSleep;
    }

    public void setNeedLove(int needLove) {
        this.needLove = needLove;
    }

    //Used in-class code to implement this function

    /**
     * Performs a series of actions for a pet at a certain hour
     * @return an arraylist of actions for a pet at a certain hour
     */
    public ArrayList<String> act(){
        ArrayList<String> actions = new ArrayList<String>();
        int decider = brain.nextInt(10);
        if(decider < needFood){
            actions.add("The " + getType() + ", "+ petName + ", ate.");
        }
        decider = brain.nextInt(10);
        if (decider < needSleep){
            actions.add("The " + getType() + ", "+ petName + ", slept.");
        }
        decider = brain.nextInt(10);
        if (decider < needLove){
            actions.add("The " + getType() + ", " + petName + ", sought your attention.");
        }
        return actions;
    }

    /**
     * Formats the string
     * @return a formatted string
     */
    public String toString(){
        return String.format("%s, %s",getType(), getPetName());
    }
}