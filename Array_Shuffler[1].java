/*
Question C-1.21 on page 56
Write a Java method that takes an array containing the set of all integers in the
range 1 to 52 and shuffles it into random order. Your method should output each
possible order with equal probability.
*/

import java.util.Arrays;
import java.util.*;

public class Array_Shuffler {
    public static void main(String[] args) {
        int size = 52;// tells that there are 52 integers
        Integer [] list = new Integer[size];
        System.out.println("Here is the list of 1-52 before the shuffle:");
        // output message to show the beginning list of integers 1-52 before the shuffle
        for (int i=0; i<size; i++) {
            list[i] = size -i;
            System.out.print(list[i] + " ");
        } //closes for loop on line 17
        System.out.println("\n \nHere is the list after a every possble random shuffle: \n");
        for(int i = 0; i<(size*size);i++) {
            System.out.print("Random list" + (i+1) + ":");
            for(int k =0; k< size; k++) {
                System.out.print(list[k] + "");
            } //closes for loop on line 24
            System.out.println(" ");
        } //closes for loop on line 22
    } //closes main
} // closes Array_Shuffler