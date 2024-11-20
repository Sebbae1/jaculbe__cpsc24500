package PetSimulator;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Controller of the Pet Simulator. Contains the main function.
 */
public class App {
    /**
     * Banner prints out the welcome banner of the program.
     */
    public static void banner(){
        System.out.println("""
                ******************************************************************************
                Welcome to Pet Simulator. This tool simulates the activities of three kinds of
                pets: dogs, cats, and fish. Each pet may sleep, eat, and seek your attention
                for some part of the day. And each pet will do things specific to what kind of
                pet they are.
                ******************************************************************************
                """);
    }

    /**
     * Executes the program.
     * @param args
     */
    public static void main(String[] args){
        banner();

        //Prints out the program
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the dog's name: ");
        String dogName = scan.nextLine();
        Dog dog = new Dog(dogName);
        System.out.println("Enter the cat's name: ");
        String catName = scan.nextLine();
        Cat cat = new Cat(catName);
        System.out.println("Enter the fish's name: ");
        String fishName = scan.nextLine();
        Fish fish = new Fish(fishName);
        Pet[] pets = {dog, cat, fish};
        PetSimulator ps = new PetSimulator(pets);

        int hours = 0;

        do{
            //Try...catch checks if the hours variable has a valid input
            try {
                System.out.println("\nNow let's simulate.");
                System.out.println("How many hours of their lives would you like to display? ");
                hours = scan.nextInt();
                if (hours > 0) {
                    ArrayList<ArrayList<String>> activities = ps.simulate(hours);
                    ActivityPrinter.printHourlyActivities(activities);
                }
            } catch (NumberFormatException e){
                System.out.println("Please enter a number.");
            }
        } while (hours > 0);

        System.out.println("Thank you for using this program.");
    }
}