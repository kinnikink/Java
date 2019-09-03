/*
 * HW3: Page 221: Number R-5.7: Describe a recursive algorithm for computing the nth Harmonic number, defined
as Hn = ∑n k=1 1/k.
 */

public class Recursive_Harmonic_Number {
    private int number;
    
    //Constructor
    public Recursive_Harmonic_Number(int n) {
        number = n;
    }//closes Recursive_Harmonic_Number    
    
    //Recursive Calculations
    public static double harmonic(int n) {  
        if(n == 1) {
            return 1.0;
	}//closes if statement on line 16 
        else {
            return (1.0 / n) + harmonic(n - 1);
	}//closes else statement on line 19
    }//closes harmonic
}//closes Recursive_Harmonic_Number class
        