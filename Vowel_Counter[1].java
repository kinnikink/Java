/*
Question R-1.8 on page 55
Write a short Java method that counts the number of vowels in a given character
string.
*/

import java.util.Scanner;

public class Vowel_Counter {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner (System.in); // reads in inputs from user
        System.out.print ("Please insert any word or sentence to get the number of vowels:"); // output message for the user
        String word = input.nextLine();
        
        int vowelCount =0; //sets initial vowel count to 0
        char[] vowelCheck = word.toCharArray();//takes the word and checks for any vowels
        for (int i = 0; i < word.length(); i++) {
            if (vowelCheck[i] == 'a'|| vowelCheck[i] == 'e' || vowelCheck[i] == 'i' || vowelCheck[i] == 'o' || vowelCheck[i] == 'u') {
                // checks each word specifcally for letters a,e,i,o,u(vowels)
                vowelCount = vowelCount + 1; // if vowels are found, adds 1 to the vowelCount object
            } //closes if on line 20
    } //closes for loop
    System.out.println("There are " + vowelCount + "vowel letter(s) in :: " + word);
    } //closes main class
} // closes Vowel_Counter class