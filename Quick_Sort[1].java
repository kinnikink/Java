/* HW4 Page527 P-12.62: Implement deterministic and randomized versions of the quick-sort algorithm
and perform a series of benchmarking tests to see which one is faster. Your tests
should include sequences that are very “random” looking as well as ones that are
“almost” sorted.*/


public class Quick_Sort  
{  
	public static void main(String[]args)  
    {
		int i;
		int array[] = {1,96,44,3,23,9,7,10,8,11,15,22,12,54,32,58,36,5,2,6};
		int array2[] = {1,0,2,4,3,6,8,7,9,10,15,23,47,34,56,63,112,97,67,111,115,120};
		
		System.out.println("Elements Before Sort:");  
		for(i = 0; i < array.length; i++){  
			System.out.print( array[i]+" ");
		}
		System.out.println(); 

        System.out.println("Elements After Sort:");
        
        long startTime1 = System.nanoTime();
        quickSortLast(array,0,array.length-1);
        long endTime1 = System.nanoTime();
        long duration1 = endTime1 - startTime1;
        for(i = 0; i < array.length; i++){
        	System.out.print( array[i]+" ");  
        }
        System.out.println();
        System.out.println("Duration time: " + duration1 +"ns");
        
        
        System.out.println("-------------------------------------");
        
        System.out.println("Elements Before Sort:");  
        for(i = 0; i < array2.length; i++){
        	System.out.print( array2[i]+" ");  
        }
        System.out.println();
        
        System.out.println("Elements After Sort:");
        long startTime = System.nanoTime();
        quickSortMiddle(array2,0,array2.length-1);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        
        for(i = 0; i < array2.length; i++){  
        	System.out.print( array2[i]+" ");  
        }
        
        System.out.println();
        System.out.println("Duration time: " + duration +"ns");
    }  
 
	public static void quickSortMiddle(int a[],int low, int len)  
	{  
		if(low>=len) return; // checking if length of the array is Zero.   
		int l=low,n=len; //initialization  
		int piv=a[(l+n)/2]; // middle element  
		//int piv = a[n-1];
		while(l<n){
			//moving upto less than pivot value from start.   
            while(l<n && a[l]<piv)   
				l++;   
            //moving upto greater than pivot value from end. 
			while(l<n && a[n]>piv)  
				n--;   
            //swap in order to move least elements to left and maximum to right of the pivot.   
            if(l<n){  
				int tem = a[l];  
				a[l]=a[n];  
				a[n]=tem;
			}             
		}// end of while loop
		if(n<l){// checking start and end index(start must be less than end otherwise swap)   
		  
			int t = l;l=n;n=t;   
		}  
		quickSortMiddle(a,low,l);// sort left part of the array.   
		quickSortMiddle(a,l==low?l+1:l,len); //sorting right part of the array  
	}
 
 
	public static void quickSortLast(int a[],int low, int len){  
		if(low>=len) return; // checking if length of the array is Zero.   
		int l=low,n=len; //initialization  
		//int piv=a[(l+n)/2]; // middle element  
		int piv = a[n-1];
		while(l<n){  
		 //moving upto less than pivot value from start.   
            while(l<n && a[l]<piv)   
				l++;   
             //moving upto greater than pivot value from end.   
            while(l<n && a[n]>piv)  
				n--;   
             //swap in order to move least elements to left and maximum to right of the pivot.   
            if(l<n){  
				int tem = a[l];  
				a[l]=a[n];  
				a[n]=tem;
			}             
		}// end of while loop 
		
		if(n<l){// checking start and end index(start must be less than end otherwise swap)   
			int t = l;l=n;n=t;   
		}  
		
		quickSortLast(a,low,l);// sort left part of the array.   
		quickSortLast(a,l==low?l+1:l,len); //sorting right part of the array  
	}

}  
