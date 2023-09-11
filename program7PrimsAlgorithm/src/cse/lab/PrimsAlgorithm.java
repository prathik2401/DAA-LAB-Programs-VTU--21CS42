package cse.lab;
import java.util.*;
public class PrimsAlgorithm {
	public static void main(String[] args) {
		int n, i, j;
		int [][]cost  = new int [10][10];
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of Vertices : ");
		n = sc.nextInt();
		System.out.println("Enter the cost adjacency matrix : ");
		for(i=1;i<=n;i++)
			for(j=1;j<=n;j++)
				cost[i][j] = sc.nextInt();
		prims(cost,n);
	}
	static void prims(int cost[][], int n) {
		int [] v= new int [10];
		int min, p, q, i, j, flag = 0, mincost = 0, noe = 1;
		for(i=1;i<=n;i++)
			v[i] = 0;
		v[1] = 1;
		System.out.println("The spanning tree has the following edges : ");
		while(noe!=n) {
			min = 9999;
			i = j = -1;
			flag = 0;
			for(p=1;p<=n;p++)
				for(q=1;q<=n;q++) {
					if(p==q)
						continue;
					if((cost[p][q]<min) && (v[p]==1) && (v[q]!=1)) {
						min = cost[p][q];
						i = p;
						j = q;
						flag = 1;
					}
				}
			if(flag==0) {
				System.out.println("Graph is disconnected.\n");
				System.exit(0);
			}
			if(i != -1) {
				v[j] = 1;
				System.out.println("("+i+","+j+") = " + cost[i][j]);
				mincost += cost[i][j];
				noe++;
			}
		}
		System.out.println("Cost of Spanning tree : "+mincost);
	}
}
