package lab.cse;

import java.util.Random;

public class SelectionSort {
	public static void selectionSort(int []arr) {
		int n = arr.length;
		for(int i=0;i<n-1;i++) {
			int minIndex = i;
			for(int j=i+1;j<n;j++) {
				if(arr[j]<arr[minIndex])
					minIndex = j;
			}
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
	}
	public static void main(String[] args) {
		int [] nValues = {5000,10000,15000,20000,25000};
		long [] timeTaken = new long [nValues.length];
		for(int i=0;i<nValues.length;i++) {
			int n = nValues[i];
			int [] arr = generateRandomNumbers(n);
			long startTime = System.nanoTime();
			selectionSort(arr);
			long endTime = System.nanoTime();
			long duration = (endTime - startTime)/1000000;
			timeTaken[i] = duration;
			System.out.println("Time taken to sort "+n+" elements: "+timeTaken[i]+" milliseconds");
		}
	}
	private static int[] generateRandomNumbers(int n) {
		int [] nums = new int[n];
		Random random = new Random();
		for(int i=0;i<n;i++)
			nums[i] = random.nextInt();
		return nums;
	}
}
