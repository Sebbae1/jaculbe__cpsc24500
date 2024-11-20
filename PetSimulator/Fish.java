package PetSimulator;

import java.util.ArrayList;
import java.util.Random;

public class Fish extends Pet{
    private int swim;

    //Fellow student Kevin advised me to create a constructor for each animal.
    /**
     * Fish Constructor
     * @param name - takes the Fish's name as the parameter
     */
    public Fish(String name){
        super(name);
        initializeCutoffs(); //ChatGPT helped me because it was not being used at first, which caused problems.
    }

    /**
     * Initializes the desire levels for Fish.
     */
    @Override
    public void initializeCutoffs(){
       setNeedFood(3);
       setNeedSleep(1);
       setNeedLove(0);
       swim = 9;
    }

    /**
     * Gets the type of animal.
     * @return the String, Fish
     */
    @Override
    public String getType(){
        return "Fish";
    }

    /**
     * Performs a series of actions from the Pet class and then performs
     * the Fish's unique action in this class.
     * @return an arraylist of the Fish's actions at an hour.
     */
    @Override
    public ArrayList<String> act(){
        ArrayList<String> result = super.act();
        Random decider = getBrain();
        int picker = decider.nextInt(10);
        if (picker < swim){
            result.add("The " + getType() + ", " + getPetName() + ", swam around its bowl.");
        }
        return result;
    }
}