/* HW4 Pg 572 P-12.61: Perform a series of benchmarking tests on a version of merge-sort and quick-sort
to determine which one is faster. Your tests should include sequences that are
“random” as well as “almost” sorted.*/


import java.util.*;

public class Run_time {

	public static void main(String[] args) {
		Random r = new Random();
		//arrays with 20
		int[] someSortArray20 = {1, 2, 3, 4, 5, 6, 8, 7, 9, 10, 11, 12, 13, 14, 15, 16, 18, 17, 19, 20};
		int[] randArray20 = new int[20];
		for (int i = 0; i<20; i++) {
			randArray20[i]=r.nextInt(1000);
		}
		
		//arrays with 40
		int[] someSortArray40 = {1, 3, 2, 3, 4, 5, 6, 6, 4, 7, 8, 6, 7, 8, 9, 10, 11, 12, 14, 12, 13, 13, 14, 15, 16, 17, 18, 18, 17, 16, 19, 19, 20, 22, 21, 26, 25,27, 28, 30};
		int[] randArray40 = new int[40];
		for (int i = 0; i<40; i++) {
			randArray40[i]=r.nextInt(1000);
		}
		
		double start1 = System.nanoTime();
		QuickSort(someSortArray20, 0, someSortArray20.length-1);
		double end1 = System.nanoTime();
		double total1 = end1 - start1;
		
		System.out.println("The total time for a mostly sorted array with 20 elements, sorted with Quick Sort is :" + total1 + " nanoseconds.");
		
		double start3 = System.nanoTime();
		QuickSort(someSortArray40, 0, someSortArray40.length-1);
		double end3 = System.nanoTime();
		double total3 = end3 - start3;
		
		System.out.println("The total time for a mostly sorted array with 40 elements, sorted with Quick Sort is :" + total3 + " nanoseconds.");
		
		double start2 = System.nanoTime();
		QuickSort(randArray20, 0, randArray20.length-1);
		double end2 = System.nanoTime();
		double total2 = end2 - start2;
		
		System.out.println("The total time for a random array with 20 elements, sorted with Quick Sort is :" + total2 + " nanoseconds.");
		
		double start4 = System.nanoTime();
		QuickSort(randArray40, 0, randArray40.length-1);
		double end4 = System.nanoTime();
		double total4 = end4 - start4;
		
		System.out.println("The total time for a random array with 40 elements, sorted with Quick Sort is :" + total4 + " nanoseconds.");
		
		//NEW ARRAYS FOR MERGE SORT
		//arrays with 20
				int[] ssArray20 = {1, 2, 3, 4, 5, 6, 8, 7, 9, 10, 11, 12, 13, 14, 15, 16, 18, 17, 19, 20};
				int[] rArray20 = new int[20];
				for (int i = 0; i<20; i++) {
					rArray20[i]=r.nextInt(1000);
				}
				
				//arrays with 40
				int[] ssArray40 = {1, 3, 2, 3, 4, 5, 6, 6, 4, 7, 8, 6, 7, 8, 9, 10, 11, 12, 14, 12, 13, 13, 14, 15, 16, 17, 18, 18, 17, 16, 19, 19, 20, 22, 21, 26, 25,27, 28, 30};
				int[] rArray40 = new int[40];
				for (int i = 0; i<40; i++) {
					rArray40[i]=r.nextInt(1000);
				}
		
		double startA = System.nanoTime();
		MergeSort(ssArray20, 0, ssArray20.length-1);
		double endA = System.nanoTime();
		double totalA = endA - startA;
		
		System.out.println("The total time for a mostly sorted array with 20 elements, sorted with Merge Sort is :" + totalA + " nanoseconds.");
		
		double startB = System.nanoTime();
		MergeSort(ssArray40, 0, ssArray40.length-1);
		double endB = System.nanoTime();
		double totalB = endB - startB;
		
		System.out.println("The total time for a mostly sorted array with 40 elements, sorted with Merge Sort is :" + totalB + " nanoseconds.");
		
		double startC = System.nanoTime();
		MergeSort(rArray20, 0, rArray20.length-1);
		double endC = System.nanoTime();
		double totalC = endC - startC;
		
		System.out.println("The total time for a random array with 20 elements, sorted with Merge Sort is :" + totalC + " nanoseconds.");
		
		double startD = System.nanoTime();
		MergeSort(rArray40, 0, rArray40.length-1);
		double endD = System.nanoTime();
		double totalD = endD - startD;
		
		System.out.println("The total time for a random array with 40 elements, sorted with Merge Sort is :" + totalD + " nanoseconds.");
		
		//for(int i =0; i<rArray40.length; i++) {
		//System.out.println(rArray40[i]);}
		
	}
	//QUICK SORT________________________________________________
	
	private static void QuickSort(int arr[], int low, int high)
    {
        if (low < high)
        {
            int part = partition(arr, low, high);
            //recursive calls
            QuickSort(arr, low, part-1);
            QuickSort(arr, part+1, high);
        }
        
    }
	
	private static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high]; 
        int i = (low-1);
        for (int j=low; j<high; j++)
        {
        	if (arr[j] <= pivot)
            {
                i++;
                // swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
 
        // swap
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
 
        return i+1;
    }
	//MERGE SORT__________________________________
	
	private static void Merge(int arr[], int l, int m, int r)
    {
        // Find size of two subarrays
        int n1 = m - l + 1;
        int n2 = r - m;
 
        //temp arrays
        int Left[] = new int [n1];
        int Right[] = new int [n2];
 
        // fill arrays
        for (int i=0; i<n1; ++i)
            Left[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            Right[j] = arr[m + 1+ j];
 
 
        int i = 0;
        int j = 0;
        int k = l;
        while (i < n1 && j < n2)
        {
            if (Left[i] <= Right[j])
            {
                arr[k] = Left[i];
                i++;
            }
            else
            {
                arr[k] = Right[j];
                j++;
            }
            k++;
        }
 
        while (i < n1)
        {
            arr[k] = Left[i];
            i++;
            k++;
        }
 
        while (j < n2)
        {
            arr[k] = Right[j];
            j++;
            k++;
        }
    }
 
    private static void MergeSort(int arr[], int l, int r)
    {
        if (l < r)
        {
            //find mid
            int m = (l+r)/2;
 
            // recursive sort each half
            MergeSort(arr, l, m);
            MergeSort(arr , m+1, r);
 
            // Merge
            Merge(arr, l, m, r);
        }
        
    }

	
}
