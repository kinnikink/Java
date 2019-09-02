import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class AlgorithmTrader {
    private double percentage_OfRevenue;//percentage increase from the revenue
    private double actual_revenue;//revenue that the user gains after selling the stocks
    private double revenue;//revenue that is possible if the user were to sell
    private double current_valueOfTotal;//value of a the total value of the stocks held
    private double purchase_sellPrice;//value of the stocks sold or bought
    private double purchase_cost;//cost of each stock that was bought
    private int held_stocks;//the number of stocks held
    private String holding_status;//the status that indicates whether or not stocks are being held
    final private int BUY_SIGNAL_THREASHOLD = 5;//constant that holds the number of increases for the entry strategy
    final private double SELL_SIGNAL_THREASHOLD = 0.0012;//constant that holds the percentage of profit or loss for the exit strategy
    /*
    * Constructor that sets the variables to default values
    */
    public AlgorithmTrader() {
	percentage_OfRevenue = 0;
	actual_revenue = 0;
	revenue = 0;
        current_valueOfTotal=0;
	purchase_sellPrice = 0;
	purchase_cost = 0;
        held_stocks = 0;
	holding_status = "NONE";
    }
    /**
    * Sets the percentage_OfRevenue to the given value
    * @param pr
    */
    public void Setpercentage_OfRevenue(double pr) {
        percentage_OfRevenue = pr;
    }
    /**
    * Sets the actual_revenue to the given value
    * @param ar
    */
    public void Setactual_revenue(double ar) {
        actual_revenue = ar;
    }
    /**
    * Sets the revenue to the given value
    * @param r
    */
    public void Setrevenue(double r) {
        revenue = r;
    }
     /**
    * Sets the current_ValueOfTotal to the given value
    * @param t
    */
    public void Setcurrent_valueOfTotal(double t) {
        current_valueOfTotal = t;
    }
    /**
    * Sets the setpurchase_sellPrice to the given value
    * @param psp
    */
    public void Setpurchase_sellPrice (double psp) {
        purchase_sellPrice = psp;
		
    }	
    /**
    * Sets the purchase_cost to the given value
    * @param pc
    */
    public void Setpurchase_cost (double pc) {
        purchase_cost = pc;
    }
    /**
    * Sets the held_stocks to the given value
    * @param n
    */
    public void Setheld_stocks(int n) {
        held_stocks = n;
    }	
    /**
    * Sets the holding_status to the given value
    * @param hs
    */
    public void setholding_status(String hs) {
        holding_status = hs;
    }
     /**
    * Returns the percentageOfRevenue
    * @return
    */
    public double Getpercentage_OfRevenue() {
        return percentage_OfRevenue;
    }
    /**
    * Returns the actualRevenue
    * @return
    */
    public double Getactual_revenue() {
        return actual_revenue;
    }
    /**
    * Returns the revenue
    * @return
    */
    public double getrevenue() {
        return revenue;
    }	
    /**
    * Returns the current_valueOfTotal
    * @return
    */
    
    public double getcurrent_valueOfTotal() {
        return current_valueOfTotal;
    }
    /**
    * Returns the purchaseSellPrice
    * @return
    */
    public double Getpurchase_sellPrice () {
        return purchase_sellPrice;	
    }	
    /**
    * Returns the purchaseCost
    * @return
    */
    public double Getpurchase_cost () {
        return purchase_cost;
    }	
    /**
    * Returns the heldStocks
    * @return
    */
    public int getheld_stocks() {
        return held_stocks;
    }
    /**
    * Returns the holdingStatus
    * @return
    */
    public String getholding_status() {
        return holding_status;
    }	
    /**
    * Prints a line of the current stock information
    * @param s
    * @param i
    * @param f
    */
    public void printResults(ArrayList<Stock> s, int i, PrintWriter f) {
        //prints results on the screen for user to see the Stock Price
        f.printf("%s,%.4f,%d,%f,$%.2f,$%.2f,%s,%.2f,$%.2f\r\n", s.get(i).gettime_stamp(), s.get(i).getclosing_price(), this.getheld_stocks(), this.Getpercentage_OfRevenue(), this.getrevenue(), this.Getactual_revenue(), this.getholding_status(), this.Getpurchase_sellPrice(), this.Getpurchase_cost());
    }	
    /**
    * Reads the data from the .csv input file into an object array
    * @param fName
    * @return
    * @throws IOException
    */
    public ArrayList<Stock> ReadInputData(String fName) throws IOException {
        //creates file objects for counting the lines and reading the input file
	File fileForCounting = new File(fName);
	File fileForReading = new File(fName);	
	//creates scanner objects for the files that will count the lines and read the file
	Scanner fCount = new Scanner(fileForCounting);
	Scanner fRead = new Scanner(fileForReading);
	//declares and initializes to 0 the integer variable used to keep track of the number of lines in the file
	int i=0;
	//declares the array list of the Stock class
	ArrayList<Stock> a = new ArrayList<Stock>(100);
	//declares and initializes to 0, the integer variable used to count the number of lines in the file
	int count = 0;//counts the number of lines until there are no lines left
        while(fCount.hasNextLine()) {//reads in the values and goes to next line
            fCount.nextLine();
            count++;//increments the count variable
	}	
	//declares a string array that will be used to accept the input of each line of the file
	String [] array = new String[count];	
	//reads in each line of the file into the string array as long as i is less than the count
	while(i<count) {
            array[i] = fRead.nextLine();
            //increments the i after reading in each line
            i++;
	}	
	//sets the string array to Stock object array list while i is less than the length of the array
	for(i=1; i<array.length; i++) {	
            //sets the string array to the string split into sub strings separated by commas in the given array element
            String [] stockRecords = array[i].split("[,]");		
            //declares the Stock class object and adds it to the new Stock array list
            Stock s = new Stock();			
            a.add(s);		
            //sets the given Stock array list elements setters of all the variables to the corresponding String array element
            a.get(i-1).settime_stamp(stockRecords[0]);
            a.get(i-1).setclosing_price(Double.parseDouble(stockRecords[1]));
            a.get(i-1).sethighest_price(Double.parseDouble(stockRecords[2]));
            a.get(i-1).setlowest_price(Double.parseDouble(stockRecords[3]));
            a.get(i-1).setopening_price(Double.parseDouble(stockRecords[4]));
            a.get(i-1).setVolumeOfStocks(Integer.parseInt(stockRecords[5]));
	}//closes for loop on line 185
	fCount.close();
	fRead.close();	
	//returns the stock array list
	return a;
    }//closes ReadInputData ArrayList on line 159	
    /**
    * Determines when to buy stock - sets default to false
    * @param s
    * @param num
    * @return
    */
    public boolean EntryStrategy(ArrayList<Stock> s, int num) {
        //sets the boolean variable to false
        boolean b = false;	
	//initiates the if else statements if the given number is less than the array list size -1
	if(num<s.size()-1 && num != 0){
            //if the current price is less than the next price and the held stocks is equal to 0, sets b = to true
            if(s.get(num).getclosing_price() > s.get(num-1).getclosing_price() && getheld_stocks() == 0){
                b =true;
            }
            //if no other conditions are satisfied, sets b = to false
            else {
                b = false;	
            }
	}
	return b;
    }
    /**
    * Determines when to sell the held stocks
    * @param s
    * @param num
    * @return
    */
    public boolean ExitStrategy(ArrayList<Stock> s, int num) {
        //declares and initializes the boolean value to false
        boolean b = false;	
        //the if statements will be initiated if the number is less than the array list size -1
	if(num<s.size()-1) {
            //if the percentage gain is equal to or greater than .0012 or the percentage loss is equal to or less than .0012 or the number is equal to the array list
            //of the Stock -2 and the held stocks is equal to 10,000, it sets b to true
            if(((s.get(num).getclosing_price() - this.Getpurchase_sellPrice())/this.Getpurchase_sellPrice() >=SELL_SIGNAL_THREASHOLD
                || ((s.get(num).getclosing_price() - this.Getpurchase_sellPrice())/this.Getpurchase_sellPrice()) <= -SELL_SIGNAL_THREASHOLD 
		|| num==s.size()-2)
		&& getheld_stocks() == 10000 ){
                    b = true;	
            }
            //if no other condition are met, it sets b to false
            else {
                b = false;
            }
	}//closes if statement on line 237
	return b;
    }
    /**
    * Runs the program according to the given parameters
    * @param fName
    * @param f
    * @throws IOException
    */
    public void Run(String fName, PrintWriter f) throws IOException{		
        //declares the array list of the Stock object
        ArrayList<Stock> stockFileData = new ArrayList<Stock>();	
	//sets input data to the array list of the Stock object to the stock data
	stockFileData = ReadInputData(fName);	
	//declares the boolean variables for the entry strategy and the exit strategy
	boolean entryBool;
	boolean exitBool;	
	stockFileData.get(0).printHeaders(f);	
	//declares and initializes integer variable used to count how many times the entryBool is true to 0
	int j=0;
	//runs the program while i is less than the array list size
	for(int i =0; i<stockFileData.size(); i++) {		
            //sets the entryBool and the exitBool to the booleans from the entryStrategy and the exitStrategy methods
            entryBool= EntryStrategy(stockFileData, i);
            exitBool = ExitStrategy(stockFileData, i);		
            //if entryBool is true, j is incremented
            if(entryBool) {
                j++;
            }
            //if no other condition is met, j is set to 0
            else {
                j=0;
            }		
            //if j is equal to 5
            if(j==BUY_SIGNAL_THREASHOLD) {
		Setcurrent_valueOfTotal(10000*stockFileData.get(i).getclosing_price());
		Setheld_stocks(10000);
		//sets the purchaseSellPrice to the closing price
		Setpurchase_sellPrice(stockFileData.get(i).getclosing_price());
		//sets the purchaseCost to the currentValueofTotal
		Setpurchase_cost(getcurrent_valueOfTotal());
		setholding_status("HOLD");
		j=0;
	}//closes if on line 288
	//if exitBool to true
	else if(exitBool) {
            //sets percentageOfRevenue to the closing price - (the original purchase price / by the original purchase price)
            Setpercentage_OfRevenue((stockFileData.get(i).getclosing_price()-Getpurchase_sellPrice())/Getpurchase_sellPrice());
            //sets the actual revenue to the closing price to the original purchase price
            Setactual_revenue(10000*(stockFileData.get(i).getclosing_price()-Getpurchase_sellPrice())+this.Getactual_revenue());
            Setrevenue(0);
            setholding_status("NONE");
            //sets the purchaseSellPrice to the closing price
            Setpurchase_sellPrice(stockFileData.get(i).getclosing_price());
            Setpurchase_cost(0);
            Setheld_stocks(0);
        }//closes else if on line 302
	//if i is greater than 0 and the holding status is equal to "HOLD", this sets revenue to closing price - the purchase price and sets the percentage of
	//the gain or loss to closing price - the purchase price divided by the purchase price
	else if(i>0 && getholding_status().equals("HOLD")) {
            Setrevenue(10000*(stockFileData.get(i).getclosing_price()-Getpurchase_sellPrice()));
            Setpercentage_OfRevenue((stockFileData.get(i).getclosing_price()-Getpurchase_sellPrice())/Getpurchase_sellPrice());	
	}//closes else if on line 320
	//prints the line of the current stock information to the output csv file
	printResults(stockFileData ,i, f);
	}
    }
}