/* ========================================================================== */
/*	PROGRAM Calculate Triangle Area

    AUTHOR: Kelli Kinnikin/ Alex Grant
    COURSE NUMBER: CIS 210
    COURSE SECTION NUMBER: 01D
    INSTRUCTOR NAME: Dr. Guanyu Tian
    PROJECT NUMBER: 1 
    DUE DATE: 08/31/2017

SUMMARY

The area of a triangle can be calculated using the formula:

    area = (base * height) /  2

This program asks the user for the base and height of a triangle, and then 
prints the area of the triangle.

INPUT

The user interactively inputs the base and height, as an 
integer, in meters.

OUTPUT

The input base and height values are echoprinted. Then the area of the triangle is printed as a float number.

ASSUMPTIONS
- Base and height units are integers, in meters.
- When asked for a base/height value, the user types in a valid whole number.
- Error checking does not need to be done on this input value.

/* MAIN FUNCTION */

																								
import java.util.Scanner;																		//Scanner used to input values

public class CalculateTriangleArea{
   public static void main(String [] args){    
	   
	   																							// named constants
     final double DIVIDER = 2;              													// mathematical constant

     																							//named variables
  	 int height;                   																// the height of the triangle as a whole number
     int base;                    															    // the base of the triangle as a whole number
     double area;                  																// the area of the triangle as a float number    

     																							// print an intro output heading 
     System.out.println("Welcome to the Triangle Calculator!\n");
      System.out.println("You will be asked to enter the base and height of");
     System.out.println("a triangle, as a whole number, in meters.\n");
      System.out.println("Then this program will show you the area of");
     System.out.println("the triangle.");
     System.out.println("==================================================");

     																							//create an scanner object for read in values from the user
     Scanner input = new Scanner(System.in);
     
     																							//read in the height and echoprint
     System.out.println("Please enter the height of the triangle -> ");
     height = input.nextInt();
     System.out.println("The height of the triangle in meters (as input): " + height);
     
     																							//read in the base and echoprint
     System.out.println("Please enter the base of the triangle -> ");
     base = input.nextInt();
     System.out.println("The base of the triangle in meters (as input): " + base);
     
     																							//calculates the area of the triangle
     area = (base * height) / DIVIDER;
   
     																							// outputs the results 
     System.out.println("Area of the triangle in meters:  "+ area); 
    
    		 																					//close the input object
     input.close();
     
     																							// print a closing message and exit program 
     System.out.println("- Execution Terminated -");
     
	   
	   
    }
}

/* ========================================================================== */ 
/*                      E N D   O F   P R O G R A M                           */
/* ========================================================================== */



