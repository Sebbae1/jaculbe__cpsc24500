package PCConfigurator;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.IOException;


/**
 * The PC Configurator program helps the user create a PC.
 * Asks the user how many PCs the user wants to create.
 * Then asks what file the receipt should be printed on.
 * Then asks the user what upgrades should be added to the PC and the specific type of upgrade.
 * Once the user is done creating a PC, the total cost of the PC and the selected upgrades are printed
 * to the receipt file and displayed to the prompt.
 */
public class PCConfigurator {
    /**
     * The main method that creates and initializes variables and runs other methods.
     * @param args command-line parameter
     */
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        banner();

        System.out.println("How many PCs do you want to purchase?");
        int numOfPCs = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter the file name for your receipt: ");
        String fileName = scan.nextLine();
        PrintWriter pw = null;

        //The Print Writer is set to null until the file can be opened.
        while(pw == null) {
            //Attempts to open the file and catches any errors if any problems occur while opening the file
            try {
                pw = new PrintWriter(new BufferedWriter((new FileWriter(new File(fileName)))));

            } catch (IOException e) {
                System.out.println("An error occurred. Please try again");
                break;
            }
        }

        //totalCost variable created outside the scope of the for loop
        double totalCost = 0;


        //The for loop runs the number of times the user wants to create a PC
        for (int i = 1; i <= numOfPCs; i++) {
            //Variables created and initialized
            String processorDesc = " ";
            String graphDesc = " ";
            String memoryDesc = " ";
            String monitorDesc = " ";
            System.out.printf("PC #%d\n",i);
            System.out.println("____\n");
            double costOfPC = 1750;

            int userSelection;
            do {
                System.out.print("""
                        What would you like to upgrade?
                        1. Processor
                        2. Graphics Card
                        3. Memory
                        4. Monitor
                        5. Nothing Else - I'm Done.
                        Enter the number of your choice: 
                        """);
                userSelection = scan.nextInt(); //This scans the type of upgrade
                int itemSelection;
                if (userSelection == 1) {
                    System.out.print("Update the processor to [1] Intel i7 ($200), [2] Intel i9 ($300), " +
                            "[3] AMD 9 5950 ($500): ");
                    itemSelection = scan.nextInt(); //This scans the specific modification of the upgrade
                    System.out.println();
                    //The if statement makes sure the user inputs the correct number and handles the error properly
                    if(itemSelection > 0 && itemSelection < 4) {
                        //Switch statements are used to add values to the variables that are outside the for loop
                        switch (itemSelection) {
                            case 1:
                                costOfPC += 200;
                                processorDesc = "Processor: Intel i7\n";
                                break;
                            case 2:
                                costOfPC += 300;
                                processorDesc = "Processor: Intel i9\n";
                                break;
                            case 3:
                                costOfPC += 500;
                                processorDesc = "Processor: AMD 9 5950\n";
                                break;
                            default:
                                processorDesc = "";
                        }
                    } else {
                        System.out.println("Invalid Input. Try again.\n");
                    }
                } else if (userSelection == 2) {
                    System.out.print("Update the graphics card to [1] NVidia 3060 ($150), [2] NVidia 4060 ($250), " +
                            "[3] NVidia 4080 ($350): ");
                    itemSelection = scan.nextInt();
                    System.out.println();
                    if (itemSelection > 0 && itemSelection < 4) {
                        switch (itemSelection) {
                            case 1:
                                costOfPC += 150;
                                graphDesc = "Graphics Card: NVidia 3060\n";
                                break;
                            case 2:
                                costOfPC += 250;
                                graphDesc = "Graphics Card: NVidia 4060\n";
                                break;
                            case 3:
                                costOfPC += 350;
                                graphDesc = "Graphics Card: NVidia 4080\n";
                                break;
                            default:
                                graphDesc = "";
                        }
                    } else {
                        System.out.println("Invalid Input. Try again.\n");
                    }
                } else if (userSelection == 3){
                    System.out.print("Increase the memory to [1] 16GB ($150), [2] 32GB ($250): ");
                    itemSelection = scan.nextInt();
                    System.out.println();
                    if (itemSelection > 0 && itemSelection < 3) {
                        switch (itemSelection) {
                            case 1:
                                costOfPC += 150;
                                memoryDesc = "Memory: 16GB\n";
                                break;
                            case 2:
                                costOfPC += 250;
                                memoryDesc = "Memory: 32GB\n";
                                break;
                            default:
                                memoryDesc = "";
                        }
                    } else {
                        System.out.println("Invalid Input. Try again.\n");
                    }
                } else if (userSelection == 4){
                    System.out.print("Add a monitor of size [1] 24 inches ($200), [2] 27 inches ($250), " +
                            "[3] 32 inches ($350): ");
                    itemSelection = scan.nextInt();
                    System.out.println();
                    if (itemSelection > 0 && itemSelection < 4) {
                        switch (itemSelection) {
                            case 1:
                                costOfPC += 200;
                                monitorDesc = "Monitor: 24 inches\n";
                                break;
                            case 2:
                                costOfPC += 250;
                                monitorDesc = "Monitor: 27 inches\n";
                                break;
                            case 3:
                                costOfPC += 350;
                                monitorDesc = "Monitor: 32 inches\n";
                                break;
                            default:
                                monitorDesc = "";
                        }
                    } else {
                        System.out.println("Invalid Input. Try again.\n");
                    }
                } else if (userSelection == 5){
                    System.out.printf("You have chosen these options for a PC with a total cost of $%.2f:\n\n", costOfPC);
                    if(!processorDesc.equals("")) {
                        System.out.print(processorDesc);
                    }

                    if(!graphDesc.equals("")){
                        System.out.print(graphDesc);
                    }

                    if(!memoryDesc.equals("")){
                        System.out.print(memoryDesc);
                    }

                    if(!monitorDesc.equals("")) {
                        System.out.print(monitorDesc);
                    }
                    System.out.println("\n");
                } else if (userSelection < 0 || userSelection > 6) {
                    System.out.println("Invalid Input. Try again.\n");
                }
            } while (userSelection != 5 && userSelection > 0 && userSelection < 6);

            //Prints to the file provide by the user
            pw.printf("PC #%d ($%.2f):\n",i,costOfPC);
            if(!processorDesc.equals("")) {
                pw.printf(processorDesc);
            }

            if(!graphDesc.equals("")){
                pw.printf(graphDesc);
            }

            if(!memoryDesc.equals("")){
                pw.printf(memoryDesc);
            }

            if(!monitorDesc.equals("")) {
                pw.printf(monitorDesc);
            }
            pw.println("\n");
            totalCost += costOfPC;
        }

        pw.printf("Total cost of the %d PC(s): %.2f\n",numOfPCs,totalCost);
        System.out.printf("The total cost of your order of %d PC(s) is $%.2f\n", numOfPCs, totalCost);
        System.out.printf("Your order has been saved to %s\n", fileName);
        System.out.println("Thank you for shopping with us.");

        //Closes the Print Writer
        pw.close();
    }

    /**
     * Displays the banner for the program
     */
    public static void banner(){
        System.out.print("""
                ***************************************
                *                                     *
                *\tWelcome to the PC Configurator    *
                *                                     *
                ***************************************
                """);
    }
}