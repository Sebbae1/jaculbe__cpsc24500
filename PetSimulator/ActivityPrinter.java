package PetSimulator;

import java.util.ArrayList;

/**
 * ActivityPrinter class prints out the results onto the console.
 */
public class ActivityPrinter {
    /**
     * Prints out each of the actions per hour. The for loop prints out as many times as the length of the array.
     * @param actions - takes in an arraylist containing an arraylist of actions
     */
    public static void printHourlyActivities(ArrayList<ArrayList<String>> actions){
        for(int i = 0; i < actions.size(); i++){
            System.out.println(" ");
            System.out.printf("\t\t\t\t*** Hour %d ***\n",i+1);
            System.out.println(" ");
            for (String action : actions.get(i)) {
                System.out.println(action);
            }
            System.out.println();
        }
    }
}