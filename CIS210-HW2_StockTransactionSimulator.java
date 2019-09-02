/* ========================================================================== */
/*	PROGRAM Stock Transaction Simulator

    AUTHOR: <Kelli Kinnikin and Alex Grant>
    COURSE NUMBER: <CIS210>
    COURSE SECTION NUMBER: <01D>
    INSTRUCTOR NAME: <Guanyu Tian>
    PROJECT NUMBER: 2 
    DUE DATE: 09/07/2017

SUMMARY:
Last month Tian purchased some stock in Acme Software, Inc.The number of shares that Tian purchased was 1,000.
When Tian purchased the stock, he paid $33.92 per share. Tian paid his stockbroker a commission that amounted
to 2% of the amount he paid for the stock.One week later, Tian sold the stock.The number of shares sold was
1,000.He sold the stock for $36.78 per share.He paid his stockbroker another commission that amounted to 2% 
of the amount he received for the stock.

INPUT:
This program requires that you read in the following data values:
> Number of shares to buy (an integer)
> Price to be bought (a real number)
> Number of shares to sell (an integer)
> Price to be sold (an integer)

OUTPUT:
>Name
>The number of shares you want to purchase
>Purchase price:
>The number of shares you want to sell
>Sold price


/* MAIN FUNCTION */

package stocktransactionsimulator;
import java.util.Scanner;

public class StockTransactionSimulator {

    public static void main(String[] args) {
        
        double current, xcurrent, fee, fee2, profit, totalprofit;
        String name; //creates string object for the user's name                                                                    
        
        Scanner userInput = new Scanner(System.in);     // allows console to recieve input from keyboard from user
        
        System.out.println("What is your name?");   // asks for users name
        name = userInput.nextLine();    // takes in and stores string name of user
        
        System.out.println( name + ", At what price would you like to purchase shares of Ford motor company?"); //prompts user for price to purchase shares at
        current = userInput.nextDouble();   //input for the value
        current = Math.round(current * 100);    //rounds to two decimal places
        current = current/100;  //rounds to two decimal places
        
        System.out.println( name + ", How many shares would you like to purchase?");    // prompts user for amount of shares to purchase
        int numBuy = userInput.nextInt();   //inputs number of shares to buy
        double initialValue = current*numBuy;   //calculates value 
        fee = initialValue*.02;     //calculates broker's fee
        fee = Math.round(fee * 100);    //rounds to two decimal places
        fee = fee/100;  //rounds to two decimal places
        
        System.out.println( name + " is buying " + numBuy + " shares from Ford motors at $" + current +  " for a total of $" + initialValue + " and paying his broker 2% of the transaction " + "($" + fee + ").");
        System.out.println("What price would you like to sell at?");
        xcurrent = userInput.nextDouble();  //takes user input for the price to sell
        xcurrent = Math.round(xcurrent * 100);  //rounds double value to hundredths
        xcurrent = xcurrent/100;    //rounds double value to hundredths
       
        System.out.println("How many shares would you like to sell?");  //prompts user for amount of shares to sell
        int numSell = userInput.nextInt();  //takes user input for number of shares to sell
        double endvalue = xcurrent*numSell;     //creates variable for total value of portfolio after selling shares
        fee2 = endvalue*.02;    //calculates broker's fee
        fee2 = Math.round(fee2 * 100);  //rounds double value to hundredths
        fee2 = fee2/100;    //rounds double value to hundredths place
        
        System.out.println( name + " intitally purchased " + numBuy + " shares at $" + current + " for a total portfolio value of $" + initialValue + " with a broker's fee of $" + fee + ".");     //gives overview of all transactions and values before selling shares
        totalprofit = endvalue-initialValue-fee-fee2;   //defines the algorithm to calculate total profit, which is end value minus initial value minus both sets of broker's fees
        profit = endvalue-initialValue;     //defines algorithm used to calculate raw profit before deductions
        System.out.println( name + " sold " + numSell + " at a price of $" + xcurrent + " for a total profit of $" + profit + " with $" + fee2 + " in broker's fees.");     //gives overview of all transactions and input given after the sale was complete
        System.out.println("Profit before broker's fees paid: $" + profit);     //outputs profit    
        System.out.println("Profit after paying broker's fees: $" +totalprofit );   //outputs profit after deductions
    }
    
}