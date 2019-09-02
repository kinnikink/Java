import java.util.*;

public class Lab_1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double max_val = Double.MIN_VALUE;//initialize the minimum value variable
        double min_val = Double.MAX_VALUE;//initialize the maximum value variable

        int count = 0;//sets the intitial count to 0
        double totalValue = 0;//sets the initial totoal value to 0

        System.out.println("Enter values until a non-number is given");//instruction message for user
        
        while (input.hasNextDouble()) { 
            double value = input.nextDouble();
            if (value > max_val) {
                max_val = value;
            }
            if (value < min_val) {
                min_val = value;
            }
            count++;
            totalValue += value;
        }
        if (count > 0) {
            double average = totalValue / count;
            System.out.println("Number of values = " + count);//prints the values the user inputs
            System.out.println("Maximum = "  + max_val);//prints out the maximum  value the user inputs
            System.out.println("Minimum = "  + min_val);//prints out the minimum value the user inputs
            System.out.println("Average = "  + average);//prints the average of all values the user inputs
        } 
        else {
            System.out.println("Error: You did not enter a valid number!");//error message if the user does not input a valid number
        }
    }
}