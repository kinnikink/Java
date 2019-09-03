/*
 * HW3: Page 221: Number R-5.7: Describe a non-recursive algorithm for computing the nth Harmonic number, defined
as Hn = ∑n k=1 1/k.
 */
public class NonRecursive_Harmonic_Number {
	
    private int number;
	
    public NonRecursive_Harmonic_Number(int n) {
        number = n;
    }//closes NonRecursive_Harmoonic_Number method	
	
    public double NonRecursive_Generation(int num) {
        // compute 1/1 + 1/2 + 1/3 + ... + 1/x
	double sum = 0.0;
	for (int i = 1; i <= num; i++) {
            //sum += 1.0 / i;
	    sum = sum + (1.0/i);
	}//closes for loop on line 12
	return sum;	
    }//closes NonRecursive_Generation
}//closes NonRecursive_Harmonic_Number class
