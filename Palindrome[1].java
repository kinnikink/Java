/*
 * HW3: Page 221: Problem C-5.18: Write a recursive and non-recursive algorithm to determine if a string s is a palindrome,
that is, it is equal to its reverse.
 */
/*
 * This program asks the user to enter a word, and checks to see if its palindrome or not.
 */
import java.util.Scanner;

public class Palindrome {  
    public static void main(String[]args) {
        Scanner keyboard = new Scanner(System.in);
	System.out.print("Please type a SINGLE word to check if it's a palindrome or not : ");//instructions for the user
	String x = keyboard.nextLine();
	System.out.println("Recursive");//recursive algorithm
	
        if(isPal(x)){
            System.out.println(x + " is a palindrome");//print message if the word is a palindrome
	}//closes if statement on line 17
        else {
            System.out.println(x + " is not a palindrome");//if the word is not a palindrome, this is the print statement that will be printeed
	}//closes else statement on line 20
        
	System.out.println("---------------------------------------------");//prints the separation of the two algorithms
    	System.out.println("Non Recursive");//non-recursive algorithm
        checkPalindrome(x); 
	keyboard.close();
    }//closes main class	
	
    //checks to see if the word is a palindrome
    public static boolean isPal(String s) {
        if(s.length() == 0 || s.length() == 1) {
            // if length =0 OR 1 then it is
                return true; 
	}//closes if statement on line 31
        
	if(s.charAt(0) == s.charAt(s.length()-1)) {
            // check for first and last char of String:
            // if they are same then do the same thing for a substring
            // with first and last char removed. and carry on this
            // until you string completes or condition fails
            return isPal(s.substring(1, s.length()-1));
        }//closes if statement on line 36	
	// if its not the case than string is not.
        return false;
    }//closes isPal

    public static void checkPalindrome(String s) {
        // reverse the given String
	String reverse = new StringBuffer(s).reverse().toString(); 
	// check whether the string is palindrome or not
	
        if (s.equals(reverse))
	System.out.println(s + " is palindrome");
	 
	else
	System.out.println(s + " is not a palindrome");
    }//closes checkPalindrome
	
}//closes Palindrome
