package lab.cse;
import java.util.Scanner;
import java.util.Random;
public class MergeSort {
	static final int MAX = 10005;
	static int[]  a =  new int [MAX];
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter MAX array size : ");
		int n = input.nextInt();
		Random random = new Random();
		for(int i=0;i<n;i++)
			a[i] = random.nextInt(1000);
//		for(int i=0;i<n;i++)
//			System.out.print(a[i]+" ");
//		System.out.println();
		long startTime = System.nanoTime();
		mergeSortAlgorithm(0,n-1);
		long endTime = System.nanoTime();
		long elapsedTime = endTime - startTime;
		System.out.println("Time Complexity for n = "+n+" is "+(double)elapsedTime/1000000+" ms.");
		System.out.print("Sorted Array (Merge Sort) is : ");
		for(int i=0;i<n;i++)
			System.out.print(a[i]+" ");
		input.close();
	}
	public static void mergeSortAlgorithm(int low, int high) {
		int mid;
		if(low<high) {
			mid = (low+high)/2;
			mergeSortAlgorithm(low,mid);
			mergeSortAlgorithm(mid+1,high);
			merge(low,mid,high);
		}
	}
	public static void merge(int low, int mid, int high) {
	    int[] b = new int[MAX];
	    int i, j, k, h;
	    j = mid + 1;
	    i = h = low;
	    b[i] = 0;
	    while ((h <= mid) && (j <= high)) {
	        if (a[h] < a[j]) {
	            b[i++] = a[h++];
	        } else {
	            b[i++] = a[j++];
	        }
	    }
	    if (h >mid) {
	        for (k = j; k <= high; k++)
	            b[i++] = a[k];}
	     else 
	        for (k = h; k <= mid; k++) 
	            b[i++] = a[k];
	     for (k = low; k <= high; k++) 
	            	a[k] = b[k];
	        
	        }
}