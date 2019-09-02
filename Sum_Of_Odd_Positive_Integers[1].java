/*
*Question R 1.6

Write a short Java method that takes an integer n and returns the sum of all the
odd positive integers less than or equal to n
*/

import java.util.Scanner;

public class Sum_Of_Odd_Positive_Integers { //name of the class
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // scanner object to read inputs from user
        System.out.print("Please enter in any positive integer:"); // prints out this message to the user
        int num = input.nextInt();
        int sum = 0;
        for(int i = 1; i <= num; i++) {
            if(i % 2 !=0) {
                sum = sum + i;
            } // closes if
        } // closes for loop
        System.out.println("The sum of all positve odd integers less than or equal to " +num + "is" + sum + "."); //output message for final result
    } // closes main class
} //closes Sum_Of_Odd_Positive_Integers class