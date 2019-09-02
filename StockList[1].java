/* ========================================================================== */
/*  PROGRAM List of Stocks
    AUTHOR: <Kelli Kinnikin and Alex Grant>
    COURSE NUMBER: <CIS 210>
    COURSE SECTION NUMBER: <01>
    INSTRUCTOR NAME: <Guanyu Tian>
    PROJECT NUMBER: <7>
    DUE DATE: 10/19/2017
    
SUMMARY:
> You are required to read in a list of stocks from a text file and write the sum
and average of the stocks, the name of the stock that has the highest price, and the
name of the stock that has the lowest price to an output file. The minimal number 
of stocks is 30 and maximal number of stocksin the input file is 50. 

INPUT:
> Input file name
> Output file name
> An input file that contains a list of stocks with their name, symbol, current price. 
> Each line represents one stock and each field is separated by comma. 
> The file MUST contain at least 30 stocks. 

OUTPUT:
> The sum of the list of stocks
> Average of the list of stocks, 
> The name of the stock with highest price
> The name of the stock with lowest price
> Writes them to the console, 
> Writes them to a file.
*/
import java.io.*;		
import java.util.Scanner;	

public class StockList {
    public static void main(String[] args) throws IOException {
        Stock object_list = new Stock();//This declares and initializes the Stock object
        String input_file = new String();//This declares and initializes String 
                                        //objects for both the input and output file names
        String output_file = new String();
        Scanner input = new Scanner(System.in);
        
        System.out.print("Please type the name of the input file: "); 
        object_list.SetInputFileName(input.nextLine());//Sets the input file name as the user input
        input_file = object_list.GetInputFileName();//This sets the String object for the input 
                                                       //file as the given input file name
        System.out.print("Please type the name of the output file: ");
        //Print the command to enter the output file name
        object_list.SetOutputFileName(input.nextLine());//Sets output file name as the user input
        output_file = object_list.GetOutputFileName();//This sets the String object for the 
                                                     //output file as the given output file name
       
        PrintWriter file_output = new PrintWriter(output_file);//This declares and initializes 
                                                                 //the output file object
        
        Stock [] array = object_list.StockInformation(input_file, file_output);
        //Sets the stock object array as the object array for the list of stocks
        object_list.FindSum(array, file_output);//Finds and prints out the sum of the stock prices
        object_list.FindAverage(array, file_output);//Finds+prints out the average of stock prices
        object_list.FindHighestPriceStock(array, file_output);//Finds+prints out the highest stock price
        object_list.FindLowestPriceStock(array, file_output);//Finds+prints out the lowest stock price
        input.close();//Closes the input object and output object
        file_output.close();
    }
}