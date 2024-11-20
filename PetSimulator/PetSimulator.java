package PetSimulator;

import java.util.ArrayList;

/**
 * Pet Simulator simulates the Pet class and retrieves the actions of each animal at each animal.
 */
public class PetSimulator {
    private ArrayList<Pet> pets;

    /**
     * PetSimulator Constructor
     * @param pets - an arraylist of Pet consisting the actions from each Pet
     */
    public PetSimulator(Pet[] pets) {
            this.pets = new ArrayList<>();
            for(Pet pet : pets) {
                this.pets.add(pet);
            }
        }

    /**
     * Simulate method to simulate the actions performed by each pet at each hour.
     * @param hourCount - takes in the number of hours to simulate through
     * @return an arraylist of actions by each animal at each hour of the day
     */
    public ArrayList<ArrayList<String>> simulate(int hourCount){
            ArrayList<ArrayList<String>> hourlyActivity = new ArrayList<>();
            for(int i = 0; i < hourCount; i++){
                ArrayList<String> thisHoursActivities = new ArrayList<>();
                for(Pet pet: pets){
                    ArrayList<String> thisPetsActivitiesThisHour = pet.act();
                    thisHoursActivities.addAll(thisPetsActivitiesThisHour);
                }
                hourlyActivity.add(thisHoursActivities);
            }
            return hourlyActivity;
        }
}