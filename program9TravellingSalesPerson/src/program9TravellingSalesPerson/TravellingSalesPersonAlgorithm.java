package program9TravellingSalesPerson;
import java.util.*;
public class TravellingSalesPersonAlgorithm {
	static int [][] cost = new int [20][20];
	static int []  visited = new int [20];
	static int n, mincost;
	
	static int Tsp_Dynamic(int i, int copy[]) {
		int min = 9999, val, j;
		int []s = new int [20];
		boolean flag = false;
		
		for(j=1;j<=n;j++)
			s[j] = copy[j];
		s[i] = 1;
		if(n==1) 
			return cost[i][1];
		for(j=1;j<=n;j++) {
			if(s[j]==0) {
				flag = true;
				val = cost[i][j] + Tsp_Dynamic(j,s);
				if(val<min)
					min = val;
			}
		}
		if(!flag)
			min = cost[i][1];
		return min;
	}
	public static void main(String[] args) {
		int i, j;
		Scanner read = new Scanner(System.in);
		System.out.println("Enter the number of cities : ");
		n = read.nextInt();
		System.out.println("Enter the cost adjacency matrix : ");
		for(i=1;i<=n;i++)
			for(j=1;j<=n;j++)
				cost[i][j] = read.nextInt();
		mincost = Tsp_Dynamic(1,visited);
		System.out.println("The cost of optimal tour is  : "+mincost );
	}
}
