package PetSimulator;

import java.util.ArrayList;
import java.util.Random;

public class Cat extends Pet{
    private int scratch;

    //Fellow student Kevin advised me to create a constructor for each animal.
    /**
     * Cat Constructor
     * @param name - takes the Cat's name as the parameter
     */
    public Cat(String name){
        super(name);
        initializeCutoffs(); //ChatGPT helped me because it was not being used at first, which caused problems.
    }

    /**
     * Initializes the desire levels for Cat.
     */
    @Override
    public void initializeCutoffs(){
        setNeedFood(6);
        setNeedSleep(8);
        setNeedLove(2);
        scratch = 4;
    }

    /**
     * Gets the type of animal.
     * @return the String, Cat
     */
    @Override
    public String getType(){
        return "Cat";
    }

    /**
     * Performs a series of actions from the Pet class and then performs
     * the Cat's unique action in this class.
     * @return an arraylist of the Cat's actions at an hour.
     */
    @Override
    public ArrayList<String> act(){
        ArrayList<String> result = super.act();
        Random decider = getBrain();
        int picker = decider.nextInt(10);
        if (picker < scratch){
            result.add("The " + getType() + ", " + getPetName() + ", scratched the kitty post.");
        }
        return result;
    }
}