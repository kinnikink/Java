
import java.io.*;
import java.util.Scanner;

public class Stock {
    private String companyName;//String object holding the company's name
    private String companySymbol;//String object holding the company's symbol
    private String outputFileName;//String object holding the output file
    private String inputFileName;//String object holding the input file
    private double currentPrice;//Double holding Current Price of Stock
	
    final private int MIN_NUMBER_OF_STOCKS = 30;//holds the minimum number of stocks
    final private int MAX_NUMBER_OF_STOCKS = 50;//holds the maximum number of stocks
    /**
    * Determines if the default values should be used
    * @param cN
    * @param cS
    * @param cP
    */
    public void WhichDefaultValue(String cN, String cS, double cP) {
    //sets the name, symbols, and current price if they do not equal the default values
        if(!(cN.contentEquals("NONE")) && !(cS.contentEquals("NA")) && cP != 0.0) {
            SetName(cN);
            SetSymbol(cS);
            SetCurrentPrice(cP); 
        }
    }
    /**
    * Default constructor that does nothing
    * @param n
    * @param s
    * @param cP
    */
    public Stock() {
    }
    /**
    * Sets the private variables to the given values
    * @param n
    * @param s
    * @param cP
    * @param nP
    */
    public Stock(String n, String s, double cP) {
        companyName = n;
        companySymbol = s;
        currentPrice = cP;	
    }
    /**
    * This sets the company name to the given string
    * @param n
    */
    public void SetName(String n){
        companyName = n;//Assigns the name to the private variable
    }
    /**
    * This sets the company symbol to the given string
    * @param s
    */
    public void SetSymbol(String s) {
        //Assigns the symbol to the private variable
        companySymbol = s;
    }
    /**
    * This sets the current price to the given double
    * @param cP
    */
    public void SetCurrentPrice(double cP) {//Error Checking for: currentPrice > 0, 
        if(cP > 0) {//set the value to the variable; 
            currentPrice = cP;//otherwise set to 1
        }
        else {
            currentPrice = 1;
        }	
    }															
    /**
    * This sets the output file name as the given string
    * @param s
    */
    public void SetOutputFileName(String s) {
        outputFileName = s;
    }
    /**
    * This sets the input file name as the given string if the file exists
    * @param s
    */
    public void SetInputFileName(String s) { 
        File file = new File(s);
        if(file.isFile()) {
            inputFileName = s;	
        }
        else {
            System.out.print("Invalid!");//prints an error message
            System.exit(1004);
        }	
    } 					
    /**
    * This returns the company name 
    * @return
    */
    public String GetName() {
        return companyName;//returns the company's name
    }
    /**
    * This returns the company symbol
    * @return
    */
    public String GetSymbol() {
        return companySymbol;//returns the company's symbol
    }
    /**
    * This returns the current price
    * @return
    */
    public double GetCurrentPrice() {
        return currentPrice;//returns the current price of the company
    }
    /**
    * This returns the output file name
    * @return
    */
    public String GetOutputFileName() {
        return outputFileName;
    }
    /**
    * This returns the input file name
    * @return
    */
    public String GetInputFileName() {
        return inputFileName;
    }
    /**
    * This finds & prints out to the console and the output file the sum of the stock prices
    * @param o//Array Object
    * @param fileName
    * @throws IOException
    */
    public void FindSum(Stock [] o, PrintWriter fo) throws IOException {		
        double sum = 0;//Declares the double used as the sum and initializes it to 0.
        for(int i=0; i<o.length; i++) {//Finds the sum of the stock prices
                                           //while the counter is less than the array
                                           //length and sets it as the double variable
            sum+=o[i].GetCurrentPrice();
        }
        fo.printf("The sum: %.2f\r\n", sum);
        System.out.printf("The sum: %.2f\n", sum);
    }
    /**
    *Finds and prints out to the console and the output file the average of the stock prices
    * @param o//Array Object
    * @param fileName
    * @throws IOException
    */
    public void FindAverage(Stock [] o, PrintWriter fo) throws IOException {		
        double sum = 0;//Declares the double used as the sum and initializes it to zero
        double average;//Declares the double used as the average
        for(int i=0; i<o.length; i++) {
            sum+=o[i].GetCurrentPrice();
        }
        average = sum/o.length;//Finds the average and sets it as the double variable
        fo.printf("The average: %.2f\r\n", average);//prints the average to the console and file
        System.out.printf("The average: %.2f\n", average);
    }
    /**
    * This finds and prints out to the console and output file the highest stock price
    * @param o//Array Object
    * @param fileName
    * @throws IOException
    */
    public void FindHighestPriceStock(Stock [] o, PrintWriter fo) throws IOException {
        String highest = new String();//This declares and initializes the 
                                     //string object for the name of the 
                                    //highest priced stock
        int index = 0;//Declares the integer variable for the index and initialzes to 0.
        double value = 0;//Declares the double variable for the value and initializes it to 0.
        for(int i = 0; i<o.length; i++) {//Sets the value to the highest stock price while the
                                         //Counter is less than the object array length
            if(o[i].GetCurrentPrice() > value) {
                //Sets 1st variable to the currentprice in the given element of the object array
                value = o[i].GetCurrentPrice();
                index = i;//Sets the second variable to the current index
            }
        }					
        highest = o[index].GetName();//This occurs if the current price forthe current element
                                    //for the array is greater than the value variable.												
                                   //This sets the variable for the highest priced stock
                                  //as the stock name of the given element of the object 
                                 //array
            
        fo.println("The Stock with the highest price: " +highest+"\r\n");
        //Prints the name of the highest priced stock on the console and the output file
        System.out.println("The Stock with the highest price: " +highest+"\n");
    }	
    /**
    * This finds and prints out to the console and output file the highest stock price
    * @param o//Array Object
    * @param fileName
    * @throws IOException
    */
    public void FindLowestPriceStock(Stock [] o, PrintWriter fo) throws IOException {
        //Declares and initializes the string object for the name of the lowest priced stock
        String lowest = new String();
        int index = 0;//Declares the integer variable for the index and initializes it to 0. 
        double value = o[0].GetCurrentPrice();//This declares the double variable 
                                                 //for the value and initializes it to the 
                                                //current price of the first element
            
        for(int i = 0; i<o.length; i++) {//Sets the value to the highest stock price while
                                        //the counter is less than the object array length
            if(o[i].GetCurrentPrice() < value) {//This sets the first variable to 
                value = o[i].GetCurrentPrice();//the current price in the given element
                index = i;//variable to the current index
            }
        }
        lowest = o[index].GetName(); 
        //This sets the variable for the lowest priced stock as the stock name of the
        //given element of the object array.
           
        //Prints out the name of the lowest priced stock onto the console and the output file
        fo.println("The Stock with the lowest price: " +lowest +"\r\n");
        System.out.println("The Stock with the lowest price: " +lowest);
    }
    /**
    * This reads the file and places the contents in a string array
    * @param f
    * @return
    * @throws IOException
    */
    public String [] ReadFile (String f) throws IOException{
        File test = new File(f);
        File file = new File(f);//Reading of the file						
        String count = new String();
        Scanner file_input_1 = new Scanner(test);//This accepts the input of the 
                                                //counting and reading file objects
        Scanner file_input_2 = new Scanner(file);
        int i = 0; 
    
        while(file_input_1.hasNext()){ //This counts the number of lines
            count = file_input_1.nextLine().trim();//by accepting the input of each line
            if(!(count.isEmpty())) {//and, if the line is not blank, 
                i++;//incrementing the counter variable
            }	
        }		
        file_input_1.close();
        //Determines if the number of stocks is too small or too large
        if(i<MIN_NUMBER_OF_STOCKS){
            String [] a = new String[]{"There are not enough stocks for the program."};
            file_input_2.close();
            return a;		
        }
        else if(i>MAX_NUMBER_OF_STOCKS) {
            String [] a = new String[]{"There are too many stocks for the program."};
            file_input_2.close();
            return a;
        }
        //This stores the strings of each line in each element of the array
        String [] array = new String [i];
        i=0;//This reinitializes the counting variable in order to start from the first 
            //element of the string array.	
        while(file_input_2.hasNext()) {//This accepts the file input 
            count = file_input_2.nextLine().trim();//and stores it in each array 
            if(!(count.isEmpty())) {//element of the string array
                array [i] = count;
		i++;
            }
        }													
	file_input_2.close();
	return array;
    }
    /**
    * This sets the stock information of the object array as the information from the file
    * and returns that object array
    * @param f
    * @return
    * @throws IOException
    */
    public Stock [] StockInformation(String f, PrintWriter a) throws IOException {
        Stock object = new Stock();//This declares and initializes the stock object
        String [] stock_file = object.ReadFile(f);//This declares a string array 
                                                  //and strings from the file
                                                 //of the given name this declares and 
                                                //initializes the stock array to the
                                               //string array length
        if(stock_file[0] == "There are too few stocks for the program." || 
        stock_file[0] == "There are too many stocks for the program.") {
            System.out.println(stock_file[0]);
            a.print(stock_file[0] + "\r\n");
            System.exit(10007);
        }
        Stock [] array = new Stock[stock_file.length];//This declares and initializes
                                                    //the stock array to the string array length
        String delim = "[,]";//Declares the String delimiter and initializes it as a comma 
                            //used to indicate what character the string should be parsed
        for(int i=0; i<stock_file.length; i++) {   //This sets the name, symbol, and current 
                                                   //price of each stock while
                                                   //the counter is less than the length 
                                                   //of the string array.
            String [] stock_info = stock_file[i].split(delim);//This declares a string array 
                                                             //and sets it equal to the element
                                                            //of the stock string array parsed
            array[i] = new Stock();//This initializes the given element of the stock array
            array[i].SetName(stock_info [0]);//Set the name, symbol,and the price of the stock 
            array[i].SetSymbol(stock_info [1]);
            array[i].SetCurrentPrice(Double.parseDouble(stock_info[2]));
        }
        return array;
    }
}