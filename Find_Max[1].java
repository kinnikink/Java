/*
 * HW3:Page 221: Problem R-5.1: Implement a recursive algorithm for finding the maximum element in an array, A,
of n elements. What is your time complexity and space complexity?
 */

import java.util.Random;

public class Find_Max{
	public static void main(String[] args) {
            Random n = new Random();
            int[] myArray = new int[10];//sets the index of myArray to 10 elements
            int  index = 0;//sets initial array's index to 0
		
            for(int i = 0;i<myArray.length;i++){
                index = n.nextInt(10) + 1;//counter for taking the initial index of the array and incrementing the count
		myArray[i] += index;
            }//closes for loop on line 14
		
            for(int i = 0;i<myArray.length;i++){
                System.out.print("This array's element at index " + i + " = "+myArray[i] + "\n");
            }//closes for loop on line 19
		
            System.out.println("---------------------------------------------");//prints separation line 
            int max = findMax(myArray, myArray.length);
	    System.out.println("The maximum value in this array is: " + max);//print statement for maximum value
		
	}//closes main
	public static int findMax(int[] a, int index) {
            if (index == 1){
                return a[0];
	    }//closes if statement on line 29
            else {
                return max(findMax(a, index - 1), a[index - 1]);
            }//closes else statement on line 32
	}//closes findMax
	
	private static int max(int n1, int n2){
            if(n1 > n2){
                return n1;
	    }//closes if statement on line 38
            else {
                return n2;
	    }//closes else statement on line 41
	}//closes max		
}//closes Find_Max