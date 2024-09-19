package FortuneTeller;/*
Sebastian Jaculbe - Programming Assignment - Fortune Teller
Program asks the user three questions and assigns the user a random lucky number.
The lucky number is then used to calculate its percentage of the user's age.
The program that outputs a series of lines with the user's inputs and
calculated percentage.
*/

import java.util.Random;
import java.util.Scanner;

public class FortuneTeller {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Random ran = new Random();
        String userName;
        String userColor;
        int userAge;
        int luckyNumber = ran.nextInt(10) + 1;

        System.out.print("""
                ************************************************
                \t\tWelcome to the Fortune Teller!
                ************************************************
                """);
        System.out.println();
        System.out.print("Please enter your full name: " );
        userName = scan.nextLine();
        System.out.print("How old are you? ");
        userAge = scan.nextInt();
        scan.nextLine();
        System.out.print("What is your favorite color? ");
        userColor = scan.nextLine();
        System.out.println();

        /*Looked up the formula to find the percentage of a number within a number*/
        float luckyNumPer =((float)luckyNumber / userAge) * 100;

        System.out.printf("Welcome, %S.\n", userName);
        System.out.printf("I see you are %d years old.\n", userAge);
        System.out.printf("Your favorite color is %s.\n",userColor);
        System.out.printf("Your lucky number is %d.\n",luckyNumber);
        System.out.printf("Your lucky number is %.03f percent of your age.\n\n",luckyNumPer);

        System.out.println("Thank you for coming to the Fortune Teller!");
    }
}
