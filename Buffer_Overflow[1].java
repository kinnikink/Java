/*
Question R-2.14 on page 99
Give an example of a Java code fragment that performs an array reference that
is possibly out of bounds, and if it is out of bounds, the program catches that
exception and prints the following error message:
“Don’t try buffer overflow attacks in Java!”
*/

public class Buffer_Overflow {
    public static void main(String[] args) {
        int[] intList = new int[3]; //the amount of elements in the array
        System.out.println("The list has three elements in it, but what happens if we try to print four?"); //prints to the console
        for(int i =0; i< intList.length; i++) {
            intList[i] = i * 8 % 3;
        } // closes for loop
        try {
            for(int i = 0; i <= intList.length; i++) { // for loop to find the length of the list
                System.out.println(intList[i]); // prints the integer list
            } //closes for loop on line 17
        } // closes try
        catch(ArrayIndexOutOfBoundsException e) { //exception when you are out of bounds
            System.out.println("Don't try buffer overflow attacks in Java!" + e); // prints error message
        } // closes catch
    } // closes main method
} // closes Buffer_Overflow class