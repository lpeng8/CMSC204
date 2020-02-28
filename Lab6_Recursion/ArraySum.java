package Lab5_Recursion;

public class ArraySum {
	
	
 public int sumOfArray(Integer[] arr, int n) {
	
	 if(n < 0)
		 return 0;
	 else { 
		 Integer [] temp=new Integer [n];;
		 for (Integer i =0; i<n;i++)
			 temp[i]=arr[i];
		 return arr[n]+ sumOfArray(temp, n-1);
	 }
	 }
 }

