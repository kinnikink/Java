/* ========================================================================== */
/*PROGRAM Simple Algorithm Trader
    AUTHOR: <Kelli Kinnikin>
    COURSE NUMBER: <CIS 210>
    COURSE SECTION NUMBER: <01>
    INSTRUCTOR NAME: <Guanyu Tian>
    PROJECT NUMBER: <8>
    DUE DATE: <11/7/2017>

Summary:
> Assume that you are a software developer for an investment bank on Wall Street, New York. 
Your boss asks you to design a trading strategy and test it. You will design a set of classes 
that work together to simulate buying and selling a stock. The classes you will design are the 
following:

1.) The Stock Class: this class will represent a stock. You need to decide the member variables 
of this class based on the input file. This input file is given to you and it is a 
â€œcomma-separated-valueâ€� file (.csv). You can open a .csv file using Microsoft Excel.

2.)The AlgorithmTrader Class: this class will simulate the stock trading activities. 
Its responsibilities are as follows:
    >Read stock minute-by-minute data from an input file, MSFT.csv.
    >Store stock minute-by-minute data in an Array List.
    >Decide when to buy and sell a stock using the simple algorithm.
    
> Entry position strategy: if a stockâ€™s share price increases 5 times consecutively,
then you buy 10,000 shares based on the current price.

> Exit position strategy: if your current position is gaining 0.12% profit or losing 0.12%,
then you sell all the shares you are holding base on the current price.

> Special Exit strategy: if you are still holding a stock at the last minute of a trading day, 
you MUST sell all of the shares you own. Because the risk of losing money is too big during the
after hour trading period.

3.)Simulate buying and selling stocks.

4.)Write a summary of transactions, Profit/Loss for each minute. Please see the
tradingSummary-sample.csv file on Shoology.

*** Note, the AlgorithmTrader class MUST use an array of objects of the Stock class.***

5.)Demonstrate the classes by creating instances of each class. Create the main class 
SimpleAlgorithmTradingPlatform.java. Simulate one day of trading stocks. 
The main method must ask user to enter an input file name, create an object of the 
AlgorithmTrader class, open an output file (.csv file) and write data to it, and call the methods
of the AlgorithmTrader object.

INPUT:
> The name of the input file which stores a stockâ€™s minute-by-minute data. Please download
the MSFT.csv file from Schoology. This input is from the userâ€™s keyboard. If the file doesnâ€™t 
exist, please print an appropriate message and terminate the program.

OUTPUT:
> Your program should create an output file and store it on your computer disk. 
Your output file must be a .csv file. Please name the file tradingSummary.csv.
 
*/
import java.io.*;
import java.util.Scanner;
public class SimpleAlgorithmTradingPlatform {
/**
* The main method for the SimpleAlgorithmTradingPlatform
* @param args
* @throws IOException
*/
    public static void main(String[] args) throws IOException {
        //prints the command to put in the input file
	System.out.print("Please type the name of the csv file (including the .csv portion of the name): ");
	//declares the scanner input object for the input file name
	Scanner input = new Scanner(System.in);
	//this sets the string variable to the user input file
	String fName = input.nextLine();
	//declares and initializes to the output file the PrintWriter object.
	//used to print to the given file.
	PrintWriter f = new PrintWriter("TradingSummary.csv");
	//deletes the data before printing this sessions content
	f.flush();
	//declares a new AlgorithmTrader object to be used to execute the run() method
	AlgorithmTrader trader = new AlgorithmTrader();
	trader.Run(fName, f);
	f.close();
	input.close();
    }
}