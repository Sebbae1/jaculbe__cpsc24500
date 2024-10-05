package StarlightCoffee;

import java.util.Scanner;

/**
 *This program asks the user a series of questions with a list of options pertaining
 * to ordering a drink from Starlight Coffee's system.
 */
public class StarlightCoffee {
    /**
     * The main method that creates and initializes variables and runs other methods.
     * @param args command-line parameter
     */
    public static void main (String[]args){
        //Present the system banner
        banner();

        //Create and Initialize Variables
        Scanner scan = new Scanner(System.in);
        String coffeeName = " ";
        boolean member = false;
        int coffeeChoice;
        int coffeeSize;
        int shots;
        double coffeeSizePrice = 0;
        double shotsPrice;
        double memberDiscount;

        //Asks the user for their name
        System.out.println("What is your name?");
        String userName = scan.nextLine();

        //Asks for the coffee choice
        System.out.print("""
            What kind of coffee do you want?
            1. Americano
            2. Italiano
            3. Espresso
            4. Cappuccino
            Enter the number of your choice?
            """);
        coffeeChoice = scan.nextInt();

        //Assigns the coffee choice selection to a string
        if (coffeeChoice == 1){
            coffeeName = "Americano";
        } else if (coffeeChoice == 2){
            coffeeName = "Italiano";
        } else if (coffeeChoice == 3){
            coffeeName = "Espresso";
        } else if (coffeeChoice == 4){
            coffeeName = "Cappuccino";
        }

        //Asks for the size of the coffee
        System.out.print("""
                What size do you want?
                1. Tall
                2. Grande
                3. Venti
                Enter the number of your choice:
                """);
        coffeeSize = scan.nextInt();

        //Sets the size choice to a double type up-charge
        if(coffeeSize == 2){
            coffeeSizePrice = 0.20; //20% up-charge
        } else if (coffeeSize == 3){
            coffeeSizePrice = 0.40; //40% up-charge
        }

        //Asks for the number of shots in the drink
        System.out.printf("How many shots of %s would you like?\n", coffeeName);
        shots = scan.nextInt();
        scan.nextLine();
        shotsPrice = 0.50 * shots;

        //Checks if the user is a member
        System.out.print("Are you a member of Starlight Stars (y or n)?\n");
        if (scan.nextLine().equalsIgnoreCase("y")){
            member = true;
        }

        //Calculates the cost of the drink
        double costOfDrinks = calculateDrinkCost(coffeeChoice, coffeeSizePrice, shotsPrice);

        //Applies the discount if applicable
        if (member){
            memberDiscount = costOfDrinks * 0.10;
        } else {
            memberDiscount = 0;
        }

        //Calculates the finalized bill
        double tip = calculateTip(costOfDrinks, scan);
        double tax = costOfDrinks * 0.0875;
        double finalBill = (costOfDrinks + tip + tax) - memberDiscount;

        //Prints the user's bill
        printBill(userName, costOfDrinks, memberDiscount, tip, finalBill, tax, member);

        //Prints the closing statement
        System.out.println("Thank you for choosing Starlight Coffee!");
    }

    /**
     * The method displays the system's banner.
     * The method does not take any parameter.
     * The method does not return any values.
     */
    public static void banner() {
        System.out.print("""
                *************************************************\n
                \tSTARLIGHT COFFEE POINT-OF-SALE SYSTEM\n
                *************************************************
                """);
    }

    /**
     * The method calculates the tip.
     * @param costOfDrinks takes the value of the drink the user selected
     * @param scan scans for the user's input
     * @return the cost of the drink multiplied by the tip percentage as a double
     */
    public static double calculateTip(double costOfDrinks, Scanner scan){
        System.out.print("""
                What size tip would you like to leave?
                1. Good Service - 10%
                2. Great Service - 15%
                3. Outstanding Service - 20%
                Enter the number of your choice:
                """);
        int tip = scan.nextInt();
        double tipPercentage = 0;
        switch (tip) {
            case 1:
                tipPercentage = 0.10;
                break;
            case 2:
                tipPercentage = 0.15;
                break;
            case 3:
                tipPercentage = 0.20;
                break;
        }

        return costOfDrinks * tipPercentage;
    }

    /**
     * The method calculates the cost of the drink
     * @param beverage takes an int value of the user's number value which corresponds to the drink choice
     * @param size takes a double of the user's number value which corresponds to the size choice
     * @param shots takes a double of the calculated price of the number of shots
     * @return returns a double of the bill with summation of the beverageCost, size, and shots variables
     */
    public static double calculateDrinkCost(int beverage,double size, double shots) {
        double bill;
        double beverageCost = 0;

        //Uses the switch statement to find the user's drink choice and
        //assign a variable to a value
        switch (beverage) {
            case 1:
                beverageCost = 2.25;
                break;
            case 2:
                beverageCost = 2.75;
                break;
            case 3:
                beverageCost = 3.50;
                break;
            case 4:
                beverageCost = 3.75;
                break;
        }

        //Calculates the size charge to the beverage cost
        size = beverageCost * size;
        //Calculates the total cost of the drink
        bill = beverageCost + size + shots;

        //Returns the bill
        return bill;
    }

    /**
     * Prints the bill and the summary of it
     * @param name takes a String value the user's name
     * @param beverageCost takes a double value of the cost of the drink; accounting the beverage cost, size, and number of shots
     * @param discount takes a double of the discount if the user is a Starlight member
     * @param tip takes a double of the tip the user has chosen
     * @param bill takes a double of the total cost of the drink, including the tip and tax
     * @param tax takes a double of the percentage of tax on the user's drink
     * @param member takes a boolean which determines if a user is a starlight member or not
     */
    public static void printBill(String name, double beverageCost, double discount, double tip, double bill, double tax, boolean member){
        //Creates the bill output
        System.out.printf("Here is your bill %s:\n", name);
        System.out.printf("Beverage: $%.2f\n", beverageCost);
        if (member == true) {
            System.out.printf("Club Discount: $%.2f\n", discount);
        } else {
            System.out.println("Club Discount: $0.00");
        }
        System.out.printf("Tip Amount: $%.2f\n", tip);
        System.out.printf("Taxes: $%.2f\n", tax);
        System.out.printf("Total: $%.2f\n", bill);
    }
}