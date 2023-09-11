package program10SumOfSubsets;
import java.util.*;
public class SumOfSubsetsAlgorithm {
	static int d, flag=0;
	static int []S = new int [10];
	static int []x = new int [10];
	
	static void sumOfSub(int s, int k, int r) {
		int i;
		x[k] = 1;
		
		if((s + S[k]) == d) {
			flag =1;
			for(i=1;i<=k;i++)
				if(x[i]==1)
					System.out.print(S[i] + "\t");
			System.out.println();
		}
		else 
			if(s+S[k] + S[k+1] <=d)
				sumOfSub(s+S[k],k+1,r-S[k]);
			if((s+r-S[k]>=d) && (s+S[k+1]<=d)) {
				x[k] = 0;
				sumOfSub(s,k+1,r-S[k]);
		}
	}
	public static void main(String[] args) {
		int i, n, sum =0;
		Scanner read = new Scanner(System.in);
		System.out.println("Enter the number of elements in the set : ");
		n =read.nextInt();
		System.out.println("Enter the set in increasing order : ");
		for(i=1;i<=n;i++)
			S[i] = read.nextInt();
		System.out.println("Enter the max subset value : ");
		d =read.nextInt();
		for(i=1;i<=n;i++)
			sum = sum + S[i];
		if(sum<d || S[1]>d)
			System.out.println("No subset possible.");
		else {
			System.out.println("The possible subsets are : ");
			sumOfSub(0,1,sum);
			if(flag==0)
				System.out.println("No subsets possible.");
		}
	}
}
