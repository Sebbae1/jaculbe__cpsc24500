package PetSimulator;

import java.util.ArrayList;
import java.util.Random;

/**
 * Dog class extends Pet.
 */
public class Dog extends Pet{
    public int playFetch;

    //Fellow student Kevin advised me to create a constructor for each animal.
    /**
     * Dog Constructor
     * @param name - takes the Dog's name as the parameter
     */
    public Dog(String name){
        super(name);
        initializeCutoffs(); //ChatGPT helped me because it was not being used at first, which caused problems.
    }

    /**
     * Initializes the desire levels for Dog.
     */
    @Override
    public void initializeCutoffs(){
        setNeedFood(4);
        setNeedSleep(7);
        setNeedLove(9);
        playFetch = 6;
    }

    /**
     * Gets the type of animal.
     * @return the String, Dog
     */
    @Override
    public String getType(){
        return "Dog";
    }

    /**
     * Performs a series of actions from the Pet class and then performs
     * the Dog's unique action in this class.
     * @return an arraylist of the Dog's actions at an hour.
     */
    @Override
    public ArrayList<String> act(){
        ArrayList<String> result = super.act();
        Random decider = getBrain();
        int picker = decider.nextInt(10);
        if (picker < playFetch){
            result.add("The " + getType() + ", " + getPetName() + ", played fetch.");
        }
        return result;
    }
}