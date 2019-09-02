/*
Question C-1.20 on page 96
Write a Java method that takes an array of float values and determines if all the
numbers are different from each other (that is, they are distinct).
*/

import java.util.Scanner;

public class Distinct_Values {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("This program states whether or not a list of numbers has distinct numbers or not");
        
        System.out.print("Please enter the amount of numbers in the list:"); //prints the user to enter an amount
        int size = input.nextInt();// outputs on the next line
        float[] floatArray = new float[size]; //gets size of the array
        
        for (int i=0; i < size; i++) {
            System.out.print("Enter number " + (i+1) + ":");
            floatArray[i] = input.nextInt();
        } //closes for loop
        boolean same = true;
        for(int i = 0; i < size; i++) {
            for(int k = 0; (k+1) < size; k++) {
                if(floatArray[i] == floatArray[k]) {
                    same = false;
                    break; //breaks out of this loop
                } //closes loop on line 25
            } //closes for loop on line 24
        } //closes for loop on line 23
        System.out.println(" ");
        if(same == true) { //if no numbers match, prints the below message
            System.out.println("The list of numbers is distinct, no numbers match one another."); //prints
        } //closes loop on line 32
        else if(same == false) { //if numbers match, prints the below message
            System.out.println("The list of number is not distinct, one or more of the numbers match one another.");
        } //close else if loop
    } //closes main 
} //closes Distinct_Values class