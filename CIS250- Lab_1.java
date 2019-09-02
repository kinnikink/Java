import java.util.*;

public class Lab_1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double max_val = Double.MIN_VALUE;
        double min_val = Double.MAX_VALUE;

        int count       = 0;
        double totalValue = 0;

        System.out.println("Enter values until a non-number is given");
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
            System.out.println("Number of values = " + count);
            System.out.println("Maximum = "  + max_val);
            System.out.println("Minimum = "  + min_val);
            System.out.println("Average = "  + average);
        } 
        else {
            System.out.println("Error: You did not enter a valid number!");
        }
    }
}