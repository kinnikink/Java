import java.io.*;

public class Stock {
    private String time_stamp;//string that contains the time stamp of the stock
    private double closing_price;//double that holds the closing price for the stock
    private double highest_price;//double that holds the highest price for the stock
    private double lowest_price;//double that holds the lowest price for the stock
    private double opening_price;//double that holds the opening Price of Stock
    private double volumeOfStocks;//double that holds the number of stocks in circulation
    private String output_file_name;//string that contains the name of the output file
    private String input_file_name;//string that contains the name of the input file
    
    /**
    * This sets the private variables to the default
    */
    public Stock() {
        time_stamp = "00:00";
        closing_price = 0;
        highest_price = 0;
        lowest_price = 0;
        opening_price = 0;
        volumeOfStocks = 0;
	output_file_name = "outputName";
	input_file_name = "inputName";
		
    }
    /**
    * This sets the time stamp to the given string
    * @param n
    */
    public void settime_stamp(String t){
        time_stamp = t;
    }
    /**
    * Sets the closing price to the given double
    * @param c
    */
    public void setclosing_price(double c) {
        closing_price = c;
    }
    /**
    * Sets the highest price to the given double
    * @param h
    */
    public void sethighest_price(double h) {
        highest_price = h;
    }
    /**
    * Sets the lowest price to the given double
    * @param l
    */
    public void setlowest_price(double l) {
        lowest_price = l;
    }
    /**
    * Sets the opening price to the given double
    * @param o
    */
    public void setopening_price(double o) {
        opening_price = o;
    }
    /**
    * Sets the number of stocks in circulation to the given double
    * @param v
    */
    public void setVolumeOfStocks(double v) {
        volumeOfStocks = v;
    }
    /**
    * Sets output file name to the given string
    * @param s
    */
    public void Setoutput_file_name(String s) {
        output_file_name = s;
    }
    /**
    * Sets input file name to the given string
    * @param s
    */
    public void Setinput_file_name(String s) {
        input_file_name = s;
    }
    /**
    * This returns the time stamp to the given string 
    * @return
    */
    public String gettime_stamp() {
        return time_stamp;
    }
    /**
    * Returns the closing price
    * @return
    */
    public double getclosing_price() {
        return closing_price;
    }
    /**
    * This returns the highest price
    * @return
    */
    public double gethighest_price() {
        return highest_price;
    }
    /**
    * Returns the lowest price
    * @return
    */
    public double getlowest_price() {
        return lowest_price;
    }
    /**
    * This returns the opening price
    * @return
    */
    public double getopening_price() {
        return opening_price;
    }
    /**
    * Returns the volume of stocks in circulation
    * @return
    */
    public double getVolumeOfStocks() {
        return volumeOfStocks;
    }
    /**
    * Returns the output file name
    * @return
    */
    public String getoutput_file_name() {
        return output_file_name;
    }
    /**
    * Returns the input file name
    * @return
    */
    public String getinput_file_name() {
        return input_file_name;
    }	
    /**
    * This prints the Headers
    * @param f
    */
    public void printHeaders(PrintWriter f) {
        f.println("TIMESTAMP,CURRENT_PRICE,SHARES,P/L_PERCENT,PROFIT/LOSS,REALIZED_PROFIT/LOSS,HOLD/NONE,PURCHASE/SELL_PRICE,PURCHASE_COST");
    }	
}