package lab.cse;

import java.util.*;
import java.io.*;


public class QuickSort {
	static int [] a;
	static int n;
	static boolean flag = true;
	public static void quickSort(int [] a, int low, int high) {
		int i = low, j = high, temp;
		int pivot = a[(low+high)/2];
		if(flag) {
			while(i<=j) {
				while(a[i]<pivot)
					i++;
				while(a[j]>pivot)
					j--;
				if(i<=j) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
					i++;
					j--;
				}
			}
			if(low<j)
				quickSort(a,low,j);
			if(i<high)
				quickSort(a,i,high);
		}
		else {
			while(i<=j) {
				while(a[i]>pivot)
					i++;
				while(a[j]<pivot)
					j--;
				if(i<=j) {
					temp = a[j];
					a[i] = a[j];
					a[j] = temp;
					i++;
					j--;
				}
			}
			if(low<j)
				quickSort(a,low,j);
			if(i<high)
				quickSort(a,i,high);
		}
	}
	public static void main(String[] args) {
		int i;
		long startTime, endTime;
		Scanner read = new Scanner(System.in);
		Random random = new Random();
		PrintWriter out;
			try {
				out = new PrintWriter(new File("Random.txt"));
				System.out.println("Enter the number of elements : ");
				n = read.nextInt();
				a = new int[n];
				for(i=0;i<n;i++) {
					a[i] = random.nextInt(n)+1;
					out.print(a[i]+"\t");
				}
				System.out.println("The total number generated : "+i);
				out.close();
				startTime = System.nanoTime();
				quickSort(a,0,n-1);
				endTime = System.nanoTime()-startTime;
				PrintWriter outA;
				outA = new PrintWriter(new File("Ascending.txt"));
				for(i=0;i<n;i++)
					outA.print(a[i]+"\t");
				outA.close();
				System.out.println("The time complexity for worst case is... "+(endTime/100000000.0)+" secs");
				startTime = System.nanoTime();
				quickSort(a,0,n-1);
				endTime = System.nanoTime()-startTime;
				System.out.println("The time complexity for best case is..."+(endTime/100000000.0)+" secs");
				flag = false;
				startTime = System.nanoTime();
				quickSort(a,0,n-1);
				endTime = System.nanoTime()-startTime;
				PrintWriter outD;
				outD = new PrintWriter(new File("Descending.txt"));
				for(i=0;i<n;i++)
					outD.print(a[i]+"\t");
				outD.close();
				System.out.println("The time complexity for average case is..."+(endTime/100000000.0)+" secs");
				} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			read.close();
	}
}