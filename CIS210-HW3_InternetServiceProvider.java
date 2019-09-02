/* ========================================================================== */
/*	PROGRAM Internet Service Provider
    AUTHOR: <Kelli Kinnikin and Alex Grant>
    COURSE NUMBER: <CIS 210>
    COURSE SECTION NUMBER: <01D>
    INSTRUCTOR NAME: <Guanyu Tian>
    PROJECT NUMBER: 3 
    DUE DATE: 09/14/2017

SUMMARY:

Write a program that calculates a customer’s monthly bill. It should ask the user to enter the
letter of the package the customer has purchased (A, B, or C) and the number of hours that were
used. It should display the total charges. In addition, it should display the amount of money
Package A customers would save if they purchased Package B or C, and the amount of money
Package B customers would save if they purchased Package C. If there would be no savings, no
message should be printed. 

INPUT:
> The type of package a customer has purchased (A, B, or C) 
>The number of hours thata customer accessed the Internet

OUTPUT:
>The amount of money a customer will pay
> The amount of money a customer will save if he or she purchase Package B or C
> The amount of money must following a ‘$’ and have 2 decimal points
/* MAIN FUNCTION */
package hw3_internetserviceprovider;
import java.util.Scanner;

public class Hw3_InternetServiceProvider {
 public static void main(String [] args){ 
	   
	   char package_letter = 'q';
	   int hours_Used;
	   double PACKAGE_A_MONTHLY_RATE=9.95;
	   double PACKAGE_B_MONTHLY_RATE=13.95;
	   double PACKAGE_C_MONTHLY_RATE=19.95;
	   double PACKAGE_A_HOURLY_RATE=2.00;
	   double PACKAGE_B_HOURLY_RATE=1.00;
	   int PACKAGE_A_BASE_HOUR=10;
	   int PACKAGE_B_BASE_HOUR=20;
	   double total_Cost_Package_A;
	   double total_Cost_Package_B;
	   double savings_Package_B;//savings if switch to package B
	   double savings_Package_C;//savings if switch to package C
	   double savings_Package_A;//savings if switch to package A
	   Scanner keyboard = new Scanner(System.in);
	   
	   System.out.print("Please enter the letter of the package:");
	   package_letter=keyboard.nextLine().charAt(0);
	   while(package_letter != 'a' && package_letter != 'A' && package_letter != 'b' && package_letter != 'B' 
                   && package_letter != 'c' && package_letter != 'C') {
               System.out.print("ERROR: Please enter a valid package letter: ");
               package_letter=keyboard.nextLine().charAt(0);
           }
	   System.out.print("Please enter the number of hours used:");
	   hours_Used=keyboard.nextInt();
	   keyboard.close();
	   //Package A
	   if(package_letter=='A'|| package_letter=='a') {
		   if(hours_Used<=PACKAGE_A_BASE_HOUR) {
			   System.out.printf("Total Cost is $%.2f.\n",PACKAGE_A_MONTHLY_RATE);
			   System.out.print("Good bye\n");
		   } 
		   
		   else if(hours_Used>PACKAGE_A_BASE_HOUR) {
			   total_Cost_Package_A=((hours_Used-PACKAGE_A_BASE_HOUR)*PACKAGE_A_HOURLY_RATE)+PACKAGE_A_MONTHLY_RATE;
			   System.out.printf("Total Cost is $%.2f.\n",total_Cost_Package_A);
			   
			   //calculate the money the user will save ifthey switch to package B
			   savings_Package_B=total_Cost_Package_A-PACKAGE_B_MONTHLY_RATE;
                           if(savings_Package_B>=0.01)
			   System.out.printf("Customer A can save $%.2f if he purhcases package B.\n", savings_Package_B);
			   
			   //calculate the money the user will save if they switch to package C
			   savings_Package_C=total_Cost_Package_A-PACKAGE_C_MONTHLY_RATE;
                           if(savings_Package_C>=0.01)
			   System.out.printf("Customer A can save $%.2f if he purhcases package C.\n",savings_Package_C);
			   System.out.print("Good bye\n");
			   
		   }
	   }
	   //Package B
	   else if(package_letter=='B'||package_letter=='b') {
		   if ( PACKAGE_A_BASE_HOUR<hours_Used &&hours_Used<=PACKAGE_B_BASE_HOUR) {
			   System.out.printf("Total Cost is $%.2f.\n", PACKAGE_B_MONTHLY_RATE);
			   System.out.print("Good bye\n");
		   }
		   
		   else if(hours_Used>PACKAGE_B_BASE_HOUR) {
			   total_Cost_Package_B=(hours_Used-PACKAGE_B_BASE_HOUR+PACKAGE_B_MONTHLY_RATE)*PACKAGE_B_HOURLY_RATE;
			   System.out.printf("Total Cost is $%.2f.\n",total_Cost_Package_B);
			
			   //calculate the money the user will save if switch to package C
			   savings_Package_C=total_Cost_Package_B-PACKAGE_C_MONTHLY_RATE;
                           if(savings_Package_C>=0.01)
			   System.out.printf("Customer A can save $%.2f if he purhcases package C.\n",savings_Package_C);
			   System.out.print("Good bye\n");   
		   }
		   
		   else if(hours_Used<=PACKAGE_A_BASE_HOUR) {
			   //Total Cost
			   System.out.printf("Total Cost is $%.2f.\n",PACKAGE_B_MONTHLY_RATE);
			   //calculate the money the user will save if they switch to package A
			   savings_Package_A=PACKAGE_B_MONTHLY_RATE-PACKAGE_A_MONTHLY_RATE;
			   System.out.printf("Customer A can save $%.2f if he purhcases package A.\n",savings_Package_A); 
		   }
	   }
	   //Package C
	   else if(package_letter=='C'||package_letter=='c'){
		   if(hours_Used>PACKAGE_B_BASE_HOUR){
		   System.out.printf("Total Cost is $%.2f ",PACKAGE_C_MONTHLY_RATE);
		   System.out.print("Good bye");
		   }
		   else if(hours_Used>PACKAGE_A_BASE_HOUR && hours_Used<=PACKAGE_B_BASE_HOUR) {
			   System.out.printf("Total Cost is $%.2f.\n",PACKAGE_C_MONTHLY_RATE);
			   //Calculate savings if customer switches to package B
			   savings_Package_B=PACKAGE_C_MONTHLY_RATE-PACKAGE_B_MONTHLY_RATE;
			   System.out.printf("Customer A can save $%.2f if he purhcases package B.\n",savings_Package_B);   
		   }
		   else if(hours_Used<=PACKAGE_A_BASE_HOUR){
			   System.out.printf("Total Cost is $%.2f.\n ",PACKAGE_C_MONTHLY_RATE);
			   //Calculate savings if customer switches to package a
			   savings_Package_A=PACKAGE_C_MONTHLY_RATE-PACKAGE_A_MONTHLY_RATE;
			   System.out.printf("Customer A can save $%.2f if he purhcases package A.\n",savings_Package_A); 
		   }
	   }   
	   else {
		   System.out.println("Incorrect letter choice.");
		   System.out.print("Please restart the program and input either A,B,C\n");
	 }
 }
}

