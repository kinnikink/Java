/*
Question P-1.26 on page 57
Write a short Java program that takes all the lines input to standard input and
writes them to standard output in reverse order. That is, each line is output in the
correct order, but the ordering of the lines is reversed.
*/
import java.util.*;

public class Reversed_Output {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the number of lines you want to output:"); //intructions printed to the console for user
        int counter = input.nextInt(); //moves to next line on the console
        ArrayList<String> list = new ArrayList < String> ();
        for(int i = 0; i < counter; i++) { // string counter
            System.out.print("Enter a word or phrase to add to the array:");// print message for user
            list.add(input.next()); // adds the word or phrase to the list to be printed in reverse order
        } //closes for loop on line 16
        System.out.println("\nHere is what you entered, but in reverse order"); // prints output to the console
        for(int i = counter - 1; i >= 0; i--) { // increments the lines backwards
            System.out.println(list.get(i));
        } //closes for loop on line 21
    } //closes main
} //closes Reversed_Output